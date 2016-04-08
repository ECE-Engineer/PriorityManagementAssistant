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

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog ("Input Text Here");
        //System.out.println(s);
        JOptionPane.showMessageDialog(null, s);
    }
    
}
