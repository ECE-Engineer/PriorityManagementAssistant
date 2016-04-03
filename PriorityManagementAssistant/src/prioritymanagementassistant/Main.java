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
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * A NEW STRUCTURE FOR THIS SHOULD BE ADDED TO MAKE INTEGRATION EASIER
 * YOU NEED TO DO THE BASIC STUFF FIRST LIKE TELLING THE USER THE CURRENT
 * DIRECTORY AND ASKING THEM IF THEY STILL WANT IT THERE. THEN YOU NEED TO
 * GIVE THEM A POP-UP OF ALL THEY'RE OPTIONS AS THE PROGRAM ADVANCES.
 * 
 * IT'S A SIMPLER GUI THAT CAN BE MADE TO CLOSER APPORXIMATELY THE CHANGES TO
 * BE MADE FOR THE ACTUAL GUI FOR THE PROGRAM.
 * 
 * 
 * IMPROVEMENTS WILL BE MADE TO ALLOW THE USER TO CHANGE THE PATH AT ANY TIME.
 *
 * IT IS ALSO IMPORTANT TO NOTE THAT THE VALUE OF THE FIRST LINE IN THE
 * BACKGROUND FILE CONTAINS THE PATH TO THE USERS LIST FILE & THAT WITH EVERY
 * ITERATION OF THE PROGRAM, THE PATH MUST NOT BE ALLOWED TO BE DELETED UNLESS
 * THE USER SPECIFIES THAT.
 *
 *
 *
 * update list upon start-up to support the idea that the list should not
 * contain tasks that are overdue!!
 *
 * Hashmaps should be implemeted
 *
 *
 *
 *
 *NEXT IMPROVEMENTS:
 *
 *
 *
 *
 *
 * 
 *
 *
 *
 * EVENTUALLY ALTER THE IMPORTS TO TAKE IN 1 LINE JUST THE METHODS OF THE OTHER
 * CLASSES
 *
 * The program needs to force the user to fill in information in the specified
 * order to work. (THIS IS PROBLAMATIC FOR THE INTEGRATION STEP)
 * 
 * 
 * 
 *
 * NEXT ON THE TO DO LIST:
 * 
 * 
 * 
 * 
 * create the junit tests for the program that you've written so far.
 * 
 * 
 *
 * 
 * 
 * 
 * 
 * create a folder and place all files for the PMA into it.
 * find a way to put the bat file in the startup folder, so the program still
 * works how it should. then have jar[0] create the bat file and place it in the
 * same folder as everything else. then integrate the GUI and alter the program.
 * then add the features of the program responsible for the popups & edit the
 * program that creates and runs the bat file, so the popups occur when they are
 * supposed to and not when they're not.
 * 
 * 
 *
 * 
 * 
 * ADVANCED:
 * Improvements can be made to inform the user about invalid input that they 
 * may provide to the program.  (EX. to have the user just enter the path & file
 * separately & eventually have a list of folders for the user to pick from
 * instead of them having to give a file path everytime)
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

    





//Kyle Zeller



package prioritymanagementassistant;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import static prioritymanagementassistant.Assignment.getPath;
import static prioritymanagementassistant.Assignment.setDefaultPath;

import static prioritymanagementassistant.Background.writeFile;
import static prioritymanagementassistant.Background.buildList;
import static prioritymanagementassistant.Background.createBackgroundFile;
import static prioritymanagementassistant.Background.getAssignment;
import static prioritymanagementassistant.Background.getDestinationFolder;
import static prioritymanagementassistant.Background.isFile;
import static prioritymanagementassistant.Background.isNull;
import static prioritymanagementassistant.Background.loadList;
import static prioritymanagementassistant.Background.printList;
import static prioritymanagementassistant.Background.removeTask;
import static prioritymanagementassistant.Background.getTaskInfo;
import static prioritymanagementassistant.Background.isAssignmentPresent;
//import static prioritymanagementassistant.Background.removeElement;
import static prioritymanagementassistant.Background.removeOnLoad;
import static prioritymanagementassistant.Background.sort;

/**
 * @author Kyle Z
 */
public class Main {

    private static String name, filePath, fLocation, delFile, info, editInfo,
                          editContent, editSameChoice, line;
    private static int month, day, year, hour, minute, priority, numberOption;
    private static boolean create = true, numberFlag = false, badInfoFlag = true;

    private static Assignment assignment;
    public static LocalDateTime timePoint = LocalDateTime.now();    // The current date and time (YYYY-MM-DDTHH:MM:SS.642)
    private static Scanner kb = new Scanner(System.in);
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if(!isFile()) {   //this is the first run of the program & there will be a welcome message with a user prompt to give the file path
            System.out.println("Welcome I am your Priority Management Assistant");
            do {
                System.out.println("Would you like the list to be saved in your Desktop folder?\t" + ("Y / N"));    //setting a default saving location
                fLocation = kb.nextLine();
            } while (!fLocation.equalsIgnoreCase("Y") && !fLocation.equalsIgnoreCase("N"));
            
            if(fLocation.equalsIgnoreCase("Y")) {
                filePath = setDefaultPath();
            } else  filePath = getPath();  //user specifeied path
        } else {   //ELSE I NEED TO ADD TO THE LIST THE PREVIOUS CONTENTS OF THE LIST
            //method to read contents from the list file into the arraylist
            filePath = loadList();
            //remove all overdue assignments
            removeOnLoad();
            //tell the user the current path destination folder & ask them if they want to change it
            System.out.println("Your list file is currently stored in your " + getDestinationFolder() + " folder");
            
            
            
            do {
                System.out.println("Would you like to change the folder that the list file is stored in??\t" + ("Y / N"));
                fLocation = kb.nextLine();
            } while (!fLocation.equalsIgnoreCase("Y") && !fLocation.equalsIgnoreCase("N"));
            if(fLocation.equalsIgnoreCase("Y"))
                filePath = getPath();
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
            while(isNull()){    //CASE 1 & 3
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
                    writeFile(filePath);    //write to & save file
                    createBackgroundFile(filePath); //IF THE FILE EXISTS THE CONTENTS OF IT MUST BE LOADED PRIOR TO RUNNING THE MAIN PROGRAM
                    break outerloop;
                }
                if(numberOption == 1){
                    do {
                        System.out.println("Please enter a name for your Assignment:");  //prompt user for task
                        name = kb.nextLine();
                    } while (name == null || name.contains("---") || isAssignmentPresent(name)); //prompt the user for no input
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
                    
                    assignment = new Assignment(name, month, day, year, hour, minute, priority);
                    buildList(assignment);
                    sort(); //sort the list according to due date and priority just before saving the file
                }
            }

