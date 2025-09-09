/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rethabile.auth;

/**
 *
 * @author RC_Student_lab
 */
public class User {
        private String firstName;
    private String surname;
    private String phone;
    private String username;
    private String password;

    public User(String firstName, String surname, String phone, String username, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getPhone() { return phone; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

}