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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Kyle Zeller Andrew B
 */
public class GUI extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton a1_button;
    public javax.swing.JButton a2_button;
    public javax.swing.JButton a3_button;
    public javax.swing.JButton a4_button;
    public javax.swing.JButton a5_button;
    private javax.swing.JCheckBox allowPopupCheckBox;
    private javax.swing.JButton browseButton;
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
    public static LocalDateTime timePoint = LocalDateTime.now();    // The current date and time (YYYY-MM-DDTHH:MM:SS.642)
    public static Background backgroundProcess = new Background();
    public static Assignment assignment;
    String name;
    int month, day, year, hour, minute, priority;
    boolean popup = false;
    private Component frame;
    static String filepath;

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
        browseButton = new javax.swing.JButton();
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
        allowPopupCheckBox = new javax.swing.JCheckBox();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(searchButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(browseButton)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(browseButton)
                .addContainerGap())
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
        minuteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "59" }));

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

        allowPopupCheckBox.setText("Allow Popups");
        allowPopupCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allowPopupCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(nameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(211, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(allowPopupCheckBox)
                .addGap(290, 290, 290))
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
                .addGap(18, 18, 18)
                .addComponent(allowPopupCheckBox)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //CREATE AN ASSIGNMENT BUTTON CONTROL
    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {
        boolean nameAlreadyExits = false, noNameError = false, badNameError = false, yearFlagError = false, monthFlagError = false, dayFlagError = false, hourFlagError = false, minuteFlagError = false;

        deleteButton.setVisible(false);

        //declaring the variables
        name = nameTextBox.getText();
        if(monthComboBox.getSelectedItem().toString().startsWith("0"))   //this will prevent a parsing error from string to int
           month = Integer.parseInt((monthComboBox.getSelectedItem().toString()).replaceFirst("0", ""));
        else
            month = Integer.parseInt(monthComboBox.getSelectedItem().toString());
        year = Integer.parseInt(yearComboBox.getSelectedItem().toString());
        if(dayComboBox.getSelectedItem().toString().startsWith("0"))   //this will prevent a parsing error from string to int
           day = Integer.parseInt((dayComboBox.getSelectedItem().toString()).replaceFirst("0", ""));
        else
            day = Integer.parseInt(dayComboBox.getSelectedItem().toString());
        if(hourComboBox.getSelectedItem().toString().startsWith("0"))   //this will prevent a parsing error from string to int
           hour = Integer.parseInt((hourComboBox.getSelectedItem().toString()).replaceFirst("0", ""));
        else
            hour = Integer.parseInt(hourComboBox.getSelectedItem().toString());
        if(minuteComboBox.getSelectedItem().toString().startsWith("0"))   //this will prevent a parsing error from string to int
           minute = Integer.parseInt((minuteComboBox.getSelectedItem().toString()).replaceFirst("0", ""));
        else
            minute = Integer.parseInt(minuteComboBox.getSelectedItem().toString());
        priority = Integer.parseInt(priorityComboBox.getSelectedItem().toString());



        //checking all the data for validity
        if(backgroundProcess.isAssignmentPresent(name)) {
            //Checks to see if the name already exists
            JOptionPane.showMessageDialog(frame, name + " already exists, please try a new name.", "Repeated Name Error", JOptionPane.ERROR_MESSAGE);
            nameAlreadyExits = true;
        }
        if(name == null || name.equalsIgnoreCase("")) {
            //Checks to see if no name was given
            JOptionPane.showMessageDialog(frame, name + " no name was given.", "No Name Error", JOptionPane.ERROR_MESSAGE);
            noNameError = true;
        }
        if(name.contains("---")) {
            //Checks to see if the name contains --- which is used to read information from the background file
            JOptionPane.showMessageDialog(frame, name + " name contains ---.", "Bad Name Error", JOptionPane.ERROR_MESSAGE);
            badNameError = true;
        }
        if(year < timePoint.getYear()) {
            //Checks to see if the year is invalid
            JOptionPane.showMessageDialog(frame, year + " is not a valid Year, please enter a number greater than " + (timePoint.getYear()-1) + ".", "Bad Year Error", JOptionPane.ERROR_MESSAGE);
            yearFlagError = true;
        }
        if(year == timePoint.getYear() && month < timePoint.getMonthValue()) {
            //Checks to see if the month is invalid
            JOptionPane.showMessageDialog(frame, month + " is not a valid Month, please enter a number greater than " + (timePoint.getMonthValue()-1) + ".", "Bad Month Error", JOptionPane.ERROR_MESSAGE);
            monthFlagError = true;
        }
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ){
            if(day < 1 || day > 31) {
                //Checks to see if the day is invalid
                JOptionPane.showMessageDialog(frame, day + " is not a valid Day, please enter a number between 1 and 31.", "Bad Day Error", JOptionPane.ERROR_MESSAGE);
                dayFlagError = true;
            }
            if(month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth()) {
                //Checks to see if the day is invalid
                JOptionPane.showMessageDialog(frame, day + " is not a valid Day, please enter a number greater than " + (timePoint.getDayOfMonth()-1), "Bad Day Error", JOptionPane.ERROR_MESSAGE);
                dayFlagError = true;
            }
        }else if(month == 4 || month == 6 || month == 9 || month == 11){
            if(day < 1 || day > 30) {
                //Checks to see if the day is invalid
                JOptionPane.showMessageDialog(frame, day + " is not a valid Day, please enter a number between 1 and 30.", "Bad Day Error", JOptionPane.ERROR_MESSAGE);
                dayFlagError = true;
            }
            if(month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth()) {
                //Checks to see if the day is invalid
                JOptionPane.showMessageDialog(frame, day + " is not a valid Day, please enter a number greater than " + (timePoint.getDayOfMonth()-1), "Bad Day Error", JOptionPane.ERROR_MESSAGE);
                dayFlagError = true;
            }             
        }else if(month == 2){
            if(day < 1 || day > 28) {
                //Checks to see if the day is invalid
                JOptionPane.showMessageDialog(frame, day + " is not a valid Day, please enter a number between 1 and 28.", "Bad Day Error", JOptionPane.ERROR_MESSAGE);
                dayFlagError = true;
            }
            if(month == timePoint.getMonthValue() && day < timePoint.getDayOfMonth()) {
                //Checks to see if the day is invalid
                JOptionPane.showMessageDialog(frame, day + " is not a valid Day, please enter a number greater than " + (timePoint.getDayOfMonth()-1), "Bad Day Error", JOptionPane.ERROR_MESSAGE);
                dayFlagError = true;
            }           
        }
        if(day == timePoint.getDayOfMonth() && hour < timePoint.getHour()) {
            //Checks to see if the hour is invalid
            JOptionPane.showMessageDialog(frame, hour + " is not a valid Hour, please enter a number greater than " + (timePoint.getHour()-1) + ".", "Bad Hour Error", JOptionPane.ERROR_MESSAGE);
            hourFlagError = true;
        }
        if(hour == timePoint.getHour() && minute < timePoint.getMinute()) {
            //Checks to see if the minute is invalid
            JOptionPane.showMessageDialog(frame, minute + " is not a valid Minute, please enter a number greater than " + (timePoint.getMinute()-1) + ".", "Bad Minute Error", JOptionPane.ERROR_MESSAGE);
            minuteFlagError = true;
        }
        if(!nameAlreadyExits && !noNameError && !badNameError && !yearFlagError && !monthFlagError && !dayFlagError && !hourFlagError && !minuteFlagError){
            //set all the values
            assignment = new Assignment(name, month, day, year, hour, minute, priority, popup);
            backgroundProcess.buildList(assignment);
            monthComboBox.setSelectedIndex(0);
            dayComboBox.setSelectedIndex(0);
            yearComboBox.setSelectedIndex(0);
            hourComboBox.setSelectedIndex(0);
            minuteComboBox.setSelectedIndex(0);
            priorityComboBox.setSelectedIndex(0);
            nameTextBox.setText("");
            if(allowPopupCheckBox.isSelected()){
                assignment.setPopup(true);
            }
        }
        editList();
    }
    
    
    
    
    
    //DELETE BUTTON PRESSED
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {

        backgroundProcess.removeTask(nameTextBox.getText());

        for (int i = 0; i < backgroundProcess.list.size(); i++) {
            System.out.println(backgroundProcess.list.get(i).getName());
        }

        for (int i = 0; i < backgroundProcess.list.size(); i++) {
            System.out.println("Textbox = " + nameTextBox.getText());
            if (backgroundProcess.list.get(i).getName().equals(nameTextBox.getText())) {
                backgroundProcess.list.remove(i);
                System.out.println("removed");
                break;
            }
            System.out.println("nothing removed");
        }
        //System.out.println(backgroundProcess.isAssignmentPresent(nameTextBox.getText()));
        deleteButtonText();
        deleteButton.setVisible(false);
        editList();
    }
    
    
    
    
    
    //BROWSE BUTTON PRESSED
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            backgroundProcess.writeFile(backgroundProcess.getFilePath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", backgroundProcess.getFilePath());
        try {
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    //SEARCH BUTTON PRESSED
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        deleteButton.setVisible(true);
        for (int i = 0; i < backgroundProcess.list.size(); i++) {
            if (backgroundProcess.list.get(i).getName().equals(searchTextBox.getText())) {
                nameTextBox.setText(backgroundProcess.list.get(i).getName());
                monthComboBox.setSelectedIndex(backgroundProcess.list.get(i).getMonth() - 1);
                dayComboBox.setSelectedIndex(backgroundProcess.list.get(i).getDay() - 1);
                switch (backgroundProcess.list.get(i).getYear()) {
                    case 2016:
                        yearComboBox.setSelectedIndex(0);
                        break;
                    case 2017:
                        yearComboBox.setSelectedIndex(1);
                        break;
                    case 2018:
                        yearComboBox.setSelectedIndex(2);
                        break;
                    case 2019:
                        yearComboBox.setSelectedIndex(3);
                        break;
                    default:
                        yearComboBox.setSelectedIndex(4);
                        break;
                }
                hourComboBox.setSelectedIndex(backgroundProcess.list.get(i).getHour() - 1);
                switch (backgroundProcess.list.get(i).getMinute()) {
                    case 01:
                        minuteComboBox.setSelectedIndex(0);
                        break;
                    case 05:
                        minuteComboBox.setSelectedIndex(1);
                        break;
                    case 10:
                        minuteComboBox.setSelectedIndex(2);
                        break;
                    case 15:
                        minuteComboBox.setSelectedIndex(3);
                        break;
                    case 20:
                        minuteComboBox.setSelectedIndex(4);
                        break;
                    case 25:
                        minuteComboBox.setSelectedIndex(5);
                        break;
                    case 30:
                        minuteComboBox.setSelectedIndex(6);
                        break;
                    case 35:
                        minuteComboBox.setSelectedIndex(7);
                        break;
                    case 40:
                        minuteComboBox.setSelectedIndex(8);
                        break;
                    case 45:
                        minuteComboBox.setSelectedIndex(9);
                        break;
                    case 50:
                        minuteComboBox.setSelectedIndex(10);
                        break;
                    case 55:
                        minuteComboBox.setSelectedIndex(11);
                        break;
                    default:
                        minuteComboBox.setSelectedIndex(12);
                        break;
                }

                switch (backgroundProcess.list.get(i).getPriority()) {
                    case 1:
                        priorityComboBox.setSelectedIndex(0);
                        break;
                    case 2:
                        priorityComboBox.setSelectedIndex(1);
                        break;
                    default:
                        priorityComboBox.setSelectedIndex(2);
                        break;
                }
            }
        }
        deleteButton.setVisible(false);
    }
    
    
    
    
    
    
    private void searchTextBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void allowPopupCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void hideDeleteButton() {
        deleteButton.setVisible(false);
    }
    
    
    
    
    
    
    
    
    
    

    public void editList() {
        if(!backgroundProcess.isNull()){
            backgroundProcess.sort();
        }
        deleteButtonText();
        setButtonOne();
        setButtonTwo();
        setButtonThree();
        setButtonFour();
        setButtonFive();
    }

    public void deleteButtonText() {
        a1_button.setVisible(false);
        a2_button.setVisible(false);
        a3_button.setVisible(false);
        a4_button.setVisible(false);
        a5_button.setVisible(false);
    }

    public void setButtonOne() {
        a1_button.setVisible(true);
        assignment = backgroundProcess.getAssignment(0);
        name = assignment.getName();
        month = assignment.getMonth();
        day = assignment.getDay();
        year = assignment.getYear();
        hour = assignment.getHour();
        minute = assignment.getMinute();
        priority = assignment.getPriority();
        popup = assignment.getPopup();

        a1_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
    }

    public void setButtonTwo() {
        a2_button.setVisible(true);
        assignment = backgroundProcess.getAssignment(1);
        name = assignment.getName();
        month = assignment.getMonth();
        day = assignment.getDay();
        year = assignment.getYear();
        hour = assignment.getHour();
        minute = assignment.getMinute();
        priority = assignment.getPriority();
        popup = assignment.getPopup();

        a2_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
    }

    public void setButtonThree() {
        a3_button.setVisible(true);
        assignment = backgroundProcess.getAssignment(2);
        name = assignment.getName();
        month = assignment.getMonth();
        day = assignment.getDay();
        year = assignment.getYear();
        hour = assignment.getHour();
        minute = assignment.getMinute();
        priority = assignment.getPriority();
        popup = assignment.getPopup();

        a3_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
    }

    public void setButtonFour() {
        a4_button.setVisible(true);
        assignment = backgroundProcess.getAssignment(3);
        name = assignment.getName();
        month = assignment.getMonth();
        day = assignment.getDay();
        year = assignment.getYear();
        hour = assignment.getHour();
        minute = assignment.getMinute();
        priority = assignment.getPriority();
        popup = assignment.getPopup();

        a4_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
    }

    public void setButtonFive() {
        a5_button.setVisible(true);
        assignment = backgroundProcess.getAssignment(4);
        name = assignment.getName();
        month = assignment.getMonth();
        day = assignment.getDay();
        year = assignment.getYear();
        hour = assignment.getHour();
        minute = assignment.getMinute();
        priority = assignment.getPriority();
        popup = assignment.getPopup();

        a5_button.setText(name + "\t Due: \t" + month + "\t/\t" + day + "\t/\t" + year + "\t \t" + hour + "\t:\t" + minute + "\t Priority: \t" + priority + "\t");
    }

    
    
    
    
    
    //run the gui program
    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //load the assignments into the list
        //remove the overdue assignments
        backgroundProcess.loadList();
        backgroundProcess.removeOnLoad();

        //make the gui visible
        //make the assignments in the list visible
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
            gui.editList();
        });
    }
    
    
    
    
    
    //IF THE USER PRESSED ON THE 1ST TASK
    private void a1_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        deleteButton.setVisible(true);
        String name = a1_button.getText().split("\t")[0];
        deleteButton.setVisible(true);
        for (int i = 0; i < backgroundProcess.list.size(); i++) {
            if (backgroundProcess.list.get(i).getName().equals(name)) {
                nameTextBox.setText(backgroundProcess.list.get(i).getName());
                monthComboBox.setSelectedIndex(backgroundProcess.list.get(i).getMonth() - 1);
                dayComboBox.setSelectedIndex(backgroundProcess.list.get(i).getDay() - 1);
                switch (backgroundProcess.list.get(i).getYear()) {
                    case 2016:
                        yearComboBox.setSelectedIndex(0);
                        break;
                    case 2017:
                        yearComboBox.setSelectedIndex(1);
                        break;
                    case 2018:
                        yearComboBox.setSelectedIndex(2);
                        break;
                    case 2019:
                        yearComboBox.setSelectedIndex(3);
                        break;
                    default:
                        yearComboBox.setSelectedIndex(4);
                        break;
                }
                hourComboBox.setSelectedIndex(backgroundProcess.list.get(i).getHour() - 1);
                switch (backgroundProcess.list.get(i).getMinute()) {
                    case 01:
                        minuteComboBox.setSelectedIndex(0);
                        break;
                    case 05:
                        minuteComboBox.setSelectedIndex(1);
                        break;
                    case 10:
                        minuteComboBox.setSelectedIndex(2);
                        break;
                    case 15:
                        minuteComboBox.setSelectedIndex(3);
                        break;
                    case 20:
                        minuteComboBox.setSelectedIndex(4);
                        break;
                    case 25:
                        minuteComboBox.setSelectedIndex(5);
                        break;
                    case 30:
                        minuteComboBox.setSelectedIndex(6);
                        break;
                    case 35:
                        minuteComboBox.setSelectedIndex(7);
                        break;
                    case 40:
                        minuteComboBox.setSelectedIndex(8);
                        break;
                    case 45:
                        minuteComboBox.setSelectedIndex(9);
                        break;
                    case 50:
                        minuteComboBox.setSelectedIndex(10);
                        break;
                    case 55:
                        minuteComboBox.setSelectedIndex(11);
                        break;
                    default:
                        minuteComboBox.setSelectedIndex(12);
                        break;
                }

                switch (backgroundProcess.list.get(i).getPriority()) {
                    case 1:
                        priorityComboBox.setSelectedIndex(0);
                        break;
                    case 2:
                        priorityComboBox.setSelectedIndex(1);
                        break;
                    default:
                        priorityComboBox.setSelectedIndex(2);
                        break;
                }
            }
        }
        backgroundProcess.removeTask(a1_button.getText().split("\t")[0]);
        deleteButton.setVisible(false);

        editList();
    }
    
    
    
    
    
    
    //IF THE USER PRESSED ON THE 2ND TASK
    private void a2_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        deleteButton.setVisible(true);
        String name = a2_button.getText().split("\t")[0];
        deleteButton.setVisible(true);
        for (int i = 0; i < backgroundProcess.list.size(); i++) {
            if (backgroundProcess.list.get(i).getName().equals(name)) {
                nameTextBox.setText(backgroundProcess.list.get(i).getName());
                monthComboBox.setSelectedIndex(backgroundProcess.list.get(i).getMonth() - 1);
                dayComboBox.setSelectedIndex(backgroundProcess.list.get(i).getDay() - 1);
                switch (backgroundProcess.list.get(i).getYear()) {
                    case 2016:
                        yearComboBox.setSelectedIndex(0);
                        break;
                    case 2017:
                        yearComboBox.setSelectedIndex(1);
                        break;
                    case 2018:
                        yearComboBox.setSelectedIndex(2);
                        break;
                    case 2019:
                        yearComboBox.setSelectedIndex(3);
                        break;
                    default:
                        yearComboBox.setSelectedIndex(4);
                        break;
                }
                hourComboBox.setSelectedIndex(backgroundProcess.list.get(i).getHour() - 1);
                switch (backgroundProcess.list.get(i).getMinute()) {
                    case 01:
                        minuteComboBox.setSelectedIndex(0);
                        break;
                    case 05:
                        minuteComboBox.setSelectedIndex(1);
                        break;
                    case 10:
                        minuteComboBox.setSelectedIndex(2);
                        break;
                    case 15:
                        minuteComboBox.setSelectedIndex(3);
                        break;
                    case 20:
                        minuteComboBox.setSelectedIndex(4);
                        break;
                    case 25:
                        minuteComboBox.setSelectedIndex(5);
                        break;
                    case 30:
                        minuteComboBox.setSelectedIndex(6);
                        break;
                    case 35:
                        minuteComboBox.setSelectedIndex(7);
                        break;
                    case 40:
                        minuteComboBox.setSelectedIndex(8);
                        break;
                    case 45:
                        minuteComboBox.setSelectedIndex(9);
                        break;
                    case 50:
                        minuteComboBox.setSelectedIndex(10);
                        break;
                    case 55:
                        minuteComboBox.setSelectedIndex(11);
                        break;
                    default:
                        minuteComboBox.setSelectedIndex(12);
                        break;
                }

                switch (backgroundProcess.list.get(i).getPriority()) {
                    case 1:
                        priorityComboBox.setSelectedIndex(0);
                        break;
                    case 2:
                        priorityComboBox.setSelectedIndex(1);
                        break;
                    default:
                        priorityComboBox.setSelectedIndex(2);
                        break;
                }
            }
        }
        backgroundProcess.removeTask(a2_button.getText().split("\t")[0]);
        deleteButton.setVisible(false);

        editList();
    }
    
    
    
    
    
    //IF THE USER PRESSED ON THE 3RD TASK
    private void a3_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        deleteButton.setVisible(true);
        String name = a3_button.getText().split("\t")[0];
        deleteButton.setVisible(true);
        for (int i = 0; i < backgroundProcess.list.size(); i++) {
            if (backgroundProcess.list.get(i).getName().equals(name)) {
                nameTextBox.setText(backgroundProcess.list.get(i).getName());
                monthComboBox.setSelectedIndex(backgroundProcess.list.get(i).getMonth() - 1);
                dayComboBox.setSelectedIndex(backgroundProcess.list.get(i).getDay() - 1);
                switch (backgroundProcess.list.get(i).getYear()) {
                    case 2016:
                        yearComboBox.setSelectedIndex(0);
                        break;
                    case 2017:
                        yearComboBox.setSelectedIndex(1);
                        break;
                    case 2018:
                        yearComboBox.setSelectedIndex(2);
                        break;
                    case 2019:
                        yearComboBox.setSelectedIndex(3);
                        break;
                    default:
                        yearComboBox.setSelectedIndex(4);
                        break;
                }
                hourComboBox.setSelectedIndex(backgroundProcess.list.get(i).getHour() - 1);
                switch (backgroundProcess.list.get(i).getMinute()) {
                    case 01:
                        minuteComboBox.setSelectedIndex(0);
                        break;
                    case 05:
                        minuteComboBox.setSelectedIndex(1);
                        break;
                    case 10:
                        minuteComboBox.setSelectedIndex(2);
                        break;
                    case 15:
                        minuteComboBox.setSelectedIndex(3);
                        break;
                    case 20:
                        minuteComboBox.setSelectedIndex(4);
                        break;
                    case 25:
                        minuteComboBox.setSelectedIndex(5);
                        break;
                    case 30:
                        minuteComboBox.setSelectedIndex(6);
                        break;
                    case 35:
                        minuteComboBox.setSelectedIndex(7);
                        break;
                    case 40:
                        minuteComboBox.setSelectedIndex(8);
                        break;
                    case 45:
                        minuteComboBox.setSelectedIndex(9);
                        break;
                    case 50:
                        minuteComboBox.setSelectedIndex(10);
                        break;
                    case 55:
                        minuteComboBox.setSelectedIndex(11);
                        break;
                    default:
                        minuteComboBox.setSelectedIndex(12);
                        break;
                }

                switch (backgroundProcess.list.get(i).getPriority()) {
                    case 1:
                        priorityComboBox.setSelectedIndex(0);
                        break;
                    case 2:
                        priorityComboBox.setSelectedIndex(1);
                        break;
                    default:
                        priorityComboBox.setSelectedIndex(2);
                        break;
                }
            }
        }
        backgroundProcess.removeTask(a3_button.getText().split("\t")[0]);
        deleteButton.setVisible(false);

        editList();
    }
    
    
    
    
    
    //IF THE USER PRESSED ON THE 4TH TASK
    private void a4_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        deleteButton.setVisible(true);
        String name = a4_button.getText().split("\t")[0];
        deleteButton.setVisible(true);
        for (int i = 0; i < backgroundProcess.list.size(); i++) {
            if (backgroundProcess.list.get(i).getName().equals(name)) {
                nameTextBox.setText(backgroundProcess.list.get(i).getName());
                monthComboBox.setSelectedIndex(backgroundProcess.list.get(i).getMonth() - 1);
                dayComboBox.setSelectedIndex(backgroundProcess.list.get(i).getDay() - 1);
                switch (backgroundProcess.list.get(i).getYear()) {
                    case 2016:
                        yearComboBox.setSelectedIndex(0);
                        break;
                    case 2017:
                        yearComboBox.setSelectedIndex(1);
                        break;
                    case 2018:
                        yearComboBox.setSelectedIndex(2);
                        break;
                    case 2019:
                        yearComboBox.setSelectedIndex(3);
                        break;
                    default:
                        yearComboBox.setSelectedIndex(4);
                        break;
                }
                hourComboBox.setSelectedIndex(backgroundProcess.list.get(i).getHour() - 1);
                switch (backgroundProcess.list.get(i).getMinute()) {
                    case 01:
                        minuteComboBox.setSelectedIndex(0);
                        break;
                    case 05:
                        minuteComboBox.setSelectedIndex(1);
                        break;
                    case 10:
                        minuteComboBox.setSelectedIndex(2);
                        break;
                    case 15:
                        minuteComboBox.setSelectedIndex(3);
                        break;
                    case 20:
                        minuteComboBox.setSelectedIndex(4);
                        break;
                    case 25:
                        minuteComboBox.setSelectedIndex(5);
                        break;
                    case 30:
                        minuteComboBox.setSelectedIndex(6);
                        break;
                    case 35:
                        minuteComboBox.setSelectedIndex(7);
                        break;
                    case 40:
                        minuteComboBox.setSelectedIndex(8);
                        break;
                    case 45:
                        minuteComboBox.setSelectedIndex(9);
                        break;
                    case 50:
                        minuteComboBox.setSelectedIndex(10);
                        break;
                    case 55:
                        minuteComboBox.setSelectedIndex(11);
                        break;
                    default:
                        minuteComboBox.setSelectedIndex(12);
                        break;
                }

                switch (backgroundProcess.list.get(i).getPriority()) {
                    case 1:
                        priorityComboBox.setSelectedIndex(0);
                        break;
                    case 2:
                        priorityComboBox.setSelectedIndex(1);
                        break;
                    default:
                        priorityComboBox.setSelectedIndex(2);
                        break;
                }
            }
        }
        backgroundProcess.removeTask(a4_button.getText().split("\t")[0]);
        deleteButton.setVisible(false);

        editList();
    }
    
    
    
    
    
    //IF THE USER PRESSED ON THE 5TH TASK
    private void a5_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        deleteButton.setVisible(true);
        String name = a5_button.getText().split("\t")[0];
        deleteButton.setVisible(true);
        for (int i = 0; i < backgroundProcess.list.size(); i++) {
            if (backgroundProcess.list.get(i).getName().equals(name)) {
                nameTextBox.setText(backgroundProcess.list.get(i).getName());
                monthComboBox.setSelectedIndex(backgroundProcess.list.get(i).getMonth() - 1);
                dayComboBox.setSelectedIndex(backgroundProcess.list.get(i).getDay() - 1);
                switch (backgroundProcess.list.get(i).getYear()) {
                    case 2016:
                        yearComboBox.setSelectedIndex(0);
                        break;
                    case 2017:
                        yearComboBox.setSelectedIndex(1);
                        break;
                    case 2018:
                        yearComboBox.setSelectedIndex(2);
                        break;
                    case 2019:
                        yearComboBox.setSelectedIndex(3);
                        break;
                    default:
                        yearComboBox.setSelectedIndex(4);
                        break;
                }
                hourComboBox.setSelectedIndex(backgroundProcess.list.get(i).getHour() - 1);
                switch (backgroundProcess.list.get(i).getMinute()) {
                    case 01:
                        minuteComboBox.setSelectedIndex(0);
                        break;
                    case 05:
                        minuteComboBox.setSelectedIndex(1);
                        break;
                    case 10:
                        minuteComboBox.setSelectedIndex(2);
                        break;
                    case 15:
                        minuteComboBox.setSelectedIndex(3);
                        break;
                    case 20:
                        minuteComboBox.setSelectedIndex(4);
                        break;
                    case 25:
                        minuteComboBox.setSelectedIndex(5);
                        break;
                    case 30:
                        minuteComboBox.setSelectedIndex(6);
                        break;
                    case 35:
                        minuteComboBox.setSelectedIndex(7);
                        break;
                    case 40:
                        minuteComboBox.setSelectedIndex(8);
                        break;
                    case 45:
                        minuteComboBox.setSelectedIndex(9);
                        break;
                    case 50:
                        minuteComboBox.setSelectedIndex(10);
                        break;
                    case 55:
                        minuteComboBox.setSelectedIndex(11);
                        break;
                    default:
                        minuteComboBox.setSelectedIndex(12);
                        break;
                }

                switch (backgroundProcess.list.get(i).getPriority()) {
                    case 1:
                        priorityComboBox.setSelectedIndex(0);
                        break;
                    case 2:
                        priorityComboBox.setSelectedIndex(1);
                        break;
                    default:
                        priorityComboBox.setSelectedIndex(2);
                        break;
                }
            }
        }
        backgroundProcess.removeTask(a5_button.getText().split("\t")[0]);
        deleteButton.setVisible(false);

        editList();
    }
}
