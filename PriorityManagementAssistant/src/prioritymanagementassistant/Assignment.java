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

//Kyle Zeller

public class Assignment {
    private static String line;
    private static boolean badInfoFlag = true;    //set default value here
    private static Scanner kb = new Scanner(System.in);
    
    private String name;
    private int month, day, year, hour, minute, priority;
    
    public Assignment(String n, int mo, int d, int y, int h, int mi, int p){
        //assign corresponding values
        name = n;
        month = mo;
        day = d;
        year = y;
        hour = h;
        minute = mi;
        priority = p;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        this.name = n;
    }
    
    public int getMonth(){
        return month;
    }
    
    public void setMonth(int mo){
        this.month = mo;
    }
    
    public int getDay(){
        return day;
    }
    
    public void setDay(int d){
        this.day = d;
    }
    
    public int getYear(){
        return year;
    }
    
    public void setYear(int y){
        year = y;
    }
    
    public int getHour(){
        return hour;
    }
    
    public void setHour(int h){
        this.hour = h;
    }
    
    public int getMinute(){
        return minute;
    }
    
    public void setMinute(int mi){
        this.minute = mi;
    }
    
    public int getPriority(){
        return priority;
    }
    
    public void setPriority(int p){
        this.priority = p;
    }

    public static String setDefaultPath(){
        do {
            System.out.println("Name Your List File???");
            System.out.println("EX :\t" + "\"newFile\"");
            line = kb.nextLine();

            try {  // Catch errors in I/O if necessary.
                badInfoFlag = false;
                PrintWriter writer = new PrintWriter(("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\" + line + ".txt"), "UTF-8");
            } catch(IOException e){
                badInfoFlag = true;
            }
        } while (line == null || badInfoFlag);
        return "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\" + line + ".txt";
    }
    
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
}
