/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rethabile.auth;

/**
 *
 * @author RethabileVelelo
 */
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    
     private final LoginService service;

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame(LoginService service) {
        this.service = service;
        initComponents();
    }
       private void initComponents() {
        setTitle("Login - RethaAuth");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 220);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        JLabel title = new JLabel("Login");
        title.setFont(title.getFont().deriveFont(18f));
        gbc.gridx = 0; gbc.gridy = y; gbc.gridwidth = 2;
        panel.add(title, gbc);
        gbc.gridwidth = 1; y++;

        gbc.gridx = 0; gbc.gridy = y; panel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1; usernameField = new JTextField(15); panel.add(usernameField, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; panel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; passwordField = new JPasswordField(15); panel.add(passwordField, gbc); y++;

        gbc.gridx = 0; gbc.gridy = y; gbc.gridwidth = 2;
        loginButton = new JButton("Login");
        panel.add(loginButton, gbc);
        gbc.gridwidth = 1;

        add(panel);

        loginButton.addActionListener(e -> doLogin());
    }

    private void doLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        String status = service.returnLoginStatus(username, password);
        JOptionPane.showMessageDialog(this, status);

        if (status.startsWith("Welcome ")) {
            // additionally show short confirmation message as you requested
            JOptionPane.showMessageDialog(this, "Login Successful!");
        }
    }
    
}
