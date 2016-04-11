/* REQ 1 & 2
 * The Priority Management Assistant (PMA):
 * currently allows the user to make an assignment and sucessfully save it to
 * the file. We have made many changes to the program to ensure that the program
 * at it's current state, won't break with invalid input.

 * REQ 3
 * The PMA is now capable of reading the previous written data from the file
 * to the list. The program will run and update its list from the list file
 * before the user starts adding information to the list. A second file is also
 * generated to keep track of these logs and acts as a failsafe in-case the
 * list file generated was deleted or moved.

 * REQ 4
 * Show the user all the tasks with (optional) additional information & allow
 * the user to delete assignments. DELETE THE ASSIGNMENTS BY TITLE.

 * REQ 5
 * The program will delete overdue assignments after the due date has passed.
 * The program will delete these overdue assignments on start-up.

 * REQ 6
 * The program will allow the user to edit any assignment, including any
 * specific content of that assignment.

 * REQ 7    --->    (IN GUI PROGRAM)
 * The program will allow the user to pick the priority of an assignent by
 * color.

 * REQ 8
 * The program will automatically order assignments by due date and priority,
 * before they are added to the list.

 * REQ 9
 * Create pop-ups for the assignments, where as the priority level determines
 * the color of the pop-up & the close-ness to the dealine determines the size
 * of the pop-ups. This part of the program must be able to run at different
 * time intervals than that of the program. This will be the "smart" part of the
 * program because of what it will require the program to do. In other words the
 * program will at random times look at the current time and compare that to the
 * items in the list and at 24, 12, 6, 3, 2, 1 hr notification times. The
 * program will have to know when to check the list and when to notify the user.

 * REQ 10
 * Create a dialog box that allows the user to enable & disable popups for
 * assignments.

 * REQ 11
 * Create & implement a GUI to easily configure and manage assignments.
 */

//Kyle Zeller

