package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;

public class Visitor extends User {

    private final UserType userType = UserType.VISITOR;

    public Visitor(String username) {
       super(username);
    }

    public UserType getUserType() {
        return userType;
    }
}
