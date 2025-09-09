/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rethabile.auth;

/**
 *
 * @author RC_Student_lab
 */
public class UserService {
        private User registeredUser;

    public String registerUser(User user) {
        if (!isValidPhone(user.getPhone())) {
            return "Invalid phone number";
        }
        if (!isValidPassword(user.getPassword())) {
            return "Invalid password";
        }
        registeredUser = user;
        return "User registered successfully!";
    }

    public boolean login(String username, String password) {
        if (registeredUser == null) return false;
        return registeredUser.getUsername().equals(username) &&
               registeredUser.getPassword().equals(password);
    }

    private boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^\\+27\\d{9}$");
    }

    private boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!]).{8,}$");
    }
}
