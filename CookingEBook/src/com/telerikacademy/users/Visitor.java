package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;

public class Visitor extends User {

    private String username;
    private final UserType userType = UserType.VISITOR;


    public Visitor() {
        this.username = "Visitor";
    }

    public String getUsername() {
        return username;
    }

    public UserType getUserType() {
        return userType;
    }
}
