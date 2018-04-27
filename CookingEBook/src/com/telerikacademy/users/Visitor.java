package com.telerikacademy.users;

import com.telerikacademy.interfaces.Loggable;
import com.telerikacademy.Globals;

public class Visitor extends User {

    private String username;

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
