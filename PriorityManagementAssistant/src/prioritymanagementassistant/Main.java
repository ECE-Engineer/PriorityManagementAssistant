/*
 * The Priority Management Assistant (PMA):
 * currently allows the user to make an assignment and sucessfully save it to
 * the file. We have made many changes to the program to ensure that the program
 * at it's current state, won't break with invalid input.
 *
 *NEXT IMPROVEMENTS:
 *get rid of the additional pop-up at the beginning***FIX LATER
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
 * Improvements can be made to inform the user about invalid input that they 
 * may provide to the program.
 */

//Kyle Zeller & Andrew Braunagel



package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

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
        
        static LocalDateTime timePoint = LocalDateTime.now();   // The current date and time (YYYY-MM-DDTHH:MM:SS.642)
        static Scanner kb = new Scanner(System.in);
        static ArrayList<String> list = new ArrayList<>();
        static FileOutputStream saveFile;
        static ObjectOutputStream save;
        static PrintWriter writer;
    
    public static void main(String[] args) {
        
        System.out.println("Welcome I am your Priority Management Assistant");
<<<<<<< HEAD
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
=======
        do {
            do {
                System.out.println("Would you like to make an assignment?\t" + ("Y / N"));
                mkTask = kb.nextLine();
            } while (!mkTask.equalsIgnoreCase("Y") && !mkTask.equalsIgnoreCase("N"));
            
            if(mkTask.equalsIgnoreCase("Y")){
                String build;
                task = getTask();
                year = getYear();
                month = getMonth();
                day = getDay();
                hour = getHour();
                minute = getMinute();
                priority = getPriority();
                build = task + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + priority;
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
>>>>>>> 9e388ccf07750ba5e05f3e91f82995ebf2e77f57
    }
    
        private static void setPath(){  //get the path to save the file from the user
            do {
                System.out.println("Specify Path Name\t" + "\"C:\\\\person\\\\Desktop\\\\test\\\\newFile.txt\"");
                line = kb.nextLine();
                try {  // Catch errors in I/O if necessary.
                    badInfoFlag = false;
                    writer = new PrintWriter(line, "UTF-8");

                    // write to the file
                    for(String content : list){
                        writer.print(content);
                        writer.println();
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
            } while (line == null || line.contains("---")); //prompt the user for no input
            return line;
        }
        
        private static int getMonth(){
            do {
                System.out.println("Please Enter The Month Of Your Task's Due Date\t(1-12)");  //prompt user for month
                line = kb.nextLine();
                
                if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                    line = line.replaceFirst("0", "");
                }
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    month = Integer.parseInt(line);
                    badInfoFlag = false;
<<<<<<< HEAD
                    if(month < 1 || month > 12){
                       System.out.println(month + " is not a valid Month, please enter a number between 1 and 12.");
                       badInfoFlag = true;
                    }
=======
                    if(month < 1 || month > 12 || (year == timePoint.getYear() && month < timePoint.getMonthValue()))
                        badInfoFlag = true;
>>>>>>> 9e388ccf07750ba5e05f3e91f82995ebf2e77f57
                } catch (NumberFormatException e) {
                    numberFlag = true;
                }
            } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
            return month;
        }
        
<<<<<<< HEAD
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
        
      
        
       
       
=======
        private static int getDay(){
            do {
                System.out.println("Please Enter The Day Of Your Task's Due Date\t" + ("DD"));  //prompt user for day
                line = kb.nextLine();
                
                if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                    line = line.replaceFirst("0", "");
                }
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    day = Integer.parseInt(line);
                    badInfoFlag = false;
                    if(day < 1 || day > 31 || (month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth()))
                        badInfoFlag = true;
                } catch (NumberFormatException e) {
                    numberFlag = true;
                }
            } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
            return day;
        }
        
>>>>>>> 9e388ccf07750ba5e05f3e91f82995ebf2e77f57
        private static int getYear(){
            do {
                System.out.println("Please Enter The Year Of Your Task's Due Date\t" + ("YYYY"));  //prompt user for year
                line = kb.nextLine();
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    year = Integer.parseInt(line);
                    badInfoFlag = false;
<<<<<<< HEAD
                    if(year < 2016){
                        System.out.println(year + " is not a valid Year, please enter a number greater than 2015.");
=======
                    if(year < timePoint.getYear())
>>>>>>> 9e388ccf07750ba5e05f3e91f82995ebf2e77f57
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
                
                if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                    line = line.replaceFirst("0", "");
                }
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    hour = Integer.parseInt(line);
                    badInfoFlag = false;
<<<<<<< HEAD
                    if(hour < 1 || hour > 24){
                        System.out.println(hour + " is not a valid Hour, please enter a number between 1 and 24.");
=======
                    if(hour < 1 || hour > 24 || (day == timePoint.getDayOfMonth() && hour < timePoint.getHour()))
>>>>>>> 9e388ccf07750ba5e05f3e91f82995ebf2e77f57
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
                
                if(line.startsWith("0")){   //this will prevent a parsing error from string to int
                    line = line.replaceFirst("0", "");
                }
                
                try {   //promt the user for an integer number
                    numberFlag = false;
                    minute = Integer.parseInt(line);
                    badInfoFlag = false;
<<<<<<< HEAD
                    if(minute < 0 || minute > 59){
                        System.out.println(minute + " is not a valid Minute, please enter a number between 1 and 60.");
=======
                    if(minute < 0 || minute > 59 || (hour == timePoint.getHour() && minute < timePoint.getMinute()))
>>>>>>> 9e388ccf07750ba5e05f3e91f82995ebf2e77f57
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