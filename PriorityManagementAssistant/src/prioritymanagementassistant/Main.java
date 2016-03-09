/*
The Priority Management Assistant (PMA) will be a desktop application for
windows and linux that will prioritize the everyday life of an individual.
The user must be able to input their class assignments such as homeworks,
projects, labs, upcoming exams and quizzes, meetings, classes, etc. The program
needs to be well organized and have good structure for a graphical user
interface to make it as simple as possible for the user to create, remove, or
edit an upcoming assignment. This graphical user interface must provide
clickable buttons for certain features such as adding, removing, and saving an
assignment. As the program is running, there needs to be a list of all
assignments with deadlines for some set interval of time. The program needs
to be able to update itself every time the user adds, removes, or edits their
assignments. There also needs to be a way to list the assignments in order of
importance according to the user’s specification when he/she submits the
assignment. There will be a feature that the user can configure that will
enable screen pop-ups as reminders for those assignments.
 */

//Kyle Zeller & Andrew Braunagel



package prioritymanagementassistant;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * @author Kyle Z
 */
public class Main {
        
        static String mkTask;
        static String svTask = "N"; //set default value for when the user leaves the list empty
        static String line;
        static String task;
        static String filePath;
        static int month;
        static int day;
        static int year;
        static int hour;
        static int minute;
        static int priority;
        static boolean numberFlag = true; //set default value here
        static boolean badInfoFlag = true;    //set default value here
        
        static Scanner kb = new Scanner(System.in);
        static ArrayList<String> list = new ArrayList<>();
        static FileOutputStream saveFile;
        static ObjectOutputStream save;
        static PrintWriter writer;
    
    public static void main(String[] args) {
        System.out.println("Welcome I am your Priority Management Assistant");
        do {
            do {
                System.out.println("Would you like to make an assignment?\t" + ("Y / N"));
                mkTask = kb.nextLine();
            } while (!mkTask.equalsIgnoreCase("Y") && !mkTask.equalsIgnoreCase("N"));
            
            if(mkTask.equalsIgnoreCase("Y")){
                String build;
                task = getTask();
                month = getMonth();
                day = getDay();
                year = getYear();
                hour = getHour();
                minute = getMinute();
                priority = getPriority();
                build = task + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + priority + "\n";
                list.add(build);
            }
            
            if(list != null){
                do {
                    System.out.println("Are you done making assignments?\t" + ("Y / N"));
                    svTask = kb.nextLine();
                } while (!svTask.equalsIgnoreCase("Y") && !svTask.equalsIgnoreCase("N"));
                
                if(svTask.equalsIgnoreCase("Y")){
                    setPath();  //path is set & file has been created
                }
            }
        } while (svTask.equalsIgnoreCase("N"));
        //MORE WILL GO HERE, IN THE NEXT REQUIREMENTS
    }
    
        private static void setPath(){  //get the path to save the file from the user
            do {
                System.out.println("Specify Path Name\t" + "\"C:\\\\person\\\\Desktop\\\\test\\\\newFile.txt\"");
                line = kb.nextLine();
                try {  // Catch errors in I/O if necessary.
                    badInfoFlag = false;
                    writer = new PrintWriter(line, "UTF-8");

                    // save the file
                    for(String content : list){
                        writer.print(content);
                    }
                    
                    // Close the file.
                    writer.close();
                } catch(IOException e){
                    badInfoFlag = true;
                }
            } while (line == null || badInfoFlag);
            filePath = line;
        }
        
        private static String getTask(){
            do {
                System.out.println("Please Enter The Title Of Your Task");  //prompt user for task
                line = kb.nextLine();
            } while (line == null); //prompt the user for no input
            return line;
        }
        
        private static int getMonth(){
            do {
                System.out.println("Please Enter The Month Of Your Task's Due Date\t" + ("MM"));  //prompt user for month
                line = kb.nextLine();
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    month = Integer.parseInt(line);
                    badInfoFlag = false;
                    if(month < 1 || month > 12)
                        badInfoFlag = true;
                } catch (NumberFormatException e) {
                    numberFlag = true;
                }
            } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
            return month;
        }
        
        private static int getDay(){
            do {
                System.out.println("Please Enter The Day Of Your Task's Due Date\t" + ("DD"));  //prompt user for day
                line = kb.nextLine();
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    day = Integer.parseInt(line);
                    badInfoFlag = false;
                    if(day < 1 || day > 31)
                        badInfoFlag = true;
                } catch (NumberFormatException e) {
                    numberFlag = true;
                }
            } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
            return day;
        }
        
        private static int getYear(){
            do {
                System.out.println("Please Enter The Year Of Your Task's Due Date\t" + ("YYYY"));  //prompt user for year
                line = kb.nextLine();
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    year = Integer.parseInt(line);
                    badInfoFlag = false;
                    if(year < 2016)
                        badInfoFlag = true;
                } catch (NumberFormatException e) {
                    numberFlag = true;
                }
            } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
            return year;
        }
        
        private static int getHour(){
            do {
                System.out.println("Please Enter The Hour Of Your Task's Due Date\t" + ("hh"));  //prompt user for hour
                line = kb.nextLine();
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    hour = Integer.parseInt(line);
                    badInfoFlag = false;
                    if(hour < 1 || hour > 24)
                        badInfoFlag = true;
                } catch (NumberFormatException e) {
                    numberFlag = true;
                }
            } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
            return hour;
        }
        
        private static int getMinute(){
            do {
                System.out.println("Please Enter The Minute Of Your Task's Due Date\t" + ("mm"));  //prompt user for minute
                line = kb.nextLine();
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    minute = Integer.parseInt(line);
                    badInfoFlag = false;
                    if(minute < 0 || minute > 59)
                        badInfoFlag = true;
                } catch (NumberFormatException e) {
                    numberFlag = true;
                }
            } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
            return minute;
        }
        
        private static int getPriority(){
            do {
                System.out.println("Please Enter The Priority Of Your Task\t" + ("Between 1 & 3"));  //prompt user for priority
                line = kb.nextLine();
                if(line == null){   //assign a default priority value for no input
                        priority = 1;
                    }
                else{
                    try {   //promt the user for an integer number
                        numberFlag = false;
                        priority = Integer.parseInt(line);
                        badInfoFlag = false;
                        if(priority < 1 || priority > 3)
                            badInfoFlag = true;
                    } catch (NumberFormatException e) {
                        numberFlag = true;
                    }
                }
            } while (numberFlag || badInfoFlag);
            return priority;
        }
    }