/*
 * This program will run all the the hidden file access handling. In other words
 * This program will be responsible for generating a hidden file for the log
 * data of the program for the start-up of the program. It will keep track of
 * program usage (how many times the program has been run) as well as the
 * contents of the list file. On start-up, the program will look for the hidden
 * file and read it's contents to check if a new log has been created. If there
 * is any hidden file at the path location specified, the Main program will not
 * prompt the user to specify the path name for their list file as well as other
 * user prompts and messages (Ex. the welcoming message).
 * 
 * 
 * 
 * 
 * 
 */
package prioritymanagementassistant;

//Kyle Zeller

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import static prioritymanagementassistant.Assignment.timePoint;
import static prioritymanagementassistant.Assignment.getTask;

public class Background {
    private static ArrayList<String> list = new ArrayList<>();
    private static PrintWriter backgroundFile, userFile;
    private static String filePath, assignment;
    private static int track;
    
    public static String getDestinationFolder(){
        int count = 0;
        for (int i = 0; i < filePath.length(); i++) {
            if((filePath.substring(i, i+1)).equalsIgnoreCase("\\"))
                count++;
        }
        
        return (filePath.substring((filePath.lastIndexOf("\\", filePath.lastIndexOf("\\", filePath.length())-1))+1, filePath.lastIndexOf("\\", filePath.length())));
    }
    
    public static void writeFile(String path) throws FileNotFoundException, UnsupportedEncodingException{//line ZERO must contain the path of the list file
        //open the text file
        userFile = new PrintWriter(path, "UTF-8");
        
        // write to the file
        for(String content : list){
            userFile.print(content);
            userFile.println();
        }

        // Close the file.
        userFile.close();
    }
    
