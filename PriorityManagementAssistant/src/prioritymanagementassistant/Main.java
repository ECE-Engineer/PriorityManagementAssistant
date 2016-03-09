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





package main;

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
        private static String filePath;
        
        static ArrayList<String> list = new ArrayList<>();
        
        static File file;
        
        
    
        
  
    public static void main(String[] args) {
        
        System.out.println("Welcome I am your Priority Management Assistant");
        System.out.println("Would you like to make an assignment?\t" + ("Y / N"));
        String choice = kb.nextLine();
        
        if(choice.equalsIgnoreCase("Y")){
            String build;
            task = getTask();
            month = getMonth();
            day = getDay(month);
            year = getYear();
            hour = getHour();
            minute = getMinute();
            priority = getPriority();
            build = task + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + priority;
            list.add(build);
            setPath();  //path is set & file has been created
        }
        //MORE WILL GO HERE
    }
    
        private static void setPath(){  //get the path to save the file from the user
            do {
                System.out.println("Specify Path Name\t" + "\"C:\\\\person\\\\Desktop\\\\test\\\\newFile.txt\"");
                line = kb.nextLine();
                file = new File(line);
		try {
                        badInfoFlag = false;
			//create a new file if it doesn't exist already
			file.createNewFile();
	
		} catch (IOException e) {
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
                System.out.println("Please Enter The Month Of Your Task's Due Date\t(1-12)");  //prompt user for month
                line = kb.nextLine();
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    month = Integer.parseInt(line);
                    badInfoFlag = false;
                    if(month < 1 || month > 12){
                       System.out.println(month + " is not a valid Month, please enter a number between 1 and 12.");
                       badInfoFlag = true;
                    }
                } catch (NumberFormatException e) {
                    numberFlag = true;
                }
            } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
            return month;
        }
        
        private static int getDay(int m){
            if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12 ){
               do{
                   System.out.println("Please Enter The Day Of Your Task's Due Date\t(1-31)");
                   line = kb.nextLine();
                   try {   //promt the user for an integer number
                        numberFlag = false;
                        day = Integer.parseInt(line);
                        badInfoFlag = false;
                        if(day < 1 || day > 31){
                            System.out.println(day + " is not a valid Day, please enter a number between 1 and 31.");
                            badInfoFlag = true;
                        }
                    }catch (NumberFormatException e) {
                        numberFlag = true;
                }
               }while(line == null || numberFlag || badInfoFlag);
                   return day;
            }else if(m == 4 || m == 6 || m == 9 || m == 11){
               do{
                   System.out.println("Please Enter The Day Of Your Task's Due Date\t(1-30)");
                   line = kb.nextLine();
                   try {   //promt the user for an integer number
                        numberFlag = false;
                        day = Integer.parseInt(line);
                        badInfoFlag = false;
                        if(day < 1 || day > 30){
                            System.out.println(day + " is not a valid Day, please enter a number between 1 and 30.");
                            badInfoFlag = true;
                        }
                    }catch (NumberFormatException e) {
                        numberFlag = true;
                    }
               }while(line == null || numberFlag || badInfoFlag);
                   return day;                 
            }else if(month == 2){
               do{
                   System.out.println("Please Enter The Day Of Your Task's Due Date\t(1-31)");
                   line = kb.nextLine();
                   try {   //promt the user for an integer number
                        numberFlag = false;
                        day = Integer.parseInt(line);
                        badInfoFlag = false;
                        if(day < 1 || day > 28){
                            System.out.println(day + " is not a valid Day, please enter a number between 1 and 28.");
                            badInfoFlag = true;
                        }
                    }catch (NumberFormatException e) {
                        numberFlag = true;
                    }
               }while(line == null || numberFlag || badInfoFlag);
                   return day;                 
            }
        
            return 0;
        }   
        
      
        
       
       
        private static int getYear(){
            do {
                System.out.println("Please Enter The Year Of Your Task's Due Date\t" + ("YYYY"));  //prompt user for year
                line = kb.nextLine();
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    year = Integer.parseInt(line);
                    badInfoFlag = false;
                    if(year < 2016){
                        System.out.println(year + " is not a valid Year, please enter a number greater than 2015.");
                        badInfoFlag = true;
                    }
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
                    if(hour < 1 || hour > 24){
                        System.out.println(hour + " is not a valid Hour, please enter a number between 1 and 24.");
                        badInfoFlag = true;
                    }
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
                    if(minute < 0 || minute > 59){
                        System.out.println(minute + " is not a valid Minute, please enter a number between 1 and 60.");
                        badInfoFlag = true;
                    }
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
                        if(priority < 1 || priority > 3){
                            System.out.println(priority + " is not a valid Priority, please enter a number between 1 and 3.");
                            badInfoFlag = true;
                        }
                    } catch (NumberFormatException e) {
                        numberFlag = true;
                    }
                }
            } while (numberFlag || badInfoFlag);
            return priority;
        }
    }