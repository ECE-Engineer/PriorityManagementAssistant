/* REQ 1 & 2
 * The Priority Management Assistant (PMA):
 * currently allows the user to make an assignment and sucessfully save it to
 * the file. We have made many changes to the program to ensure that the program
 * at it's current state, won't break with invalid input.

 * REQ 3
 * The PMA is now capable of reading the previous written data from the file
 * to the list. The program will run and update its list from the list file
 * before the user starts adding information to the list. A second file is also
 * generated to keep track of these logs and acts as a failsafe in-case the
 * list file generated was deleted or moved.

 * REQ 4
 * Show the user all the tasks with (optional) additional information & allow
 * the user to delete assignments. DELETE THE ASSIGNMENTS BY TITLE.

 * REQ 5
 * The program will delete overdue assignments after the due date has passed.
 * The program will delete these overdue assignments on start-up.

 * REQ 6
 * The program will allow the user to edit any assignment, including any
 * specific content of that assignment.

 * REQ 7    --->    (IN GUI PROGRAM)
 * The program will allow the user to pick the priority of an assignent by
 * color.

 * REQ 8
 * The program will automatically order assignments by due date and priority,
 * before they are added to the list.

 * REQ 9
 * Create pop-ups for the assignments, where as the priority level determines
 * the color of the pop-up & the close-ness to the dealine determines the size
 * of the pop-ups. This part of the program must be able to run at different
 * time intervals than that of the program. This will be the "smart" part of the
 * program because of what it will require the program to do. In other words the
 * program will at random times look at the current time and compare that to the
 * items in the list and at 24, 12, 6, 3, 2, 1 hr notification times. The
 * program will have to know when to check the list and when to notify the user.

 * REQ 10
 * Create a dialog box that allows the user to enable & disable popups for
 * assignments.

 * REQ 11
 * Create & implement a GUI to easily configure and manage assignments.
 */

package gui;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Kyle Zeller
 * Andrew B
 */
public class GUI extends javax.swing.JFrame {
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a1_button;
    private javax.swing.JButton a2_button;
    private javax.swing.JButton a3_button;
    private javax.swing.JButton a4_button;
    private javax.swing.JButton a5_button;
    private javax.swing.JButton createButton;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> hourComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> minuteComboBox;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JTextField nameTextBox;
    private javax.swing.JComboBox<String> priorityComboBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextBox;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
    private static ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    
    private static Background backgroundProcess = new Background();
    private static Assignment assignment;
    public static LocalDateTime timePoint = LocalDateTime.now();    // The current date and time (YYYY-MM-DDTHH:MM:SS.642)

