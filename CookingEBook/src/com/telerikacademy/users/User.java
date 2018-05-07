package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.interfaces.Security;

public abstract class User implements Security {

    String username;

    public String password;
    public String name;
    public String email;

    public User() {

    }

    public User(String username, String password, String name, String email) {

        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword(String token) {
        if (token.equals("security")) {
            return password;
        } else {
            System.out.println("Invalid token");
            return null;
        }
    }



}
