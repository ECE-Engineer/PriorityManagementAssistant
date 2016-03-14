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
 * IT IS ALSO IMPORTANT TO NOTE THAT THE VALUE OF THE FIRST LINE IN THE SECOND
 * FILE CONTAINS THE PATH TO THE USERS LIST FILE & THAT WITH EVERY ITERATION OF
 * THE PROGRAM, THE PATH MUST NOT BE ALLOWED TO BE DELETED UNLESS THE USER
 * SPECIFIES THAT.
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
 *NEXT IMPROVEMENTS:
 *get rid of the additional pop-up at the beginning***FIX LATER
 *
 *
 *
 *
 * FILEPATH IS SHOWING AS NULL & INFO IS NOT BEING WRITING TI FILE ON DESKTOP
 *
 *
 *
 * EVENTUALLY ALTER THE IMPORTS TO TAKE IN 1 LINE JUST THE METHODS OF THE OTHER
 * CLASSES
 *
 *
 *
 * Improvements can be made to inform the user about invalid input that they 
 * may provide to the program.
 */

//Kyle Zeller & Andrew Braunagel



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

import static prioritymanagementassistant.Background.writeFile;
import static prioritymanagementassistant.Background.buildList;
import static prioritymanagementassistant.Background.createBackgroundFile;
import static prioritymanagementassistant.Background.isFile;
import static prioritymanagementassistant.Background.isList;
import static prioritymanagementassistant.Background.loadList;

/**
 * @author Kyle Z
 */
public class Main {

    private static String mkTask, svTask = "N", task, filePath;
    private static int month, day, year, hour, minute, priority;

    private static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if(!isFile()) {   //this is the first run of the program & there will be a welcome message with a user prompt to give the file path
            System.out.println("Welcome I am your Priority Management Assistant");
            filePath = getPath();  //path is set
        } else {   //ELSE I NEED TO ADD TO THE LIST THE PREVIOUS CONTENTS OF THE LIST
            //method to read contents from the list file into the arraylist
            filePath = loadList();
        }
        
        do {
            do {
                System.out.println("Would you like to make an assignment?\t" + ("Y / N"));
                mkTask = kb.nextLine();
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
            
            if(isList()) {  //check if list is not empty
                do {
                    System.out.println("Are you done making assignments?\t" + ("Y / N"));
                    svTask = kb.nextLine();
                } while (!svTask.equalsIgnoreCase("Y") && !svTask.equalsIgnoreCase("N"));
                
                if(svTask.equalsIgnoreCase("Y")){
                    writeFile(filePath);    //write to & save file
                }
            }
        } while (svTask.equalsIgnoreCase("N"));
        
        createBackgroundFile(filePath); //IF THE FILE EXISTS THE CONTENTS OF IT MUST BE LOADED PRIOR TO RUNNING THE MAIN PROGRAM
    }
}