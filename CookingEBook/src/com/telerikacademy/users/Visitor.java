package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;

public class Visitor extends User {

    public String username;
    private final UserType userType = UserType.VISITOR;


    public Visitor(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }
}
