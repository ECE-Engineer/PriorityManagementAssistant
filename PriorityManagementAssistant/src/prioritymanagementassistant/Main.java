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

/**
 * @author Kyle Z
 */
public class Main {

    private static String mkTask, svTask = "N", task, filePath, fLocation,
                          delFileChoice, delFile, infoChoice, info, editFileChoice,
                          editInfo, editContent, editSameChoice;
    private static int month, day, year, hour, minute, priority;
    private static boolean create = true;

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
        
        
        
        
        
        
        do {    //this runs for as long as long as the user wants to continue adding assignments
            do {    //this runs if this is the first assignment being made in this iteration of the program
                if(create){
                    System.out.println("Would you like to make an assignment?\t" + ("Y / N"));
                    mkTask = kb.nextLine();
                    create = false;
                } else  mkTask = "Y";
                
            } while (!mkTask.equalsIgnoreCase("Y") && !mkTask.equalsIgnoreCase("N"));
            
            if(mkTask.equalsIgnoreCase("Y")) {
                String build;
                task = getTask();
                year = getYear(task);
                month = getMonth(task);
                day = getDay(month, task);
                hour = getHour(task);
                minute = getMinute(task);
                priority = getPriority(task);
                build = task + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + priority;
                buildList(build);
            }
            
            do {    //this runs only after the user has been prompted to create an assignment
                System.out.println("Are you done making assignments?\t" + ("Y / N"));
                svTask = kb.nextLine();
            } while (!svTask.equalsIgnoreCase("Y") && !svTask.equalsIgnoreCase("N"));

            if(svTask.equalsIgnoreCase("Y")){
                //printWholeList(); //DEBUG
                if(!isNull()){    //list is not null
                    do {    //this runs for as long as the user previously wanted to delete a given assignment
                        do {    //ask the user if they want to delete any task
                            System.out.println("Would you like to delete an assignment?\t" + ("Y / N"));
                            delFileChoice = kb.nextLine();
                        } while (!delFileChoice.equalsIgnoreCase("Y") && !delFileChoice.equalsIgnoreCase("N"));
                        if(delFileChoice.equalsIgnoreCase("Y")){
                            System.out.println("These are all your assignments so far:");
                            //display all tasks
                            printList();
                            
                            do {    //this runs for as long as the user previously wanted to get more information about an assignment
                                do {    //prompt the user if they want additional information about a given assignment
                                    System.out.println("Would you like to know more information about a given assignment?\t" + ("Y / N"));
                                    infoChoice = kb.nextLine();
                                } while (!infoChoice.equalsIgnoreCase("Y") && !infoChoice.equalsIgnoreCase("N"));
                                if(infoChoice.equalsIgnoreCase("Y")){
                                    //ask the user which assignment
                                    do {    //the user will be prompted again for invalid input
                                        System.out.println("Please enter the name of the task you'd like additional information about");
                                        info = kb.nextLine();
                                    } while (getTask(info));
                                }
                            } while (infoChoice.equalsIgnoreCase("Y"));
                            do {
                                //select a file to delete
                                System.out.println("Please enter the name of the task you'd like to delete");
                                delFile = kb.nextLine();
                            } while (removeTask(delFile));  //the user will be prompted again for invalid input
                        }
                    } while (delFileChoice.equalsIgnoreCase("Y") && !isNull());
                    
                    do {
                    //ask the user if they want to edit any given task
                        do {
                            System.out.println("Would you like to edit an assignment?\t" + ("Y / N"));
                            editFileChoice = kb.nextLine();
                        } while (!editFileChoice.equalsIgnoreCase("Y") && !editFileChoice.equalsIgnoreCase("N"));
                        
                        
                        if(editFileChoice.equalsIgnoreCase("Y")){
                            System.out.println("These are all your assignments so far:");
                            //display all tasks
                            printList();
                            
                            do {
                                //prompt the user if they want additional information about a given assignment
                                do {
                                    System.out.println("Would you like to know more information about a given assignment?\t" + ("Y / N"));
                                    infoChoice = kb.nextLine();
                                } while (!infoChoice.equalsIgnoreCase("Y") && !infoChoice.equalsIgnoreCase("N"));
                                if(infoChoice.equalsIgnoreCase("Y")){
                                    //ask the user which assignment
                                    do {
                                        System.out.println("Please enter the name of the task you'd like additional information about");
                                        info = kb.nextLine();
                                    } while (getTask(info));  //the user will be prompted again for invalid input
                                }
                            } while (infoChoice.equalsIgnoreCase("Y")); //ask user again if they want additional information about a given assignment
                            
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
                                    task = getTask();
                                    //set the name
                                    setTask(task);
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
                            
                            
                            removeElement();
                            
                        }//this is the end to the if statement asking the user if they want to edit other assignments
                    } while (editFileChoice.equalsIgnoreCase("Y") && !isNull()); //this runs while the list is not empty and the user wants to continue editing assignments
                    
                    
                }//this is the end to the if statement for if the list is empty
            }//this is the end to the if that runs if the user is done making assignments
            writeFile(filePath);    //write to & save file
        }while (svTask.equalsIgnoreCase("N"));//this runs wile the user is not done making assignments
        createBackgroundFile(filePath); //IF THE FILE EXISTS THE CONTENTS OF IT MUST BE LOADED PRIOR TO RUNNING THE MAIN PROGRAM
    }
}