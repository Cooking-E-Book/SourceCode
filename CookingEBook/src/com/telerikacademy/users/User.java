package com.telerikacademy.users;

public abstract class User {

    String username;

    User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

}
