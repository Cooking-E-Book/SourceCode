package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;

public class Visitor extends User {

    private String username;
    private final UserType userType = UserType.VISITOR;


    Visitor() {
        this.username = "Visitor";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
