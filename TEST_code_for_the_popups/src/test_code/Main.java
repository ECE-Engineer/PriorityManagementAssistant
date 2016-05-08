/*
 * This program will run in the background processes checking every hour if
 * there is an assignment that the user should be alerted about if it is close
 * enough to the due date of the assignment.
 */
package test_code;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;

//Kyle Zeller

public class Main {
    
    private static Background backgroundProcess = new Background();
    public static LocalDateTime timePoint = LocalDateTime.now();    // The current date and time (YYYY-MM-DDTHH:MM:SS.642)
        
    public static void main(String[] args) throws IOException, InterruptedException, MessagingException {
        String filePath;
        //method to read contents from the list file into the arraylist
        filePath = backgroundProcess.loadList();
        for(;;){
            //update the list
            backgroundProcess.updateList();
            
            //check to see if the list is empty
            if(!backgroundProcess.isNull()){

                //remove all overdue assignments
                backgroundProcess.removeOnLoad();

                //check to see if the list is empty
                if(!backgroundProcess.isNull()){
                    //due all the analytics here
                    backgroundProcess.generatePOPUPS();
                    
                    //due all the analytics here
                    backgroundProcess.generateEMAILS();
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