    public static boolean isFile(){ //check to see if this is the first time the user has run the program
        if((new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt")).exists())
            return true;    //file exists
        else
            return false;   //file dose not exist
    }
    
    public static void createBackgroundFile(String s) throws FileNotFoundException, UnsupportedEncodingException{  //make a background file to store all logs / program runs
        //make the file
        backgroundFile = new PrintWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt", "UTF-8");
        
        //line ZERO must contain the path of the list file
        backgroundFile.print(s);
        backgroundFile.println();
        
        // write to the file the contents of the list
        for(String content : list){
            backgroundFile.print(content);
            backgroundFile.println();
        }

        //close the file
        backgroundFile.close();
    }
    
    public static String loadList() throws FileNotFoundException, IOException{    //IF THE FILE EXISTS THE CONTENTS OF IT MUST BE LOADED PRIOR TO RUNNING THE MAIN PROGRAM
        File f = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt");
        BufferedReader read = new BufferedReader(new FileReader(f));
        
        String line;
        if((line = read.readLine()) != null)//store line 0 as the file path
            filePath = line;
        while ((line = read.readLine()) != null) {  //load the list
            list.add(line);
        }
        return filePath;
    }
    
    public static void buildList(String build){
        list.add(build);
    }
    
    public static void printList() {
        //display all tasks
        for(String content : list){
            System.out.println(content.substring(0, content.indexOf("---")));
        }
    }
    
    public static boolean getTask(String s){    //prints all information about a given task
        //search for the task in the list using the task name
        boolean taskFound = true;
        int count = 0;
        for(String content : list){
            if(content.substring(0, content.indexOf("---")).equalsIgnoreCase(s)){
                System.out.println(content.replaceAll("---", "\t"));
                taskFound = false;
                break;
            }
            count++;
        }
        return taskFound;
    }
    
    public static void removeOnLoad(){
        for(int i = 0; i < list.size(); i++){
            if(Integer.parseInt(list.get(i).split("---")[3]) < timePoint.getYear()){
                list.remove(i);
            } else if(Integer.parseInt(list.get(i).split("---")[1]) < timePoint.getMonthValue()) {
                list.remove(i);
            } else if(Integer.parseInt(list.get(i).split("---")[2]) < timePoint.getDayOfMonth()) {
                list.remove(i);
            } else if(Integer.parseInt(list.get(i).split("---")[4]) < timePoint.getHour()) {
                list.remove(i);
            } else if(Integer.parseInt(list.get(i).split("---")[5]) < timePoint.getMinute()) {
                list.remove(i);
            }
        }
    }
    
    public static boolean removeTask(String s){
        //search for the task in the list using the task name
        boolean taskFound = true;
        int count = 0;
        for(String content : list){
            if(content.substring(0, content.indexOf("---")).equalsIgnoreCase(s)){
                list.remove(count);
                taskFound = false;
                break;
            }
            count++;
        }
        return taskFound;
    }
    
    public static boolean isNull(){
        return list.isEmpty();
    }
    
    public static void printWholeList() {    //DEBUG :`PRINT ALL CONTENTS OF THE LIST
        //display all tasks
        for(String content : list){
            System.out.println(content);
        }
    }
    
    public static boolean isAssignmentPresent(String s){
        //search for the task in the list using the task name
        boolean taskFound = false;  //assignment not present in list
        track = 0;
        for(String content : list){
            if(content.substring(0, content.indexOf("---")).equalsIgnoreCase(s)){
                taskFound = true;   //assignment present in list
                assignment = content;
                break;
            }
            track++;
        }
        return taskFound;
    }
    
    public static void setTask(String s){
        int year, month, day, hour, minute, priority;
        month = Integer.parseInt(assignment.split("---")[1]);
        day = Integer.parseInt(assignment.split("---")[2]);
        year = Integer.parseInt(assignment.split("---")[3]);
        hour = Integer.parseInt(assignment.split("---")[4]);
        minute = Integer.parseInt(assignment.split("---")[5]);
        priority = Integer.parseInt(assignment.split("---")[6]);
        //adjust the value for assignment
        assignment = s + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + priority;
        //build the list
        list.add(assignment);
    }
    
    public static void setTime(int y, int mo, int d, int h, int mi){
        String name;
        int priority;
        name = assignment.split("---")[0];
        priority = Integer.parseInt(assignment.split("---")[6]);
        //adjust the value for assignment
        assignment = name + "---" + mo + "---" + d + "---" + y + "---" + h + "---" + mi + "---" + priority;
        //build the list
        list.add(assignment);
    }
    
    public static void setPriority(int p){
        String name;
        int year, month, day, hour, minute;
        name = assignment.split("---")[0];
        month = Integer.parseInt(assignment.split("---")[1]);
        day = Integer.parseInt(assignment.split("---")[2]);
        year = Integer.parseInt(assignment.split("---")[3]);
        hour = Integer.parseInt(assignment.split("---")[4]);
        minute = Integer.parseInt(assignment.split("---")[5]);
        //adjust the value for assignment
        assignment = name + "---" + month + "---" + day + "---" + year + "---" + hour + "---" + minute + "---" + p;
        //build the list
        list.add(assignment);
    }
    
    public static void removeElement(){
        list.remove(track);
    }
    
    private static void switchElements(int currentIndex){   //flips the values stored between the current and preivous elements of the list
        String current = list.set(currentIndex, list.get(currentIndex-1));
        list.set(currentIndex-1, current);
    }
    
    public static void sort(){      //bubblesort method b/c the list will likely never be beyond 100 assignments
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(Integer.parseInt(list.get(j).split("---")[3]) < Integer.parseInt(list.get(j-1).split("---")[3])) {   //checks year
                    //switch
                    
                } else if(Integer.parseInt(list.get(j).split("---")[3]) == Integer.parseInt(list.get(j-1).split("---")[3])) {   //checks year
                    //more checks
                    if(Integer.parseInt(list.get(j).split("---")[1]) < Integer.parseInt(list.get(j-1).split("---")[1])) {   //checks month
                    //switch
                        switchElements(j);
                    } else if(Integer.parseInt(list.get(j).split("---")[1]) == Integer.parseInt(list.get(j-1).split("---")[1])) {   //checks month
                        //more checks
                        if(Integer.parseInt(list.get(j).split("---")[2]) < Integer.parseInt(list.get(j-1).split("---")[2])) {   //checks day
                        //switch
                            switchElements(j);
                        } else if(Integer.parseInt(list.get(j).split("---")[2]) == Integer.parseInt(list.get(j-1).split("---")[2])) {   //checks day
                            //more checks
                            if(Integer.parseInt(list.get(j).split("---")[4]) < Integer.parseInt(list.get(j-1).split("---")[4])) {   //checks hour
                            //switch
                                switchElements(j);
                            } else if(Integer.parseInt(list.get(j).split("---")[4]) == Integer.parseInt(list.get(j-1).split("---")[4])) {   //checks hour
                                //more checks
                                if(Integer.parseInt(list.get(j).split("---")[5]) < Integer.parseInt(list.get(j-1).split("---")[5])) {   //checks minute
                                //switch
                                    switchElements(j);
                                } else if(Integer.parseInt(list.get(j).split("---")[5]) == Integer.parseInt(list.get(j-1).split("---")[5])) {   //checks minute
                                    //more checks
                                    if(Integer.parseInt(list.get(j).split("---")[6]) < Integer.parseInt(list.get(j-1).split("---")[6])) {   //checks priority
                                    //switch
                                        switchElements(j);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}