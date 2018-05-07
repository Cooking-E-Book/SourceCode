package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.interfaces.Security;

public class Author extends Subscriber implements Security {

    private final UserType userType = UserType.AUTHOR;

    public Author (String username, String password, String name, String email) {

        super(username, password, name, email);

    }

    public String getPassword(String token) {
        if (token.equals("security")) {
            return this.password;
        } else {
            System.out.println("Invalid token");
            return null;
        }
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
        }
    }

    @Override
    public void editUser(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

}
