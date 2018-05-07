package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.interfaces.Security;

public class Subscriber extends User implements Security {

    private final UserType userType = UserType.SUBSCRIBER;

    public Subscriber (String username, String password, String name, String email) {

        super(username, password, name, email);

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
