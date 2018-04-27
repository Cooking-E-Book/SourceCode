package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;

public class Author extends Visitor {

    private String password;
    private String name;
    private String email;
    private final UserType userType = UserType.AUTHOR;

    Author() {

    }

    Author(String username, String password, String name, String email) {

        this.setUsername(username);
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword) {

        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
