package prioritymanagementassistant;
import java.io.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PriorityManagementAssistant {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        System.out.println(Assignment_Input(input));
      
    }
    
    public static String Assignment_Input(Scanner s){
        int month;
        int day;
        int year;
        int hour;
        int minute;
        int priority;
        System.out.println("What is the name of the Assignment: ");
        String assignment_name  = s.nextLine();
        for(;;){
            System.out.println("What month is " + assignment_name + " due? (1-12)");
            month = s.nextInt();
            if(month > 0 && month < 13){
                break;
            }else{System.out.println(month + " is not a Valid Month, please enter a number between 1 and 12.");
            }
        }
        for(;;){
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
                System.out.println("What day is " + assignment_name + " due? (1-31)");
                day = s.nextInt();
                if(day >= 1 && day <= 31){
                    break;
                }else{System.out.println(day + " is not a Valid Day, please enter a number between 1 and 31.");
                }
            }else if(month == 4 || month == 6 || month == 9 || month == 11){
                System.out.println("What day is " + assignment_name + " due? (1-30)");
                day = s.nextInt();
                if(day >= 1 && day <= 30){
                    break;
                }else{System.out.println(day + " is not a Valid Day, please enter a number between 1 and 30.");
                }
            }else if(month == 2){
                System.out.println("What day is " + assignment_name + " due? (1-28)");
                day = s.nextInt();
                if(day >= 1 && day <= 28){
                    break;
                }else{System.out.println(day + " is not a Valid Day, please enter a number between 1 and 28.");
                }
            }
        }
        for(;;){
            System.out.println("What year is " + assignment_name + " due?");
            year = s.nextInt();
            if(year>=2016){
                break;
            }else{System.out.println(year + " is not a Valid Year, please enter a number greater than 2015.");}
        }
        for(;;){
            System.out.println("What hour is " + assignment_name + " due?");
            hour = s.nextInt();
            if(hour>=0 && hour <= 24){
                break;
            }else{System.out.println(hour + " is not a Valid Hour, please enter a number bewteen 0 and 24.");}
        }
        for(;;){
            System.out.println("What minute is " + assignment_name + " due?");
            minute = s.nextInt();
            if(minute >=0 && minute <= 60){
                break;
            }else{System.out.println(minute + " is not a Valid Minute, please enter a number between 0 and 60.");
            }
        }
        for(;;){
            System.out.println("What it the priority of " + assignment_name + "?");
            priority = s.nextInt();
            if(priority >= 1 && priority <= 3){
                break;
            }else{System.out.println(priority + " is not a Valid Priority, please enter a number between 1 and 3.");
            }
        }
        
        String assignment_input = assignment_name + "---" + Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year) +
                " " + Integer.toString(hour) + ":" + Integer.toString(minute) + "---" + Integer.toString(priority);
        return assignment_input;
    }
    
    
}
