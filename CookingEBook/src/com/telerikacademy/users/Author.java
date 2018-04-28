package com.telerikacademy.users;

import com.telerikacademy.Globals;
import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.interfaces.Security;

public class Author extends Visitor implements Security {

    private String password;
    private String name;
    private String email;
    private final UserType userType = UserType.AUTHOR;

    public Author(String username, String password, String name, String email) {

        super(username);
        this.password = password;
        this.name = name;
        this.email = email;

    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
        }
    }

    @Override
    public void register() {

    }

    @Override
    public void logIn(String username, String password) {

        Globals.currentUser = user;
    }

    @Override
    public void logOut() {
        Globals.currentUser = new Visitor("visitor");
    }

}
