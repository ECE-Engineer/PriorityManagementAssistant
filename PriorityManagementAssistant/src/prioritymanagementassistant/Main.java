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





package prioritymanagementassistant;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * @author Kyle Z
 */
public class Main {
        static Scanner kb = new Scanner(System.in);
    
        static String line;

        static String task;
        static int month;
        static int day;
        static int year;
        static int hour;
        static int minute;
        static int priority;
        static boolean numberFlag = true; //set default value here
        static boolean badInfoFlag = true;    //set default value here
        
        static ArrayList<String> list = new ArrayList<>();
    
        
  
    public static void main(String[] args) {
        
        System.out.println("Welcome I am your Priority Management Assistant");
        System.out.println("Would you like to make an assignment?\t" + ("Y / N"));
        String choice = kb.nextLine();
        
        if(choice.equalsIgnoreCase("Y")){
            String build;
            task = getTask();
            month = getMonth();
            day = getDay();
            year = getYear();
            hour = getHour();
            minute = getMinute();
            priority = getPriority();
            build = task + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + priority;
            list.add(build);
        }
        
        
    }
    
        private static void setPath(String s){  //get the path to save the file from the user
            
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
    

