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
 */
package prioritymanagementassistant;

//Kyle Zeller
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import static prioritymanagementassistant.Main.timePoint;

public class Background {

    Assignment assignment;
    ArrayList<Assignment> list = new ArrayList<>();
    PrintWriter backgroundFile, userFile;
    String filePath;
    int track = 0;

    public Background() {
        //default constructor
    }

    public String getDestinationFolder() {
        int count = 0;
        for (int i = 0; i < filePath.length(); i++) {
            if ((filePath.substring(i, i + 1)).equalsIgnoreCase("\\")) {
                count++;
            }
        }

        return (filePath.substring((filePath.lastIndexOf("\\", filePath.lastIndexOf("\\", filePath.length()) - 1)) + 1, filePath.lastIndexOf("\\", filePath.length())));
    }

    public void writeFile(String path) throws FileNotFoundException, UnsupportedEncodingException {//line ZERO must contain the path of the list file
        //open the text file
        userFile = new PrintWriter(path, "UTF-8");

        // write to the file
        for (Assignment content : list) {
            //System.out.println("DEBUG\t" + "WRITING\t\t" + content.getName() + "---" + content.getMonth() + "---" + content.getDay() + "---" + content.getYear() + "---" + content.getHour() + "---" + content.getMinute() + "---" + content.getPriority());   //DEBUG
            String minute = Integer.toString(content.getMinute());
            //System.out.println(minute);     //DEBUG
            if (content.getHour() == 0) {
                if (minute.length() == 1) {
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() + 12) + ":0" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() + 12) + ":" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
            } else if (content.getHour() < 12) {
                if (minute.length() == 1) {
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
            } else if (content.getHour() == 12) {
                if (minute.length() == 1) {
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
            } else {
                if (minute.length() == 1) {
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":0" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    userFile.print(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
            }
            userFile.println();
        }

        // Close the file.
        userFile.close();
    }

    public boolean validFilePath(String s) {
        int count = 0;
        if (s.contains("\\")) {
            for (int i = 0; i < s.length(); i++) {
                if ((s.substring(i, i + 1)).equalsIgnoreCase("\\")) {
                    count++;
                }
            }
            if (count > 1) {
                if (s.substring(s.indexOf("\\") + 1, s.indexOf("\\", s.indexOf("\\") + 1)).length() > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFile() { //check to see if this is the first time the user has run the program
        return (new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt").exists());
    }

    public void createBackgroundFile(String s) throws FileNotFoundException, UnsupportedEncodingException {  //make a background file to store all logs / program runs
        //make the file
        backgroundFile = new PrintWriter("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt", "UTF-8");

        //line ZERO must contain the path of the list file
        backgroundFile.print(s);
        backgroundFile.println();

        // write to the file the contents of the list
        for (Assignment content : list) {
            backgroundFile.print(content.getName() + "---" + content.getMonth() + "---" + content.getDay() + "---" + content.getYear() + "---" + content.getHour() + "---" + content.getMinute() + "---" + content.getPriority() + "---" + content.getPopup());
            backgroundFile.println();
        }

        //close the file
        backgroundFile.close();
    }

    public void createBatchFile() throws FileNotFoundException, UnsupportedEncodingException {
        //FilePermission permission = new FilePermission("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp\\", "write");
        //make the file
        backgroundFile = new PrintWriter("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp\\startup_PMA_popup_check.bat", "UTF-8");
        backgroundFile.print("javaw -Xmx200m -jar \"C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\PriorityManagementAssistant\\POPUPS\\dist\\POPUPS.jar\"");
        backgroundFile.println();
        //close the file
        backgroundFile.close();
    }

    public String loadList() throws FileNotFoundException, IOException {    //IF THE FILE EXISTS THE CONTENTS OF IT MUST BE LOADED PRIOR TO RUNNING THE MAIN PROGRAM
        File f = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\runPMA.txt");
        BufferedReader read = new BufferedReader(new FileReader(f));

        String line;
        if ((line = read.readLine()) != null)//store line 0 as the file path
        {
            filePath = line;
        }
        while ((line = read.readLine()) != null) {  //load the list
            //System.out.println("DEBUG\t" + "LOADING\t\t" + line);   //DEBUG
            assignment = new Assignment(line.split("---")[0], Integer.parseInt(line.split("---")[1]), Integer.parseInt(line.split("---")[2]), Integer.parseInt(line.split("---")[3]), Integer.parseInt(line.split("---")[4]), Integer.parseInt(line.split("---")[5]), Integer.parseInt(line.split("---")[6]), Boolean.parseBoolean(line.split("---")[7]));
            list.add(assignment);
        }
        return filePath;
    }

    public void buildList(Assignment build) {
        list.add(build);
    }

    public void printList() {
        //display all tasks
        for (Assignment content : list) {
            System.out.println(content.getName());
        }
    }

    public boolean getTaskInfo(String s) {    //prints all information about a given task
        //search for the task in the list using the task name
        boolean taskFound = false;
        int count = 0;
        for (Assignment content : list) {
            if (content.getName().equalsIgnoreCase(s)) {
                String minute = Integer.toString(content.getMinute());
                //System.out.println(minute);     //DEBUG
                if (content.getHour() == 0) {
                    if (minute.length() == 1) {
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() + 12) + ":0" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    } else {
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() + 12) + ":" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    }
                } else if (content.getHour() < 12) {
                    if (minute.length() == 1) {
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    } else {
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    }
                } else if (content.getHour() == 12) {
                    if (minute.length() == 1) {
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    } else {
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    }
                } else {
                    if (minute.length() == 1) {
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":0" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    } else {
                        System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                    }
                }
                taskFound = true;
                break;
            }
            count++;
        }
        return taskFound;
    }

    public void removeOnLoad() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getYear() < timePoint.getYear()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
                i--;
            } else if (list.get(i).getYear() == timePoint.getYear() && list.get(i).getMonth() < timePoint.getMonthValue()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
                i--;
            } else if (list.get(i).getYear() == timePoint.getYear() && list.get(i).getMonth() == timePoint.getMonthValue() && list.get(i).getDay() < timePoint.getDayOfMonth()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
                i--;
            } else if (list.get(i).getYear() == timePoint.getYear() && list.get(i).getMonth() == timePoint.getMonthValue() && list.get(i).getDay() == timePoint.getDayOfMonth() && list.get(i).getHour() < timePoint.getHour()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
                i--;
            } else if (list.get(i).getYear() == timePoint.getYear() && list.get(i).getMonth() == timePoint.getMonthValue() && list.get(i).getDay() == timePoint.getDayOfMonth() && list.get(i).getHour() == timePoint.getHour() && list.get(i).getMinute() < timePoint.getMinute()) {
                //System.out.println("DEBUG\t" + "DELETING\t\t" + list.get(i).getName());   //DEBUG
                list.remove(i);
                i--;
            }
        }
    }

    public boolean removeTask(String s) {
        //search for the task in the list using the task name
        boolean taskFound = true;
        int count = 0;
        for (Assignment content : list) {
            if (content.getName().equalsIgnoreCase(s)) {
                list.remove(count);
                taskFound = false;
                break;
            }
            count++;
        }
        return taskFound;
    }

    public void enableAllPopups() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPopup(true);
            //System.out.println(list.get(i).getName() + "\t" + list.get(i).getPopup());//DEBUG
        }
    }

    public void disableAllPopups() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPopup(false);
            //System.out.println(list.get(i).getName() + "\t" + list.get(i).getPopup());//DEBUG
        }
    }

    public boolean isNull() {
        return list.isEmpty();
    }

    public void printListDetails() {    //DEBUG :`PRINT ALL Assignments OF THE LIST
        //display all tasks & all their details
        for (Assignment content : list) {
            String minute = Integer.toString(content.getMinute());
            //System.out.println(minute);     //DEBUG
            if (content.getHour() == 0) {
                if (minute.length() == 1) {
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() + 12) + ":0" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() + 12) + ":" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
            } else if (content.getHour() < 12) {
                if (minute.length() == 1) {
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " AM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
            } else if (content.getHour() == 12) {
                if (minute.length() == 1) {
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":0" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + content.getHour() + ":" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
            } else {
                if (minute.length() == 1) {
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":0" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                } else {
                    System.out.println(content.getName() + "\t\t\t" + content.getMonth() + "/" + content.getDay() + "/" + content.getYear() + "\t\t\t" + (content.getHour() - 12) + ":" + content.getMinute() + " PM\t\t\t" + "PRIORITY:\t\t\t" + content.getPriority() + "\t\t\tPOPUPS:\t\t\t" + content.getPopup());
                }
            }
        }
    }

    public boolean isAssignmentPresent(String s) {
        //search for the task in the list using the task name
        boolean taskFound = false;  //assignment not present in list
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(s)) {
                taskFound = true;   //assignment present in list
                assignment = list.get(i);
                track = i;  //this will be used to perform a debug
                break;
            }
        }
        return taskFound;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    private void switchElements(int currentIndex) {   //flips the values stored between the current and preivous elements of the list
        Assignment current = list.set(currentIndex, list.get(currentIndex - 1));
        list.set(currentIndex - 1, current);
    }

    public void sort() {      //bubblesort method b/c the list will likely never be beyond 100 assignments
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j).getYear() < list.get(j - 1).getYear()) {   //checks year
                    //switch
                    switchElements(j);
                } else if (list.get(j).getYear() == list.get(j - 1).getYear()) {   //checks year
                    //more checks
                    if (list.get(j).getMonth() < list.get(j - 1).getMonth()) {   //checks month
                        //switch
                        switchElements(j);
                    } else if (list.get(j).getMonth() == list.get(j - 1).getMonth()) {   //checks month
                        //more checks
                        if (list.get(j).getDay() < list.get(j - 1).getDay()) {   //checks day
                            //switch
                            switchElements(j);
                        } else if (list.get(j).getDay() == list.get(j - 1).getDay()) {   //checks day
                            //more checks
                            if (list.get(j).getHour() < list.get(j - 1).getHour()) {   //checks hour
                                //switch
                                switchElements(j);
                            } else if (list.get(j).getHour() == list.get(j - 1).getHour()) {   //checks hour
                                //more checks
                                if (list.get(j).getMinute() < list.get(j - 1).getMinute()) {   //checks minute
                                    //switch
                                    switchElements(j);
                                } else if (list.get(j).getMinute() == list.get(j - 1).getMinute()) {   //checks minute
                                    //more checks
                                    if (list.get(j).getPriority() < list.get(j - 1).getPriority()) {   //checks priority
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
