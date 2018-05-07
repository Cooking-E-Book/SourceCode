package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.exceptions.user.InvalidUsernameException;
import com.telerikacademy.interfaces.Security;

public class Visitor extends User implements Security {

    public Visitor() {

    }

    @Override
    public String getUsername() {
        return "Visitor";
    }

    @Override
    public void setUsername(String username) {
        this.username = "Visitor";
    }

    @Override
    public String getEmail() {
        throw new InvalidUsernameException("Visitor cannot have email");
    }

    @Override
    public String getName() {
        throw new InvalidUsernameException("Visitor cannot have email");
    }

    @Override
    public void setName(String name) {
        throw new InvalidUsernameException("Visitor cannot have name");
    }

    @Override
    public void setEmail(String email) {
        throw new InvalidUsernameException("Visitor cannot have email");
    }


    @Override
    public String getPassword(String token) {
        throw new InvalidUsernameException("Visitor cannot have password");
    }
}
