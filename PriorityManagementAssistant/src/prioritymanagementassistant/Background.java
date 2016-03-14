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

public class Background {
    
    private static ArrayList<String> list = new ArrayList<>();
    private static PrintWriter backgroundFile, userFile;
    private static String filePath;
    
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
    
    public static boolean isList(){
        if(list != null)
            return true;
        else
            return false;
    }
    //ADD METHODS TO PARSE THE INFORMATION FOR THE CONTENTS OF AN INDIVIDUAL TASK
}

