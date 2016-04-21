/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

/**
 *
 * @author Kyle Z
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import static popups.Main.timePoint;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Background {
    private static Assignment assignment;
    private static ArrayList<Assignment> list = new ArrayList<>();
    private static PrintWriter backgroundFile, userFile;
    private static String filePath;
    
    public Background(){
        //default constructor
    }
    
    public String getDestinationFolder(){
        int count = 0;
        for (int i = 0; i < filePath.length(); i++) {
            if((filePath.substring(i, i+1)).equalsIgnoreCase("\\"))
                count++;
        }
        
        return (filePath.substring((filePath.lastIndexOf("\\", filePath.lastIndexOf("\\", filePath.length())-1))+1, filePath.lastIndexOf("\\", filePath.length())));
    }
    
    public void writeFile(String path) throws FileNotFoundException, UnsupportedEncodingException{//line ZERO must contain the path of the list file
        //open the text file
        userFile = new PrintWriter(path, "UTF-8");
        
        // write to the file
        for(Assignment content : list){
            //System.out.println("DEBUG\t" + "WRITING\t\t" + content.getName() + "---" + content.getMonth() + "---" + content.getDay() + "---" + content.getYear() + "---" + content.getHour() + "---" + content.getMinute() + "---" + content.getPriority());   //DEBUG
            String minute = Integer.toString(content.getMinute());
            //System.out.println(minute);     //DEBUG
            if(content.getHour() <= 12){
                if(minute.length() == 1){
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " AM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " AM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
            } else {
                if(minute.length() == 1){
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":0" + content.getMinute() + " PM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":" + content.getMinute() + " PM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
            }
            userFile.println();
        }

        // Close the file.
        userFile.close();
    }
    
    public boolean validFilePath(String s){
        int count = 0;
        if(s.contains("\\")){
            for (int i = 0; i < s.length(); i++) {
                if((s.substring(i, i+1)).equalsIgnoreCase("\\"))
                    count++;
            }
            if(count > 1){
                if(s.substring(s.indexOf("\\")+1, s.indexOf("\\", s.indexOf("\\")+1)).length() > 1)
                    return true;
            }
        }
        return false;
    }
    
    public boolean isFile(){ //check to see if this is the first time the user has run the program
        return (new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt").exists());
    }
    
    public void createBackgroundFile(String s) throws FileNotFoundException, UnsupportedEncodingException{  //make a background file to store all logs / program runs
        //make the file
        backgroundFile = new PrintWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt", "UTF-8");
        
        //line ZERO must contain the path of the list file
        backgroundFile.print(s);
        backgroundFile.println();
        
        // write to the file the contents of the list
        for(Assignment content : list){
            backgroundFile.print(content.getName() + "---" + content.getMonth() + "---" + content.getDay() + "---" + content.getYear() + "---" + content.getHour() + "---" + content.getMinute() + "---" + content.getPriority() + "---" + content.getPopup());
            backgroundFile.println();
        }

        //close the file
        backgroundFile.close();
    }
    
    public void createBatchFile() throws FileNotFoundException, UnsupportedEncodingException{
        //FilePermission permission = new FilePermission("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp\\", "write");
        //make the file
        backgroundFile = new PrintWriter("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp\\startup_PMA_popup_check.bat", "UTF-8");
        backgroundFile.print("javaw -Xmx200m -jar \"C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\PriorityManagementAssistant\\POPUPS\\dist\\POPUPS.jar\"");
        backgroundFile.println();
        //close the file
        backgroundFile.close();
    }
    
    public String loadList() throws FileNotFoundException, IOException{    //IF THE FILE EXISTS THE CONTENTS OF IT MUST BE LOADED PRIOR TO RUNNING THE MAIN PROGRAM
        File f = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt");
        BufferedReader read = new BufferedReader(new FileReader(f));
        
        String line;
        if((line = read.readLine()) != null)//store line 0 as the file path
            filePath = line;
        while ((line = read.readLine()) != null) {  //load the list
            //System.out.println("DEBUG\t" + "LOADING\t\t" + line);   //DEBUG
            assignment = new Assignment(line.split("---")[0], Integer.parseInt(line.split("---")[1]), Integer.parseInt(line.split("---")[2]), Integer.parseInt(line.split("---")[3]), Integer.parseInt(line.split("---")[4]), Integer.parseInt(line.split("---")[5]), Integer.parseInt(line.split("---")[6]), Boolean.parseBoolean(line.split("---")[7]));
            list.add(assignment);
        }
        return filePath;
    }
    
    public void buildList(Assignment build){
        list.add(build);
    }
    
    public void printList() {
        //display all tasks
        for(Assignment content : list){
            System.out.println(content.getName());
        }
    }
    
    public void printListDetails() {    //DEBUG :`PRINT ALL Assignments OF THE LIST
        //display all tasks & all their details
        for(Assignment content : list){
            String minute = Integer.toString(content.getMinute());
            //System.out.println(minute);     //DEBUG
            if(content.getHour() <= 12){
                if(minute.length() == 1){
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " AM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " AM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
            } else {
                if(minute.length() == 1){
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":0" + content.getMinute() + " PM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":" + content.getMinute() + " PM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
            }
        }
    }
    
    public void generatePOPUPS(){
        for(Assignment content : list){
            if(content.getPopup() == true){
                //make an object / GUI to have a size, background color, & to display a message on it!!!
                JPanel gui = new JPanel();
                EmptyBorder borderSize;
                //declare the message
                String message;
                //declare a text field for the message
                JTextField textField;
                //declare the font size
                Font bigFont;
                //declare a frame title
                JFrame frame;
                
                //start the conparison
                if(content.getYear() == timePoint.getYear()){//if true look at month
                    if(content.getMonth() == timePoint.getMonthValue()){//if true look at day
                        if(content.getDay() == timePoint.getDayOfMonth()){//if true look at hour
                            if(((content.getHour()-timePoint.getHour()) < 3) || ((((content.getHour()-timePoint.getHour()) == 3)) && ((content.getMinute() < timePoint.getMinute())))){
                                //check the priority
                                if(content.getPriority() == 3){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 3 Hours!!!";
                                    //set the size to large
                                    borderSize = new EmptyBorder(514, 768, 514, 768);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to red
                                    gui.setBackground(Color.red);
                                    frame = new JFrame("SUPER IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else if(content.getPriority() == 2){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 3 Hours!!!";
                                    //set the size to large
                                    borderSize = new EmptyBorder(514, 768, 514, 768);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to yellow
                                    gui.setBackground(Color.yellow);
                                    frame = new JFrame("VERY IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else{//priority assumed to be 1
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 3 Hours!!!";
                                    //set the size to large
                                    borderSize = new EmptyBorder(514, 768, 514, 768);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to green
                                    gui.setBackground(Color.green);
                                    frame = new JFrame("IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                }
                            } else if(((content.getHour()-timePoint.getHour()) < 6) || ((((content.getHour()-timePoint.getHour()) == 6)) && ((content.getMinute() < timePoint.getMinute())))){
                                //check the priority
                                if(content.getPriority() == 3){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 6 Hours!!!";
                                    //set the size to medium
                                    borderSize = new EmptyBorder(128, 192, 128, 192);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to red
                                    gui.setBackground(Color.red);
                                    frame = new JFrame("SUPER IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else if(content.getPriority() == 2){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 6 Hours!!!";
                                    //set the size to medium
                                    borderSize = new EmptyBorder(128, 192, 128, 192);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to yellow
                                    gui.setBackground(Color.yellow);
                                    frame = new JFrame("VERY IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else{//priority assumed to be 1
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 6 Hours!!!";
                                    //set the size to medium
                                    borderSize = new EmptyBorder(128, 192, 128, 192);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to green
                                    gui.setBackground(Color.green);
                                    frame = new JFrame("IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                }
                            } else if(((content.getHour()-timePoint.getHour()) < 12) || ((((content.getHour()-timePoint.getHour()) == 12)) && ((content.getMinute() < timePoint.getMinute())))){
                                //check the priority
                                if(content.getPriority() == 3){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 12 Hours!!!";
                                    //set the size to small
                                    borderSize = new EmptyBorder(32, 48, 32, 48);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);
                                    //set the color to red
                                    gui.setBackground(Color.red);
                                    frame = new JFrame("SUPER IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else if(content.getPriority() == 2){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 12 Hours!!!";
                                    //set the size to small
                                    borderSize = new EmptyBorder(32, 48, 32, 48);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);
                                    //set the color to yellow
                                    gui.setBackground(Color.yellow);
                                    frame = new JFrame("VERY IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else{//priority assumed to be 1
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 12 Hours!!!";
                                    //set the size to small
                                    borderSize = new EmptyBorder(32, 48, 32, 48);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);
                                    //set the color to green
                                    gui.setBackground(Color.green);
                                    frame = new JFrame("IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                }
                            }
                        } else if((content.getDay() - timePoint.getDayOfMonth()) == 1){//if true look at hour
                            if((((24 - timePoint.getHour()) + content.getHour()) < 3) || ((((24 - timePoint.getHour()) + content.getHour()) == 3) && ((content.getMinute() < timePoint.getMinute())))){
                                //check the priority
                                if(content.getPriority() == 3){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 3 Hours!!!";
                                    //set the size to large
                                    borderSize = new EmptyBorder(514, 768, 514, 768);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to red
                                    gui.setBackground(Color.red);
                                    frame = new JFrame("SUPER IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else if(content.getPriority() == 2){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 3 Hours!!!";
                                    //set the size to large
                                    borderSize = new EmptyBorder(514, 768, 514, 768);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to yellow
                                    gui.setBackground(Color.yellow);
                                    frame = new JFrame("VERY IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else{//priority assumed to be 1
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 3 Hours!!!";
                                    //set the size to large
                                    borderSize = new EmptyBorder(514, 768, 514, 768);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to green
                                    gui.setBackground(Color.green);
                                    frame = new JFrame("IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                }
                            } else if((((24 - timePoint.getHour()) + content.getHour()) < 6) || ((((24 - timePoint.getHour()) + content.getHour()) == 6) && ((content.getMinute() < timePoint.getMinute())))){
                                //check the priority
                                if(content.getPriority() == 3){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 6 Hours!!!";
                                    //set the size to medium
                                    borderSize = new EmptyBorder(128, 192, 128, 192);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to red
                                    gui.setBackground(Color.red);
                                    frame = new JFrame("SUPER IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else if(content.getPriority() == 2){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 6 Hours!!!";
                                    //set the size to medium
                                    borderSize = new EmptyBorder(128, 192, 128, 192);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to yellow
                                    gui.setBackground(Color.yellow);
                                    frame = new JFrame("VERY IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else{//priority assumed to be 1
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 6 Hours!!!";
                                    //set the size to medium
                                    borderSize = new EmptyBorder(128, 192, 128, 192);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);

                                    //set the color to green
                                    gui.setBackground(Color.green);
                                    frame = new JFrame("IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                }
                            } else if((((24 - timePoint.getHour()) + content.getHour()) < 12) || ((((24 - timePoint.getHour()) + content.getHour()) == 12) && ((content.getMinute() < timePoint.getMinute())))){
                                //check the priority
                                if(content.getPriority() == 3){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 12 Hours!!!";
                                    //set the size to small
                                    borderSize = new EmptyBorder(32, 48, 32, 48);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);
                                    //set the color to red
                                    gui.setBackground(Color.red);
                                    frame = new JFrame("SUPER IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else if(content.getPriority() == 2){
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 12 Hours!!!";
                                    //set the size to small
                                    borderSize = new EmptyBorder(32, 48, 32, 48);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);
                                    //set the color to yellow
                                    gui.setBackground(Color.yellow);
                                    frame = new JFrame("VERY IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                } else{//priority assumed to be 1
                                    //Set the text to display
                                    message = "Your Assignment " + content.getName() + " is due in the next 12 Hours!!!";
                                    //set the size to small
                                    borderSize = new EmptyBorder(32, 48, 32, 48);
                                    gui.setBorder(borderSize);
                                    textField = new JTextField(message);//create text field for the message
                                    bigFont = textField.getFont().deriveFont(Font.PLAIN, 50f);//set the font size
                                    textField.setFont(bigFont);
                                    textField.setEditable(false);
                                    gui.add(textField, BorderLayout.CENTER);
                                    //set the color to green
                                    gui.setBackground(Color.green);
                                    frame = new JFrame("IMPORTANT POPUPS!!!");
                                    frame.add(gui);
                                    // Ensures JVM closes after frame(s) closed and
                                    // all non-daemon threads are finished
                                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    frame.setLocationByPlatform(true);
                                    // ensures the frame is the minimum size it needs to be
                                    // in order display the components within it
                                    frame.pack();
                                    frame.setLocationRelativeTo(null);
                                    // should be done last, to avoid flickering, moving,
                                    // resizing artifacts.
                                    frame.setVisible(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public boolean getTaskInfo(String s){    //prints all information about a given task
        //search for the task in the list using the task name
        boolean taskFound = false;
        int count = 0;
        for(Assignment content : list){
            if(content.getName().equalsIgnoreCase(s)){
                String minute = Integer.toString(content.getMinute());
                //System.out.println(minute);     //DEBUG
                if(content.getHour() <= 12){
                    if(minute.length() == 1){
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " AM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    } else
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " AM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    if(minute.length() == 1){
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":0" + content.getMinute() + " PM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    } else
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":" + content.getMinute() + " PM\t\t\t" +  "PRIORITY:\t\t\t" + content.getPriority() +  "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
                taskFound = true;
                break;
            }
            count++;
        }
        return taskFound;
    }
    
    public void removeOnLoad(){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getYear() < timePoint.getYear()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
            } else if(list.get(i).getYear() == timePoint.getYear() && list.get(i).getMonth() < timePoint.getMonthValue()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
            } else if(list.get(i).getYear() == timePoint.getYear() && list.get(i).getMonth() == timePoint.getMonthValue() && list.get(i).getDay() < timePoint.getDayOfMonth()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
            } else if(list.get(i).getYear() == timePoint.getYear() && list.get(i).getMonth() == timePoint.getMonthValue() && list.get(i).getDay() == timePoint.getDayOfMonth() && list.get(i).getHour() < timePoint.getHour()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
            } else if(list.get(i).getYear() == timePoint.getYear() && list.get(i).getMonth() == timePoint.getMonthValue() && list.get(i).getDay() == timePoint.getDayOfMonth() && list.get(i).getHour() == timePoint.getHour() && list.get(i).getMinute() < timePoint.getMinute()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
            }
        }
    }
    
    public boolean removeTask(String s){
        //search for the task in the list using the task name
        boolean taskFound = true;
        int count = 0;
        for(Assignment content : list){
            if(content.getName().equalsIgnoreCase(s)){
                list.remove(count);
                taskFound = false;
                break;
            }
            count++;
        }
        return taskFound;
    }
    
    public void enableAllPopups(){
        for(Assignment content : list){
            content.setPopup(true);
        }
    }
    
    public void disableAllPopups(){
        for(Assignment content : list){
            content.setPopup(false);
        }
    }
    
    public boolean isNull(){
        return list.isEmpty();
    }
    
    public static boolean isAssignmentPresent(String s){
        //search for the task in the list using the task name
        boolean taskFound = false;  //assignment not present in list
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equalsIgnoreCase(s)){
                taskFound = true;   //assignment present in list
                assignment = list.get(i);
                break;
            }
        }
        return taskFound;
    }
    
    public Assignment getAssignment(){
        return assignment;
    }
    
    private void switchElements(int currentIndex){   //flips the values stored between the current and preivous elements of the list
        Assignment current = list.set(currentIndex, list.get(currentIndex-1));
        list.set(currentIndex-1, current);
    }
    
    public void sort(){      //bubblesort method b/c the list will likely never be beyond 100 assignments
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if(list.get(j).getYear() < list.get(j-1).getYear()) {   //checks year
                    //switch
                    switchElements(j);
                } else if(list.get(j).getYear() == list.get(j-1).getYear()) {   //checks year
                    //more checks
                    if(list.get(j).getMonth() < list.get(j-1).getMonth()) {   //checks month
                        //switch
                        switchElements(j);
                    } else if(list.get(j).getMonth() == list.get(j-1).getMonth()) {   //checks month
                        //more checks
                        if(list.get(j).getDay() < list.get(j-1).getDay()) {   //checks day
                            //switch
                            switchElements(j);
                        } else if(list.get(j).getDay() == list.get(j-1).getDay()) {   //checks day
                            //more checks
                            if(list.get(j).getHour() < list.get(j-1).getHour()) {   //checks hour
                                //switch
                                switchElements(j);
                            } else if(list.get(j).getHour() == list.get(j-1).getHour()) {   //checks hour
                                //more checks
                                if(list.get(j).getMinute() < list.get(j-1).getMinute()) {   //checks minute
                                    //switch
                                    switchElements(j);
                                } else if(list.get(j).getMinute() == list.get(j-1).getMinute()) {   //checks minute
                                    //more checks
                                    if(list.get(j).getPriority() < list.get(j-1).getPriority()) {   //checks priority
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