    private Component frame;

    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        a1_button = new javax.swing.JButton();
        a2_button = new javax.swing.JButton();
        a3_button = new javax.swing.JButton();
        a4_button = new javax.swing.JButton();
        a5_button = new javax.swing.JButton();
        searchTextBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameTextBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dayComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        hourComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        minuteComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        priorityComboBox = new javax.swing.JComboBox<>();
        createButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Priority Management Assistant");
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Welcome, I am your Priority Management Assistant");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Upcoming Assignments:");

        a1_button.setBackground(new java.awt.Color(255, 255, 204));
        a1_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1_buttonActionPerformed(evt);
            }
        });

        a2_button.setBackground(new java.awt.Color(255, 255, 204));
        a2_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2_buttonActionPerformed(evt);
            }
        });

        a3_button.setBackground(new java.awt.Color(255, 255, 204));
        a3_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3_buttonActionPerformed(evt);
            }
        });

        a4_button.setBackground(new java.awt.Color(255, 255, 204));
        a4_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4_buttonActionPerformed(evt);
            }
        });

        a5_button.setBackground(new java.awt.Color(255, 255, 204));
        a5_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a5_buttonActionPerformed(evt);
            }
        });

        searchTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextBoxActionPerformed(evt);
            }
        });

        searchButton.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(a5_button)
                    .addComponent(a4_button)
                    .addComponent(a3_button)
                    .addComponent(a2_button)
                    .addComponent(a1_button)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(searchTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(43, 43, 43)
                .addComponent(a1_button)
                .addGap(18, 18, 18)
                .addComponent(a2_button)
                .addGap(18, 18, 18)
                .addComponent(a3_button)
                .addGap(18, 18, 18)
                .addComponent(a4_button)
                .addGap(18, 18, 18)
                .addComponent(a5_button)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Add an Assignment:");

        jLabel3.setText("Name:");

        jLabel4.setText("Month Due:");

        monthComboBox.setMaximumRowCount(12);
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel5.setText("Day Due:");

        dayComboBox.setMaximumRowCount(31);
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel6.setText("Year Due:");

        yearComboBox.setMaximumRowCount(5);
        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2016", "2017", "2018", "2019", "2020" }));

        jLabel7.setText("Hour Due:");

        hourComboBox.setMaximumRowCount(24);
        hourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jLabel8.setText("Minute Due:");

        minuteComboBox.setMaximumRowCount(4);
        minuteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "59" }));

        jLabel9.setText("Priority");

        priorityComboBox.setMaximumRowCount(3);
        priorityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        createButton.setText("Create Assignment");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(createButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(8, 8, 8))
                                    .addComponent(jLabel8))
                                .addComponent(jLabel9))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(minuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(nameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(minuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(priorityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String name;
    int month, day, year, hour, minute, priority;
    boolean popup = false;

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        deleteButton.setVisible(false);

        if (backgroundProcess.isAssignmentPresent(nameTextBox.getText())) {
            //Checks to see if the name already exists, if it does, pops up error. names must be unique. 
            JOptionPane.showMessageDialog(frame, nameTextBox.getText() + " already exists, please try a new name.", "Repeated Name Error", JOptionPane.ERROR_MESSAGE);
        } else {
            name = nameTextBox.getText();
            month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (dayComboBox.getSelectedItem().toString().equals("31")) {
                    JOptionPane.showMessageDialog(frame, dayComboBox.getSelectedItem().toString() + " is not a valid day of the month, please try again", "Day Doesn't Exist", JOptionPane.ERROR_MESSAGE);
                } else {
                    day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
                }
            } else if (month == 2) {
                if (dayComboBox.getSelectedItem().toString().equals("29") || dayComboBox.getSelectedItem().toString().equals("30") || dayComboBox.getSelectedItem().toString().equals("31")) {
                    JOptionPane.showMessageDialog(frame, dayComboBox.getSelectedItem().toString() + " is not a valid day of the month, please try again", "Day Doesn't Exist", JOptionPane.ERROR_MESSAGE);
                } else {
                    day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
                }
            }
            year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
            hour = Integer.parseInt(hourComboBox.getSelectedItem().toString());
            minute = Integer.parseInt(minuteComboBox.getSelectedItem().toString());
            priority = Integer.parseInt(priorityComboBox.getSelectedItem().toString());
            assignment = new Assignment(name, month, day, year, hour, minute, priority, popup);
            assignments.add(assignment);
            monthComboBox.setSelectedIndex(0);
            dayComboBox.setSelectedIndex(0);
            yearComboBox.setSelectedIndex(0);
            hourComboBox.setSelectedIndex(0);
            minuteComboBox.setSelectedIndex(0);
            priorityComboBox.setSelectedIndex(0);
            nameTextBox.setText("");
        }
        refreshList();
    }//GEN-LAST:event_createButtonActionPerformed

    String[] taskName;

    public void refreshList() {
        for (int i = 0; i < assignments.size() || i < 5; i++) {
            if (!assignments.get(i).getName().isEmpty()) {
                assignment = assignments.get(i);
                name = assignment.getName();
                month = assignment.getMonth();
                day = assignment.getDay();
                year = assignment.getYear();
                hour = assignment.getHour();
                minute = assignment.getMinute();
                priority = assignment.getPriority();
                popup = assignment.getPopup();

                if (i == 0) {
                    a1_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
                } else if (i == 1) {
                    a2_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
                } else if (i == 2) {
                    a3_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
                } else if (i == 3) {
                    a4_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
                } else if (i == 4) {
                    a5_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
                }
            }
        }
    }


    private void a2_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2_buttonActionPerformed
        deleteButton.setVisible(true);

        //removeTask(a2_button.getText().split("\t")[0]);
        nameTextBox.setText(a2_button.getText().split("\t")[0]);
        monthComboBox.setSelectedIndex(Integer.parseInt(a2_button.getText().split("\t")[2]) - 1);
        dayComboBox.setSelectedIndex(Integer.parseInt(a2_button.getText().split("\t")[4]) - 1);
        if (Integer.parseInt(a2_button.getText().split("\t")[6]) == 2016) {
            yearComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[6]) == 2017) {
            yearComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[6]) == 2018) {
            yearComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[6]) == 2019) {
            yearComboBox.setSelectedIndex(3);
        } else {
            yearComboBox.setSelectedIndex(4);
        }
        hourComboBox.setSelectedIndex(Integer.parseInt(a2_button.getText().split("\t")[8]) - 1);
        if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 00) {
            minuteComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 05) {
            minuteComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 10) {
            minuteComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 15) {
            minuteComboBox.setSelectedIndex(3);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 20) {
            minuteComboBox.setSelectedIndex(4);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 25) {
            minuteComboBox.setSelectedIndex(5);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 30) {
            minuteComboBox.setSelectedIndex(6);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 35) {
            minuteComboBox.setSelectedIndex(7);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 40) {
            minuteComboBox.setSelectedIndex(8);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 45) {
            minuteComboBox.setSelectedIndex(9);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 50) {
            minuteComboBox.setSelectedIndex(10);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[10]) == 55) {
            minuteComboBox.setSelectedIndex(11);
        } else {
            minuteComboBox.setSelectedIndex(12);
        }

        if (Integer.parseInt(a2_button.getText().split("\t")[12]) == 1) {
            priorityComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a2_button.getText().split("\t")[12]) == 2) {
            priorityComboBox.setSelectedIndex(1);
        } else {
            priorityComboBox.setSelectedIndex(2);
        }

        refreshList();
        //If they select delete, remove the assignment then set fields back to default, and remove the delete button
    }//GEN-LAST:event_a2_buttonActionPerformed

    private void a3_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3_buttonActionPerformed
        deleteButton.setVisible(true);

        //removeTask(a3_button.getText().split("\t")[0]);
        nameTextBox.setText(a3_button.getText().split("\t")[0]);
        monthComboBox.setSelectedIndex(Integer.parseInt(a3_button.getText().split("\t")[2]) - 1);
        dayComboBox.setSelectedIndex(Integer.parseInt(a3_button.getText().split("\t")[4]) - 1);
        if (Integer.parseInt(a3_button.getText().split("\t")[6]) == 2016) {
            yearComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[6]) == 2017) {
            yearComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[6]) == 2018) {
            yearComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[6]) == 2019) {
            yearComboBox.setSelectedIndex(3);
        } else {
            yearComboBox.setSelectedIndex(4);
        }
        hourComboBox.setSelectedIndex(Integer.parseInt(a3_button.getText().split("\t")[8]) - 1);
        if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 00) {
            minuteComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 05) {
            minuteComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 10) {
            minuteComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 15) {
            minuteComboBox.setSelectedIndex(3);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 20) {
            minuteComboBox.setSelectedIndex(4);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 25) {
            minuteComboBox.setSelectedIndex(5);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 30) {
            minuteComboBox.setSelectedIndex(6);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 35) {
            minuteComboBox.setSelectedIndex(7);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 40) {
            minuteComboBox.setSelectedIndex(8);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 45) {
            minuteComboBox.setSelectedIndex(9);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 50) {
            minuteComboBox.setSelectedIndex(10);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[10]) == 55) {
            minuteComboBox.setSelectedIndex(11);
        } else {
            minuteComboBox.setSelectedIndex(12);
        }

        if (Integer.parseInt(a3_button.getText().split("\t")[12]) == 1) {
            priorityComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a3_button.getText().split("\t")[12]) == 2) {
            priorityComboBox.setSelectedIndex(1);
        } else {
            priorityComboBox.setSelectedIndex(2);
        }

        refreshList();
    }//GEN-LAST:event_a3_buttonActionPerformed

    private void a1_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1_buttonActionPerformed
        deleteButton.setVisible(true);

        //removeTask(a1_button.getText().split("\t")[0]);
        nameTextBox.setText(a1_button.getText().split("\t")[0]);
        monthComboBox.setSelectedIndex(Integer.parseInt(a1_button.getText().split("\t")[2]) - 1);
        dayComboBox.setSelectedIndex(Integer.parseInt(a1_button.getText().split("\t")[4]) - 1);
        if (Integer.parseInt(a1_button.getText().split("\t")[6]) == 2016) {
            yearComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[6]) == 2017) {
            yearComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[6]) == 2018) {
            yearComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[6]) == 2019) {
            yearComboBox.setSelectedIndex(3);
        } else {
            yearComboBox.setSelectedIndex(4);
        }
        hourComboBox.setSelectedIndex(Integer.parseInt(a1_button.getText().split("\t")[8]) - 1);
        if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 00) {
            minuteComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 05) {
            minuteComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 10) {
            minuteComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 15) {
            minuteComboBox.setSelectedIndex(3);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 20) {
            minuteComboBox.setSelectedIndex(4);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 25) {
            minuteComboBox.setSelectedIndex(5);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 30) {
            minuteComboBox.setSelectedIndex(6);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 35) {
            minuteComboBox.setSelectedIndex(7);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 40) {
            minuteComboBox.setSelectedIndex(8);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 45) {
            minuteComboBox.setSelectedIndex(9);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 50) {
            minuteComboBox.setSelectedIndex(10);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[10]) == 55) {
            minuteComboBox.setSelectedIndex(11);
        } else {
            minuteComboBox.setSelectedIndex(12);
        }

        if (Integer.parseInt(a1_button.getText().split("\t")[12]) == 1) {
            priorityComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a1_button.getText().split("\t")[12]) == 2) {
            priorityComboBox.setSelectedIndex(1);
        } else {
            priorityComboBox.setSelectedIndex(2);
        }

        refreshList();
    }//GEN-LAST:event_a1_buttonActionPerformed

    private void a4_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4_buttonActionPerformed
        deleteButton.setVisible(true);

        //removeTask(a4_button.getText().split("\t")[0]);
        nameTextBox.setText(a4_button.getText().split("\t")[0]);
        monthComboBox.setSelectedIndex(Integer.parseInt(a4_button.getText().split("\t")[2]) - 1);
        dayComboBox.setSelectedIndex(Integer.parseInt(a4_button.getText().split("\t")[4]) - 1);
        if (Integer.parseInt(a4_button.getText().split("\t")[6]) == 2016) {
            yearComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[6]) == 2017) {
            yearComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[6]) == 2018) {
            yearComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[6]) == 2019) {
            yearComboBox.setSelectedIndex(3);
        } else {
            yearComboBox.setSelectedIndex(4);
        }
        hourComboBox.setSelectedIndex(Integer.parseInt(a4_button.getText().split("\t")[8]) - 1);
        if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 00) {
            minuteComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 05) {
            minuteComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 10) {
            minuteComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 15) {
            minuteComboBox.setSelectedIndex(3);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 20) {
            minuteComboBox.setSelectedIndex(4);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 25) {
            minuteComboBox.setSelectedIndex(5);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 30) {
            minuteComboBox.setSelectedIndex(6);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 35) {
            minuteComboBox.setSelectedIndex(7);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 40) {
            minuteComboBox.setSelectedIndex(8);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 45) {
            minuteComboBox.setSelectedIndex(9);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 50) {
            minuteComboBox.setSelectedIndex(10);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[10]) == 55) {
            minuteComboBox.setSelectedIndex(11);
        } else {
            minuteComboBox.setSelectedIndex(12);
        }

        if (Integer.parseInt(a4_button.getText().split("\t")[12]) == 1) {
            priorityComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a4_button.getText().split("\t")[12]) == 2) {
            priorityComboBox.setSelectedIndex(1);
        } else {
            priorityComboBox.setSelectedIndex(2);
        }

        refreshList();
    }//GEN-LAST:event_a4_buttonActionPerformed

    private void a5_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a5_buttonActionPerformed
        deleteButton.setVisible(true);

        //removeTask(a5_button.getText().split("\t")[0]);
        nameTextBox.setText(a5_button.getText().split("\t")[0]);
        monthComboBox.setSelectedIndex(Integer.parseInt(a5_button.getText().split("\t")[2]) - 1);
        dayComboBox.setSelectedIndex(Integer.parseInt(a5_button.getText().split("\t")[4]) - 1);
        if (Integer.parseInt(a5_button.getText().split("\t")[6]) == 2016) {
            yearComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[6]) == 2017) {
            yearComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[6]) == 2018) {
            yearComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[6]) == 2019) {
            yearComboBox.setSelectedIndex(3);
        } else {
            yearComboBox.setSelectedIndex(4);
        }
        hourComboBox.setSelectedIndex(Integer.parseInt(a5_button.getText().split("\t")[8]) - 1);
        if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 00) {
            minuteComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 05) {
            minuteComboBox.setSelectedIndex(1);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 10) {
            minuteComboBox.setSelectedIndex(2);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 15) {
            minuteComboBox.setSelectedIndex(3);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 20) {
            minuteComboBox.setSelectedIndex(4);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 25) {
            minuteComboBox.setSelectedIndex(5);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 30) {
            minuteComboBox.setSelectedIndex(6);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 35) {
            minuteComboBox.setSelectedIndex(7);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 40) {
            minuteComboBox.setSelectedIndex(8);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 45) {
            minuteComboBox.setSelectedIndex(9);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 50) {
            minuteComboBox.setSelectedIndex(10);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[10]) == 55) {
            minuteComboBox.setSelectedIndex(11);
        } else {
            minuteComboBox.setSelectedIndex(12);
        }

        if (Integer.parseInt(a5_button.getText().split("\t")[12]) == 1) {
            priorityComboBox.setSelectedIndex(0);
        } else if (Integer.parseInt(a5_button.getText().split("\t")[12]) == 2) {
            priorityComboBox.setSelectedIndex(1);
        } else {
            priorityComboBox.setSelectedIndex(2);
        }

        refreshList();
    }//GEN-LAST:event_a5_buttonActionPerformed

    private void searchTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextBoxActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        backgroundProcess.removeTask(nameTextBox.getText());
        deleteButton.setVisible(false);
        refreshList();
    }//GEN-LAST:event_deleteButtonActionPerformed

    static String filepath;

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new GUI().setVisible(true);
                try {
                    backgroundProcess.loadList();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                    backgroundProcess.removeOnLoad();
            }
        });
    }


    public void hideDeleteButton() {
        deleteButton.setVisible(false);
    }

;
}
