/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rethabile.auth;

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.SwingUtilities;
public class Main {
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegisterFrame().setVisible(true);
        });
    }
}