package prioritymanagementassistant;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Main {

    private static String name, filePath, fLocation, delFile, info, editInfo,
                          editContent, editSameChoice, line;
    private static int month, day, year, hour, minute, priority, numberOption;
    private static boolean create = true, numberFlag = false,
                           badInfoFlag = true, popup = false,
                           popupCapture = false;

    private static Background backgroundProcess = new Background();
    private static Assignment assignment;
    public static LocalDateTime timePoint = LocalDateTime.now();    // The current date and time (YYYY-MM-DDTHH:MM:SS.642)
    private static Scanner kb = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if(!backgroundProcess.isFile()) {   //this is the first run of the program & there will be a welcome message with a user prompt to give the file path
            System.out.println("Welcome I am your Priority Management Assistant");
            do {
                System.out.println("Would you like the list to be saved in your Desktop folder?\t" + ("Y / N"));    //setting a default saving location
                fLocation = kb.nextLine();
            } while (!fLocation.equalsIgnoreCase("Y") && !fLocation.equalsIgnoreCase("N"));
            
            if(fLocation.equalsIgnoreCase("Y")) {
                do {
                    System.out.println("Name Your List File???");
                    System.out.println("EX :\t" + "\"newFile\"");
                    line = kb.nextLine();

                    try {  // Catch errors in I/O if necessary.
                        badInfoFlag = false;
                        PrintWriter writer = new PrintWriter(("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\" + line + ".txt"), "UTF-8");
                    } catch(IOException e){
                        badInfoFlag = true;
                    }
                } while (line == null || badInfoFlag);
                filePath = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\" + line + ".txt";
            } else  {
                do {
                    System.out.println("Where Do You Want Your Assignments to Be Saved???");
                    System.out.println("Specify Path Name\t" + "\"C:\\\\person\\\\Desktop\\\\test\\\\newFile.txt\"");
                    line = kb.nextLine();

                    try {  // Catch errors in I/O if necessary.
                        badInfoFlag = false;
                        PrintWriter writer = new PrintWriter(line, "UTF-8");
                    } catch(IOException e){
                        badInfoFlag = true;
                    }
                } while (line == null || badInfoFlag);
                filePath = line;  //user specified path
            }
        } else {
            //method to read contents from the list file into the arraylist
            filePath = backgroundProcess.loadList();
            //remove all overdue assignments
            backgroundProcess.removeOnLoad();
        }
        
        //START-UP//    is EMPTY            FORCE          CASE 1:
        //if there are NO assignments, the user must make an assignment before getting other options.
        
        //START-UP//    CONTAINS stuff      OPTIONS        CASE 2:
        //if there are assignments, the user can use anything above.
        
        //CONTINUOUSLY//    check EMPTY     FORCE          CASE 3:
        //if the user at any time makes the list empty, force the user must make an assignment before getting other options.
        
        //CONTINUOUSLY//    check CONTAINS     OPTIONS     CASE 4:
        //if the user makes any N number of assignments at any time, they should get all the options even for just 1 assignment.
        
        outerloop:        //break only if the user is done with everything
        while(true){
            while(backgroundProcess.isNull()){    //CASE 1 & 3
                do{
                    try{
                        numberFlag = false;
                        System.out.println("\nHere Are Your Options\n");

                        System.out.println("\tOPTIONS:");
                        System.out.println("------------------------");
                        System.out.println("[0]\tQUIT");
                        System.out.println("[1]\tCREATE");

                        System.out.println("\nPLEASE SELECT A NUMBER");
                        
                        line = kb.nextLine();
                        numberOption = Integer.parseInt(line);
                    }catch(NumberFormatException e){
                        numberFlag = true;
                    }
                } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);

                if(numberOption == 0){
                    backgroundProcess.writeFile(filePath);    //write to & save file
                    backgroundProcess.createBackgroundFile(filePath);
                    break outerloop;
                }
                if(numberOption == 1){
                    do {
                        System.out.println("Please enter a name for your Assignment:");  //prompt user for task
                        name = kb.nextLine();
                    } while (name == null || name.contains("---") || backgroundProcess.isAssignmentPresent(name)); //prompt the user for no input
                    do {
                        System.out.println("What year is " + name + " due?");  //prompt user for year
                        line = kb.nextLine();

                        try {   //promt the user for an integer number
                            numberFlag = false;
                            year = Integer.parseInt(line);
                            badInfoFlag = false;

                            if(year < 2016){
                                System.out.println(year + " is not a valid Year, please enter a number greater than " + (timePoint.getYear()-1) + ".");
                            }
                            if(year < timePoint.getYear()){

                                badInfoFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            numberFlag = true;
                        }
                    } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                    do {
                        System.out.println("What month is " + name + " due? (1-12)");  //prompt user for month
                        line = kb.nextLine();

                        if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                            line = line.replaceFirst("0", "");
                        }

                        try {   //promt the user for an integer number
                            numberFlag = false;
                            month = Integer.parseInt(line);
                            badInfoFlag = false;

                            if(month < 1 || month > 12){
                               System.out.println(month + " is not a valid Month, please enter a number between 1 and 12.");
                               badInfoFlag = true;
                            }

                            if(month < 1 || month > 12 || (year == timePoint.getYear() && month < timePoint.getMonthValue())){
                                badInfoFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            numberFlag = true;
                        }
                    } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
                       do{
                           System.out.println("What day is " + name + " due? (1-31)");
                           line = kb.nextLine();
                           try {   //promt the user for an integer number
                                numberFlag = false;
                                day = Integer.parseInt(line);
                                badInfoFlag = false;
                                if(day < 1 || day > 31 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                    System.out.println(day + " is not a valid Day, please enter a number between 1 and 31.");
                                    badInfoFlag = true;
                                }
                            }catch (NumberFormatException e) {
                                numberFlag = true;
                        }
                       }while(line == null || numberFlag || badInfoFlag);
                    }else if(month == 4 || month == 6 || month == 9 || month == 11){
                       do{
                           System.out.println("What day is " + name + " due? (1-30)");
                           line = kb.nextLine();
                           try {   //promt the user for an integer number
                                numberFlag = false;
                                day = Integer.parseInt(line);
                                badInfoFlag = false;
                                if(day < 1 || day > 30 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                    System.out.println(day + " is not a valid Day, please enter a number between 1 and 30.");
                                    badInfoFlag = true;
                                }
                            }catch (NumberFormatException e) {
                                numberFlag = true;
                            }
                       }while(line == null || numberFlag || badInfoFlag);               
                    }else if(month == 2){
                       do{
                           System.out.println("what day is " + name + " due? (1-28)");
                           line = kb.nextLine();
                           try {   //promt the user for an integer number
                                numberFlag = false;
                                day = Integer.parseInt(line);
                                badInfoFlag = false;
                                if(day < 1 || day > 28 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                    System.out.println(day + " is not a valid Day, please enter a number between 1 and 28.");
                                    badInfoFlag = true;
                                }
                            }catch (NumberFormatException e) {
                                numberFlag = true;
                            }
                       }while(line == null || numberFlag || badInfoFlag);               
                    }
                    do {
                        System.out.println("What hour is " + name + " due? (1-24)");  //prompt user for hour
                        line = kb.nextLine();

                        if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                            line = line.replaceFirst("0", "");
                        }

                        try {   //promt the user for an integer number
                            numberFlag = false;
                            hour = Integer.parseInt(line);
                            badInfoFlag = false;

                            if(hour < 1 || hour > 24){
                                System.out.println(hour + " is not a valid Hour, please enter a number between 1 and 24.");
                            }
                            if(hour < 1 || hour > 24 || (day == timePoint.getDayOfMonth() && hour < timePoint.getHour())){

                                badInfoFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            numberFlag = true;
                        }
                    } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                    do {
                        System.out.println("What minute is " + name + " due? (1-59)");  //prompt user for minute
                        line = kb.nextLine();

                        if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                            line = line.replaceFirst("0", "");
                        }

                        try {   //promt the user for an integer number
                            numberFlag = false;
                            minute = Integer.parseInt(line);
                            badInfoFlag = false;

                            if(minute < 0 || minute > 59){
                                System.out.println(minute + " is not a valid Minute, please enter a number between 1 and 60.");
                            }
                            if(minute < 0 || minute > 59 || (hour == timePoint.getHour() && minute < timePoint.getMinute())){

                                badInfoFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            numberFlag = true;
                        }
                    } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                    do {
                        System.out.println("What is the priority of " + name + " (1-3)");  //prompt user for priority
                        line = kb.nextLine();
                        if(line == null){   //assign a default priority value for no input
                                priority = 1;
                            }
                        else{
                            try {   //promt the user for an integer number
                                numberFlag = false;
                                priority = Integer.parseInt(line);
                                badInfoFlag = false;
                                if(priority < 1 || priority > 3){
                                    System.out.println(priority + " is not a valid Priority, please enter a number between 1 and 3.");
                                    badInfoFlag = true;
                                }
                            } catch (NumberFormatException e) {
                                numberFlag = true;
                            }
                        }
                    } while (numberFlag || badInfoFlag);
                    assignment = new Assignment(name, month, day, year, hour, minute, priority, popup);
                    backgroundProcess.buildList(assignment);
                    backgroundProcess.sort(); //sort the list according to due date and priority just before saving the file
                }
            }

            while(!backgroundProcess.isNull()){   //CASE 2 & 4
                do{
                    try{
                        numberFlag = false;
                        System.out.println("\nHere Are Your Options\n");

                        System.out.println("\tOPTIONS:");
                        System.out.println("------------------------");
                        System.out.println("[0]\tQUIT");
                        System.out.println("[1]\tCREATE");
                        System.out.println("[2]\tDELETE");
                        System.out.println("[3]\tEDIT\t");
                        System.out.println("[4]\tVIEW\t");
                        
                        System.out.println("\nPLEASE SELECT A NUMBER");
                        
                        line = kb.nextLine();
                        numberOption = Integer.parseInt(line);
                    }catch(NumberFormatException e){
                        numberFlag = true;
                    }
                } while(line == null || numberFlag || numberOption > 4 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed

                if(numberOption == 0){
                    backgroundProcess.writeFile(filePath);    //write to & save file
                    backgroundProcess.createBackgroundFile(filePath); //IF THE FILE EXISTS THE CONTENTS OF IT MUST BE LOADED PRIOR TO RUNNING THE MAIN PROGRAM
                    break outerloop;
                }
                if(numberOption == 1){
                    do {
                        System.out.println("Please enter a name for your Assignment:");  //prompt user for task
                        name = kb.nextLine();
                    } while (name == null || name.contains("---") || backgroundProcess.isAssignmentPresent(name)); //prompt the user for no input
                    do {
                        System.out.println("What year is " + name + " due?");  //prompt user for year
                        line = kb.nextLine();

                        try {   //promt the user for an integer number
                            numberFlag = false;
                            year = Integer.parseInt(line);
                            badInfoFlag = false;

                            if(year < 2016){
                                System.out.println(year + " is not a valid Year, please enter a number greater than " + (timePoint.getYear()-1) + ".");
                            }
                            if(year < timePoint.getYear()){

                                badInfoFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            numberFlag = true;
                        }
                    } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                    do {
                        System.out.println("What month is " + name + " due? (1-12)");  //prompt user for month
                        line = kb.nextLine();

                        if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                            line = line.replaceFirst("0", "");
                        }

                        try {   //promt the user for an integer number
                            numberFlag = false;
                            month = Integer.parseInt(line);
                            badInfoFlag = false;

                            if(month < 1 || month > 12){
                               System.out.println(month + " is not a valid Month, please enter a number between 1 and 12.");
                               badInfoFlag = true;
                            }

                            if(month < 1 || month > 12 || (year == timePoint.getYear() && month < timePoint.getMonthValue())){
                                badInfoFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            numberFlag = true;
                        }
                    } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
                       do{
                           System.out.println("What day is " + name + " due? (1-31)");
                           line = kb.nextLine();
                           try {   //promt the user for an integer number
                                numberFlag = false;
                                day = Integer.parseInt(line);
                                badInfoFlag = false;
                                if(day < 1 || day > 31 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                    System.out.println(day + " is not a valid Day, please enter a number between 1 and 31.");
                                    badInfoFlag = true;
                                }
                            }catch (NumberFormatException e) {
                                numberFlag = true;
                        }
                       }while(line == null || numberFlag || badInfoFlag);
                    }else if(month == 4 || month == 6 || month == 9 || month == 11){
                       do{
                           System.out.println("What day is " + name + " due? (1-30)");
                           line = kb.nextLine();
                           try {   //promt the user for an integer number
                                numberFlag = false;
                                day = Integer.parseInt(line);
                                badInfoFlag = false;
                                if(day < 1 || day > 30 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                    System.out.println(day + " is not a valid Day, please enter a number between 1 and 30.");
                                    badInfoFlag = true;
                                }
                            }catch (NumberFormatException e) {
                                numberFlag = true;
                            }
                       }while(line == null || numberFlag || badInfoFlag);               
                    }else if(month == 2){
                       do{
                           System.out.println("what day is " + name + " due? (1-28)");
                           line = kb.nextLine();
                           try {   //promt the user for an integer number
                                numberFlag = false;
                                day = Integer.parseInt(line);
                                badInfoFlag = false;
                                if(day < 1 || day > 28 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                    System.out.println(day + " is not a valid Day, please enter a number between 1 and 28.");
                                    badInfoFlag = true;
                                }
                            }catch (NumberFormatException e) {
                                numberFlag = true;
                            }
                       }while(line == null || numberFlag || badInfoFlag);               
                    }
                    do {
                        System.out.println("What hour is " + name + " due? (1-24)");  //prompt user for hour
                        line = kb.nextLine();

                        if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                            line = line.replaceFirst("0", "");
                        }

                        try {   //promt the user for an integer number
                            numberFlag = false;
                            hour = Integer.parseInt(line);
                            badInfoFlag = false;

                            if(hour < 1 || hour > 24){
                                System.out.println(hour + " is not a valid Hour, please enter a number between 1 and 24.");
                            }
                            if(hour < 1 || hour > 24 || (day == timePoint.getDayOfMonth() && hour < timePoint.getHour())){

                                badInfoFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            numberFlag = true;
                        }
                    } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                    do {
                        System.out.println("What minute is " + name + " due? (1-59)");  //prompt user for minute
                        line = kb.nextLine();

                        if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                            line = line.replaceFirst("0", "");
                        }

                        try {   //promt the user for an integer number
                            numberFlag = false;
                            minute = Integer.parseInt(line);
                            badInfoFlag = false;

                            if(minute < 0 || minute > 59){
                                System.out.println(minute + " is not a valid Minute, please enter a number between 1 and 60.");
                            }
                            if(minute < 0 || minute > 59 || (hour == timePoint.getHour() && minute < timePoint.getMinute())){

                                badInfoFlag = true;
                            }
                        } catch (NumberFormatException e) {
                            numberFlag = true;
                        }
                    } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                    do {
                        System.out.println("What is the priority of " + name + " (1-3)");  //prompt user for priority
                        line = kb.nextLine();
                        if(line == null){   //assign a default priority value for no input
                                priority = 1;
                            }
                        else{
                            try {   //promt the user for an integer number
                                numberFlag = false;
                                priority = Integer.parseInt(line);
                                badInfoFlag = false;
                                if(priority < 1 || priority > 3){
                                    System.out.println(priority + " is not a valid Priority, please enter a number between 1 and 3.");
                                    badInfoFlag = true;
                                }
                            } catch (NumberFormatException e) {
                                numberFlag = true;
                            }
                        }
                    } while (numberFlag || badInfoFlag);
                    assignment = new Assignment(name, month, day, year, hour, minute, priority, popup);
                    backgroundProcess.buildList(assignment);
                    backgroundProcess.sort(); //sort the list according to due date and priority just before saving the file
                }
                if(numberOption == 2){
                    //prompt to delete
                    do {
                        //select a file to delete
                        System.out.println("Please enter the name of the task you'd like to delete");
                        delFile = kb.nextLine();
                    } while (backgroundProcess.removeTask(delFile));  //the user will be prompted again for invalid input
                    
                    backgroundProcess.sort(); //sort the list according to due date and priority just before saving the file
                }
                if(numberOption == 3){ //EDIT SELECTED
                    do{
                        try{
                            numberFlag = false;
                            System.out.println("\nHere Are Your Options\n");

                            System.out.println("\tOPTIONS:");
                            System.out.println("------------------------");
                            System.out.println("[0]\tASSIGNMENT");
                            System.out.println("[1]\tFILE");
                            System.out.println("\nPLEASE SELECT A NUMBER");
                            line = kb.nextLine();
                            numberOption = Integer.parseInt(line);
                        }catch(NumberFormatException e){
                            numberFlag = true;
                        }
                    } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed
                    if(numberOption == 0){  //EDIT ASSIGNMENT
                        do{
                            try{
                                numberFlag = false;
                                System.out.println("\nHere Are Your Options\n");

                                System.out.println("\tOPTIONS:");
                                System.out.println("------------------------");
                                System.out.println("[0]\tNAME");
                                System.out.println("[1]\tTIME");
                                System.out.println("[2]\tPRIORITY");
                                System.out.println("[3]\tPOPUPS");
                                System.out.println("\nPLEASE SELECT A NUMBER");
                                line = kb.nextLine();
                                numberOption = Integer.parseInt(line);
                            }catch(NumberFormatException e){
                                numberFlag = true;
                            }
                        } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed
                        if(numberOption == 0){  //EDIT NAME
                            //prompt to edit
                            do {
                                //select an assignment to edit
                                System.out.println("Please enter the name of the task you'd like to edit");
                                editInfo = kb.nextLine();
                            } while (!backgroundProcess.isAssignmentPresent(editInfo));  //the user will be prompted again for invalid input
                            do {    //THIS WILL RUN FOR AS LONG AS THE USER PREVIOUSLY WANTED TO EDIT THE SAME ASSIGNMENT SOME MORE
                                    //give a new name for the task
                                do {
                                    System.out.println("Please enter a name for your Assignment:");  //prompt user for task
                                    name = kb.nextLine();
                                } while (name == null || name.contains("---") || backgroundProcess.isAssignmentPresent(name)); //prompt the user for no input
                                assignment = backgroundProcess.getAssignment();
                                //set the name
                                assignment.setName(name);
                                do {    //run until user answers correctly
                                System.out.println("Would you like to change your assignment again??\t" + "Y | N");
                                editSameChoice = kb.nextLine();
                                } while(!editSameChoice.equalsIgnoreCase("Y") && !editSameChoice.equalsIgnoreCase("N"));
                            } while (editSameChoice.equalsIgnoreCase("Y"));
                        }
                        if(numberOption == 1){  //EDIT TIME
                            //prompt to edit
                            do {
                                //select an assignment to edit
                                System.out.println("Please enter the name of the task you'd like to edit");
                                editInfo = kb.nextLine();
                            } while (!backgroundProcess.isAssignmentPresent(editInfo));  //the user will be prompted again for invalid input
                            do {    //THIS WILL RUN FOR AS LONG AS THE USER PREVIOUSLY WANTED TO EDIT THE SAME ASSIGNMENT SOME MORE
                                //give a new due date for the task
                                do {
                                    System.out.println("What year is " + editInfo + " due?");  //prompt user for year
                                    line = kb.nextLine();

                                    try {   //promt the user for an integer number
                                        numberFlag = false;
                                        year = Integer.parseInt(line);
                                        badInfoFlag = false;

                                        if(year < 2016){
                                            System.out.println(year + " is not a valid Year, please enter a number greater than " + (timePoint.getYear()-1) + ".");
                                        }
                                        if(year < timePoint.getYear()){

                                            badInfoFlag = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        numberFlag = true;
                                    }
                                } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                                do {
                                    System.out.println("What month is " + editInfo + " due? (1-12)");  //prompt user for month
                                    line = kb.nextLine();

                                    if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                                        line = line.replaceFirst("0", "");
                                    }

                                    try {   //promt the user for an integer number
                                        numberFlag = false;
                                        month = Integer.parseInt(line);
                                        badInfoFlag = false;

                                        if(month < 1 || month > 12){
                                           System.out.println(month + " is not a valid Month, please enter a number between 1 and 12.");
                                           badInfoFlag = true;
                                        }

                                        if(month < 1 || month > 12 || (year == timePoint.getYear() && month < timePoint.getMonthValue())){
                                            badInfoFlag = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        numberFlag = true;
                                    }
                                } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                                if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
                                   do{
                                       System.out.println("What day is " + editInfo + " due? (1-31)");
                                       line = kb.nextLine();
                                       try {   //promt the user for an integer number
                                            numberFlag = false;
                                            day = Integer.parseInt(line);
                                            badInfoFlag = false;
                                            if(day < 1 || day > 31 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                                System.out.println(day + " is not a valid Day, please enter a number between 1 and 31.");
                                                badInfoFlag = true;
                                            }
                                        }catch (NumberFormatException e) {
                                            numberFlag = true;
                                    }
                                   }while(line == null || numberFlag || badInfoFlag);
                                }else if(month == 4 || month == 6 || month == 9 || month == 11){
                                   do{
                                       System.out.println("What day is " + editInfo + " due? (1-30)");
                                       line = kb.nextLine();
                                       try {   //promt the user for an integer number
                                            numberFlag = false;
                                            day = Integer.parseInt(line);
                                            badInfoFlag = false;
                                            if(day < 1 || day > 30 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                                System.out.println(day + " is not a valid Day, please enter a number between 1 and 30.");
                                                badInfoFlag = true;
                                            }
                                        }catch (NumberFormatException e) {
                                            numberFlag = true;
                                        }
                                   }while(line == null || numberFlag || badInfoFlag);               
                                }else if(month == 2){
                                   do{
                                       System.out.println("what day is " + editInfo + " due? (1-28)");
                                       line = kb.nextLine();
                                       try {   //promt the user for an integer number
                                            numberFlag = false;
                                            day = Integer.parseInt(line);
                                            badInfoFlag = false;
                                            if(day < 1 || day > 28 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth())){
                                                System.out.println(day + " is not a valid Day, please enter a number between 1 and 28.");
                                                badInfoFlag = true;
                                            }
                                        }catch (NumberFormatException e) {
                                            numberFlag = true;
                                        }
                                   }while(line == null || numberFlag || badInfoFlag);               
                                }
                                do {
                                    System.out.println("What hour is " + editInfo + " due? (1-24)");  //prompt user for hour
                                    line = kb.nextLine();

                                    if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                                        line = line.replaceFirst("0", "");
                                    }

                                    try {   //promt the user for an integer number
                                        numberFlag = false;
                                        hour = Integer.parseInt(line);
                                        badInfoFlag = false;

                                        if(hour < 1 || hour > 24){
                                            System.out.println(hour + " is not a valid Hour, please enter a number between 1 and 24.");
                                        }
                                        if(hour < 1 || hour > 24 || (day == timePoint.getDayOfMonth() && hour < timePoint.getHour())){

                                            badInfoFlag = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        numberFlag = true;
                                    }
                                } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                                do {
                                    System.out.println("What minute is " + editInfo + " due? (1-59)");  //prompt user for minute
                                    line = kb.nextLine();

                                    if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                                        line = line.replaceFirst("0", "");
                                    }

                                    try {   //promt the user for an integer number
                                        numberFlag = false;
                                        minute = Integer.parseInt(line);
                                        badInfoFlag = false;

                                        if(minute < 0 || minute > 59){
                                            System.out.println(minute + " is not a valid Minute, please enter a number between 1 and 60.");
                                        }
                                        if(minute < 0 || minute > 59 || (hour == timePoint.getHour() && minute < timePoint.getMinute())){

                                            badInfoFlag = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        numberFlag = true;
                                    }
                                } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
                                assignment = backgroundProcess.getAssignment();
                                //set the time
                                assignment.setMonth(month);
                                assignment.setDay(day);
                                assignment.setYear(year);
                                assignment.setHour(hour);
                                assignment.setMinute(minute);
                                do {    //run until user answers correctly
                                System.out.println("Would you like to change your assignment again??\t" + "Y | N");
                                editSameChoice = kb.nextLine();
                                } while(!editSameChoice.equalsIgnoreCase("Y") && !editSameChoice.equalsIgnoreCase("N"));
                            } while (editSameChoice.equalsIgnoreCase("Y"));
                        }
                        if(numberOption == 2){  //EDIT PRIORITY
                            //prompt to edit
                            do {
                                //select an assignment to edit
                                System.out.println("Please enter the name of the task you'd like to edit");
                                editInfo = kb.nextLine();
                            } while (!backgroundProcess.isAssignmentPresent(editInfo));  //the user will be prompted again for invalid input
                            do {    //THIS WILL RUN FOR AS LONG AS THE USER PREVIOUSLY WANTED TO EDIT THE SAME ASSIGNMENT SOME MORE
                                //give a new priority for the task
                                do {
                                    System.out.println("What is the priority of " + editInfo + " (1-3)");  //prompt user for priority
                                    line = kb.nextLine();
                                    if(line == null){   //assign a default priority value for no input
                                            priority = 1;
                                        }
                                    else{
                                        try {   //promt the user for an integer number
                                            numberFlag = false;
                                            priority = Integer.parseInt(line);
                                            badInfoFlag = false;
                                            if(priority < 1 || priority > 3){
                                                System.out.println(priority + " is not a valid Priority, please enter a number between 1 and 3.");
                                                badInfoFlag = true;
                                            }
                                        } catch (NumberFormatException e) {
                                            numberFlag = true;
                                        }
                                    }
                                } while (numberFlag || badInfoFlag);
                                assignment = backgroundProcess.getAssignment();
                                //set the priority
                                assignment.setPriority(priority);
                                do {    //run until user answers correctly
                                System.out.println("Would you like to change your assignment again??\t" + "Y | N");
                                editSameChoice = kb.nextLine();
                                } while(!editSameChoice.equalsIgnoreCase("Y") && !editSameChoice.equalsIgnoreCase("N"));
                            } while (editSameChoice.equalsIgnoreCase("Y"));
                        }
                        if(numberOption == 3){  //EDIT POPUPS
                            do{
                                try{
                                    numberFlag = false;
                                    System.out.println("\nHere Are Your Options\n");

                                    System.out.println("\tOPTIONS:");
                                    System.out.println("------------------------");
                                    System.out.println("[0]\tENABLE");
                                    System.out.println("[1]\tDISABLE");
                                    System.out.println("\nPLEASE SELECT A NUMBER");
                                    line = kb.nextLine();
                                    numberOption = Integer.parseInt(line);
                                }catch(NumberFormatException e){
                                    numberFlag = true;
                                }
                            } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed
                            if(numberOption == 0){  //ENABLE
                                do{
                                    try{
                                        numberFlag = false;
                                        System.out.println("\nHere Are Your Options\n");

                                        System.out.println("\tOPTIONS:");
                                        System.out.println("------------------------");
                                        System.out.println("[0]\tINDIVIDUAL");
                                        System.out.println("[1]\tALL");
                                        System.out.println("\nPLEASE SELECT A NUMBER");
                                        line = kb.nextLine();
                                        numberOption = Integer.parseInt(line);
                                    }catch(NumberFormatException e){
                                        numberFlag = true;
                                    }
                                } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed
                                if(numberOption == 0){  //INDIVIDUAL
                                    //prompt to enable a popup for an assignment
                                    do {    //the user will be prompted again for invalid input
                                        System.out.println("Please enter the name of the task you'd like to set a popup for");
                                        info = kb.nextLine();
                                    } while (!backgroundProcess.isAssignmentPresent(info));
                                    assignment = backgroundProcess.getAssignment();
                                    //enable the popup
                                    assignment.setPopup(true);
                                    popupCapture = true;
                                }
                                if(numberOption == 1){  //ALL
                                    //enable popups for all assignments
                                    backgroundProcess.enableAllPopups();
                                    popupCapture = true;
                                }
                            }
                            if(numberOption == 1){  //DISABLE
                                do{
                                    try{
                                        numberFlag = false;
                                        System.out.println("\nHere Are Your Options\n");

                                        System.out.println("\tOPTIONS:");
                                        System.out.println("------------------------");
                                        System.out.println("[0]\tINDIVIDUAL");
                                        System.out.println("[1]\tALL");
                                        System.out.println("\nPLEASE SELECT A NUMBER");
                                        line = kb.nextLine();
                                        numberOption = Integer.parseInt(line);
                                    }catch(NumberFormatException e){
                                        numberFlag = true;
                                    }
                                } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed
                                if(numberOption == 0){  //INDIVIDUAL
                                    //prompt to disable a popup for an assignment
                                    do {    //the user will be prompted again for invalid input
                                        System.out.println("Please enter the name of the task you'd like to set a popup for");
                                        info = kb.nextLine();
                                    } while (!backgroundProcess.isAssignmentPresent(info));
                                    assignment = backgroundProcess.getAssignment();
                                    //disable the popup
                                    assignment.setPopup(false);
                                }
                                if(numberOption == 1){  //ALL
                                    //disable popups for all assignments
                                    backgroundProcess.disableAllPopups();
                                }
                            }
                        }
                    }
                    backgroundProcess.sort(); //sort the list according to due date and priority just before saving the file
                    if(numberOption == 1){  //EDIT FILE
                        do {
                            System.out.println("Where Do You Want Your Assignments to Be Saved???");
                            System.out.println("Specify Path Name\t" + "\"C:\\\\person\\\\Desktop\\\\test\\\\newFile.txt\"");
                            line = kb.nextLine();

                            try {  // Catch errors in I/O if necessary.
                                badInfoFlag = false;
                                PrintWriter writer = new PrintWriter(line, "UTF-8");
                            } catch(IOException e){
                                badInfoFlag = true;
                            }
                        } while (line == null || badInfoFlag);
                        filePath = line;
                    }
                }
                if(numberOption == 4){ //VIEW SELECTED
                    do{
                        try{
                            numberFlag = false;
                            System.out.println("\nHere Are Your Options\n");

                            System.out.println("\tOPTIONS:");
                            System.out.println("------------------------");
                            System.out.println("[0]\tFILE");
                            System.out.println("[1]\tASSIGNMENT");

                            System.out.println("\nPLEASE SELECT A NUMBER");

                            line = kb.nextLine();
                            numberOption = Integer.parseInt(line);
                        }catch(NumberFormatException e){
                            numberFlag = true;
                        }
                    } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed
                    if(numberOption == 0){  //VIEW FILE
                        System.out.println("Your list file is currently stored in your " + backgroundProcess.getDestinationFolder() + " folder");
                    }
                    if(numberOption == 1){  //VIEW ASSIGNMENT
                        do{
                            try{
                                numberFlag = false;
                                System.out.println("\nHere Are Your Options\n");

                                System.out.println("\tOPTIONS:");
                                System.out.println("------------------------");
                                System.out.println("[0]\tVIEW ASSIGNMENTS");
                                System.out.println("[1]\tVIEW CONTENTS\t");

                                System.out.println("\nPLEASE SELECT A NUMBER");

                                line = kb.nextLine();
                                numberOption = Integer.parseInt(line);
                            }catch(NumberFormatException e){
                                numberFlag = true;
                            }
                        } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed
                        if(numberOption == 0){
                            //prompt to view all assignments
                            System.out.println("These are all your assignments so far:");
                            //display all tasks
                            backgroundProcess.printList();
                        }
                        if(numberOption == 1){  //VIEW CONTENTS
                            do{
                                try{
                                    numberFlag = false;
                                    System.out.println("\nHere Are Your Options\n");

                                    System.out.println("\tOPTIONS:");
                                    System.out.println("------------------------");
                                    System.out.println("[0]\tINDIVIDUAL");
                                    System.out.println("[1]\tALL\t");

                                    System.out.println("\nPLEASE SELECT A NUMBER");

                                    line = kb.nextLine();
                                    numberOption = Integer.parseInt(line);
                                }catch(NumberFormatException e){
                                    numberFlag = true;
                                }
                            } while(line == null || numberFlag || numberOption > 1 || numberOption < 0);    //when additional options are added the upper bound on this line MUST be changed
                            if(numberOption == 0){  //VIEW INDIVIDUAL
                                //prompt to view assignment contents
                                do {    //the user will be prompted again for invalid input
                                    System.out.println("Please enter the name of the task you'd like additional information about");
                                    info = kb.nextLine();
                                } while (backgroundProcess.getTaskInfo(info));
                            }
                            if(numberOption == 1){  //VIEW ALL
                                backgroundProcess.printListDetails();
                            }
                        }
                    }
                }
            }
        }
        //create the batch file here
        if(popupCapture){
            JOptionPane.showMessageDialog(null, "Please Restart Your Computer For These New Changes To Be Made");
        }
        //later on add conditionals to only create the batch once, do this only if necessary
        backgroundProcess.createBatchFile();
    }
}