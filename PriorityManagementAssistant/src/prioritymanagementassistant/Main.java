/*
The Priority Management Assistant (PMA) will be a desktop application for
windows and linux that will prioritize the everyday life of an individual.
The user must be able to input their class assignments such as homeworks,
projects, labs, upcoming exams and quizzes, meetings, classes, etc. The program
needs to be well organized and have good structure for a graphical user
interface to make it as simple as possible for the user to create, remove, or
edit an upcoming assignment. This graphical user interface must provide
clickable buttons for certain features such as adding, removing, and saving an
assignment. As the program is running, there needs to be a list of all
assignments with deadlines for some set interval of time. The program needs
to be able to update itself every time the user adds, removes, or edits their
assignments. There also needs to be a way to list the assignments in order of
importance according to the user’s specification when he/she submits the
assignment. There will be a feature that the user can configure that will
enable screen pop-ups as reminders for those assignments.
 */





package prioritymanagementassistant;

import java.util.Scanner;

/**
 * @author Kyle Z
 */
public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome I am your Priority Management Assistant");
        System.out.println("Would you like to make an assignment?\t" + ("Y / N"));
        String choice = kb.nextLine();
        
        if(choice.equalsIgnoreCase("Y"))
            //prompt user for stuff
            
    }
    
}
