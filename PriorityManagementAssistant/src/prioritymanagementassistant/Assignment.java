/*
 * This class will represent what is nedded to make an assignment.
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
 */
package prioritymanagementassistant;

import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

//Kyle Zeller

public class Assignment {

    private static String line, task;
    private static int month, day, year, hour, minute, priority;
    private static boolean numberFlag = true, badInfoFlag = true;    //set default value here

    private static LocalDateTime timePoint = LocalDateTime.now();   // The current date and time (YYYY-MM-DDTHH:MM:SS.642)
    private static Scanner kb = new Scanner(System.in);
    
    public static String getPath(){  //get prefered file path
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
        return line;
    }

    public static String getTask(){
        do {
            System.out.println("Please enter a name for your Assignment:");  //prompt user for task
            line = kb.nextLine();
        } while (line == null || line.contains("---")); //prompt the user for no input
        return line;
    }

    public static int getMonth(String n){
        do {
            System.out.println("What month is " + n + " due? (1-12)");  //prompt user for month
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

                if(month < 1 || month > 12 || (year == timePoint.getYear() && month < timePoint.getMonthValue()))
                    badInfoFlag = true;

            } catch (NumberFormatException e) {
                numberFlag = true;
            }
        } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
        return month;
    }


    public static int getDay(int m, String n){
        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12 ){
           do{
               System.out.println("What day is " + n + " due? (1-31)");
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
        }else if(m == 4 || m == 6 || m == 9 || m == 11){
           do{
               System.out.println("What day is " + n + " due? (1-30)");
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
        }else if(month == 2){
           do{
               System.out.println("what day is " + n + " due? (1-28)");
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
        }
    return day;
    }   

    public static int getYear(String n){
        do {
            System.out.println("What year is " + n + " due?");  //prompt user for year
            line = kb.nextLine();

            try {   //promt the user for an integer number
                numberFlag = false;
                year = Integer.parseInt(line);
                badInfoFlag = false;

                if(year < 2016){
                    System.out.println(year + " is not a valid Year, please enter a number greater than " + (timePoint.getYear()-1) + ".");

                if(year < timePoint.getYear())

                    badInfoFlag = true;
                }
            } catch (NumberFormatException e) {
                numberFlag = true;
            }
        } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
        return year;
    }

    public static int getHour(String n){
        do {
            System.out.println("What hour is " + n + " due? (1-24)");  //prompt user for hour
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

                if(hour < 1 || hour > 24 || (day == timePoint.getDayOfMonth() && hour < timePoint.getHour()))

                    badInfoFlag = true;
                }
            } catch (NumberFormatException e) {
                numberFlag = true;
            }
        } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
        return hour;
    }

    public static int getMinute(String n){
        do {
            System.out.println("What minute is " + n + " due? (1-59)");  //prompt user for minute
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

                if(minute < 0 || minute > 59 || (hour == timePoint.getHour() && minute < timePoint.getMinute()))

                    badInfoFlag = true;
                }
            } catch (NumberFormatException e) {
                numberFlag = true;
            }
        } while (line == null || numberFlag || badInfoFlag); //prompt the user for no input
        return minute;
    }

    public static int getPriority(String n){
        do {
            System.out.println("What is the priority of " + n + " (1-3)");  //prompt user for priority
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
