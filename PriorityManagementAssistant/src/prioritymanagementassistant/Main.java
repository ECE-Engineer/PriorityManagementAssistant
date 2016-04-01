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

import static prioritymanagementassistant.Assignment.getPath;
import static prioritymanagementassistant.Assignment.getTask;
import static prioritymanagementassistant.Assignment.getMonth;
import static prioritymanagementassistant.Assignment.getDay;
import static prioritymanagementassistant.Assignment.getYear;
import static prioritymanagementassistant.Assignment.getHour;
import static prioritymanagementassistant.Assignment.getMinute;
import static prioritymanagementassistant.Assignment.getPriority;
import static prioritymanagementassistant.Assignment.setDefaultPath;

import static prioritymanagementassistant.Background.writeFile;
import static prioritymanagementassistant.Background.buildList;
import static prioritymanagementassistant.Background.createBackgroundFile;
import static prioritymanagementassistant.Background.getDestinationFolder;
import static prioritymanagementassistant.Background.isFile;
import static prioritymanagementassistant.Background.isNull;
import static prioritymanagementassistant.Background.loadList;
import static prioritymanagementassistant.Background.printList;
//import static prioritymanagementassistant.Background.printWholeList;  //DEBUG
import static prioritymanagementassistant.Background.removeTask;
import static prioritymanagementassistant.Background.getTask;
import static prioritymanagementassistant.Background.isAssignmentPresent;
import static prioritymanagementassistant.Background.removeElement;
import static prioritymanagementassistant.Background.removeOnLoad;
import static prioritymanagementassistant.Background.setTask;
import static prioritymanagementassistant.Background.setTime;
import static prioritymanagementassistant.Background.setPriority;
import static prioritymanagementassistant.Background.sort;

/**
 * @author Kyle Z
 */
public class Main {

    private static String name, filePath, fLocation, delFile, info, editInfo,
                          editContent, editSameChoice, line;
    private static int month, day, year, hour, minute, priority, numberOption;
    private static boolean create = true, numberFlag = false;

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
                    //make an assignment
                    String build;
                    name = getTask();
                    year = getYear(name);
                    month = getMonth(name);
                    day = getDay(month, name);
                    hour = getHour(name);
                    minute = getMinute(name);
                    priority = getPriority(name);
                    build = name + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + priority;
                    buildList(build);
                    
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
                    //make an assignment
                    String build;
                    name = getTask();
                    year = getYear(name);
                    month = getMonth(name);
                    day = getDay(month, name);
                    hour = getHour(name);
                    minute = getMinute(name);
                    priority = getPriority(name);
                    build = name + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + priority;
                    buildList(build);
                    
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
                            name = getTask();
                            //set the name
                            setTask(name);
                        }
                        //check if the time is to be changed
                        else if(editContent.equalsIgnoreCase("T")) {
                            //give a new due date for the task
                            year = getYear(editInfo);
                            month = getMonth(editInfo);
                            day = getDay(month, editInfo);
                            hour = getHour(editInfo);
                            minute = getMinute(editInfo);
                            //set the time
                            setTime(year, month, day, hour, minute);
                        }
                        else {  //I know that the user wants to change the priority
                            //give a new priority for the task
                            priority = getPriority(editInfo);
                            //set the priority
                            setPriority(priority);
                        }
                        do {    //run until user answers correctly
                            System.out.println("Would you like to change your assignment again??\t" + "Y | N");
                            editSameChoice = kb.nextLine();
                        } while(!editSameChoice.equalsIgnoreCase("Y") && !editSameChoice.equalsIgnoreCase("N"));
                    } while (editSameChoice.equalsIgnoreCase("Y"));

                    removeElement();    //this removes the older version of that assignment
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
                    } while (getTask(info));
                }
            }
        }
    }
}