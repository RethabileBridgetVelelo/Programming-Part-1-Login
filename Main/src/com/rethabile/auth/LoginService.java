/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rethabile.auth;

/**
 *
 * @author RC_Student_lab
 */
public class LoginService {
        private User registeredUser; // store single user for this assignment

    // 1) Username: must contain underscore and be at least 5 characters
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() >= 5;
    }

    // 2) Password: at least 8 chars, 1 uppercase, 1 digit, 1 special char
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = false, hasDigit = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        return hasUpper && hasDigit && hasSpecial;
    }

    // 3) Phone: international style, + followed by digits (accepts typical +27... numbers)
    public boolean checkCellPhoneNumber(String phone) {
        return phone != null && phone.matches("^\\+\\d{9,12}$"); // + and 9-12 digits (covers +2783...)
    }

    // 4) Register user - returns explicit messages (used by GUI & tests)
    public String registerUser(User user) {
        if (!checkUserName(user.getUsername())) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is at least five characters in length.";
        }
        if (!checkPasswordComplexity(user.getPassword())) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(user.getPhone())) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.registeredUser = user;
        return "User registered successfully.";
    }

    // 5) loginUser boolean
    public boolean loginUser(String username, String password) {
        return registeredUser != null
                && registeredUser.getUsername().equals(username)
                && registeredUser.getPassword().equals(password);
    }

    // 6) return login status message
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + registeredUser.getFirstName() + " " + registeredUser.getSurname() + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // helper for tests / UI
    public User getRegisteredUser() { return registeredUser; }
}