            while(!isNull()){   //CASE 2 & 4
                do{
                    try{
                        numberFlag = false;
                        System.out.println("\nHere Are Your Options\n");

                        System.out.println("\tOPTIONS:");
                        System.out.println("------------------------");
                        System.out.println("[0]\tQUIT");
                        System.out.println("[1]\tCREATE");
                        System.out.println("[2]\tDELETE");
                        System.out.println("[3]\tEDIT");
                        System.out.println("[4]\tVIEW ASSIGNMENTS");
                        System.out.println("[5]\tVIEW CONTENTS");

                        System.out.println("\nPLEASE SELECT A NUMBER");
                        
                        line = kb.nextLine();
                        numberOption = Integer.parseInt(line);
                    }catch(NumberFormatException e){
                        numberFlag = true;
                    }
                } while(line == null || numberFlag || numberOption > 5 || numberOption < 0);

                if(numberOption == 0){
                    writeFile(filePath);    //write to & save file
                    createBackgroundFile(filePath); //IF THE FILE EXISTS THE CONTENTS OF IT MUST BE LOADED PRIOR TO RUNNING THE MAIN PROGRAM
                    break outerloop;
                }
                if(numberOption == 1){
                    do {
                        System.out.println("Please enter a name for your Assignment:");  //prompt user for task
                        name = kb.nextLine();
                    } while (name == null || name.contains("---") || isAssignmentPresent(name)); //prompt the user for no input
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
                    
                    assignment = new Assignment(name, month, day, year, hour, minute, priority);
                    buildList(assignment);
                    sort(); //sort the list according to due date and priority just before saving the file
                }
                if(numberOption == 2){
                    //prompt to delete
                    do {
                        //select a file to delete
                        System.out.println("Please enter the name of the task you'd like to delete");
                        delFile = kb.nextLine();
                    } while (removeTask(delFile));  //the user will be prompted again for invalid input
                    
                    sort(); //sort the list according to due date and priority just before saving the file
                }
                if(numberOption == 3){
                    //prompt to edit
                    do {
                        //select an assignment to edit
                        System.out.println("Please enter the name of the task you'd like to edit");
                        editInfo = kb.nextLine();
                    } while (!isAssignmentPresent(editInfo));  //the user will be prompted again for invalid input

                    do {    //THIS WILL RUN FOR AS LONG AS THE USER PREVIOUSLY WANTED TO EDIT THE SAME ASSIGNMENT SOME MORE
                        //prompt the user to change task name, time, or priority
                        do {
                            //select the assignment content to edit
                            System.out.println("Would you like to change the name, time, or priority of your assignment?\t" + ("T\t:\tN\t:\tP"));
                            editContent = kb.nextLine();
                        } while (!editContent.equalsIgnoreCase("N") && !editContent.equalsIgnoreCase("T") && !editContent.equalsIgnoreCase("P"));  //the user will be prompted again for invalid input


                        //check if the name is to be changed
                        if(editContent.equalsIgnoreCase("N")) {
                            //give a new name for the task
                            do {
                                System.out.println("Please enter a name for your Assignment:");  //prompt user for task
                                name = kb.nextLine();
                            } while (name == null || name.contains("---") || isAssignmentPresent(name)); //prompt the user for no input
                            assignment = getAssignment();
                            //set the name
                            assignment.setName(name);
                        }
                        //check if the time is to be changed
                        else if(editContent.equalsIgnoreCase("T")) {
                            //give a new due date for the task
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
                            assignment = getAssignment();
                            //set the time
                            assignment.setMonth(month);
                            assignment.setDay(day);
                            assignment.setYear(year);
                            assignment.setHour(hour);
                            assignment.setMinute(minute);
                        }
                        else {  //I know that the user wants to change the priority
                            //give a new priority for the task
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
                            assignment = getAssignment();
                            //set the priority
                            assignment.setPriority(priority);
                        }
                        do {    //run until user answers correctly
                            System.out.println("Would you like to change your assignment again??\t" + "Y | N");
                            editSameChoice = kb.nextLine();
                        } while(!editSameChoice.equalsIgnoreCase("Y") && !editSameChoice.equalsIgnoreCase("N"));
                    } while (editSameChoice.equalsIgnoreCase("Y"));

                    sort(); //sort the list according to due date and priority just before saving the file
                }
                if(numberOption == 4){
                    //prompt to view all assignments
                    System.out.println("These are all your assignments so far:");
                    //display all tasks
                    printList();
                }
                if(numberOption == 5){
                    //prompt to view assignment contents
                    do {    //the user will be prompted again for invalid input
                        System.out.println("Please enter the name of the task you'd like additional information about");
                        info = kb.nextLine();
                    } while (getTaskInfo(info));
                }
            }
        }
    }
}