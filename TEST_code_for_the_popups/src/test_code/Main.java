/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_code;

/**
 *
 * @author Kyle Z
 */
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    private static Background backgroundProcess = new Background();
    public static LocalDateTime timePoint = LocalDateTime.now();    // The current date and time (YYYY-MM-DDTHH:MM:SS.642)
    
    public static void main(String[] args) throws IOException {
        String filePath;
        //method to read contents from the list file into the arraylist
        filePath = backgroundProcess.loadList();
        //check to see if the list is empty
        if(!backgroundProcess.isNull()){
            //remove all overdue assignments
            backgroundProcess.removeOnLoad();

            //check to see if the list is empty
            if(!backgroundProcess.isNull()){
                //due all the analytics here
                backgroundProcess.generatePOPUPS();
            }

            //write back to the file on the desktop
            backgroundProcess.writeFile(filePath);    //write to & save file
            //write back to the file runPMA in the documents folder
            backgroundProcess.createBackgroundFile(filePath);
        }
    }
}