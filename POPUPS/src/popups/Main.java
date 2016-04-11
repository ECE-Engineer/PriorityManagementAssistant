/*
 * This program will run in the background processes checking every hour if
 * there is an assignment that the user should be alerted about if it is close
 * enough to the due date of the assignment.
 */
package popups;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

//Kyle Zeller

public class Main {
    
        private static Background backgroundProcess = new Background();
        public static LocalDateTime timePoint = LocalDateTime.now();    // The current date and time (YYYY-MM-DDTHH:MM:SS.642)
        
    public static void main(String[] args) throws IOException, InterruptedException {
        String filePath;
        //method to read contents from the list file into the arraylist
        filePath = backgroundProcess.loadList();
        //check to see if the list is empty
        if(!backgroundProcess.isNull()){
            for(;;){
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

                //add a delay for 1 iteration every hour
                TimeUnit.HOURS.sleep(1);
            }
        }
    }
    
}
