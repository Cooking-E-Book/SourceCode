package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.exceptions.user.InvalidUsernameException;
import com.telerikacademy.interfaces.Security;

public class Visitor extends User implements Security {

    private final UserType userType = UserType.VISITOR;

    public Visitor() {

    }

    public UserType getUserType() {
        return userType;
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

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new InvalidUsernameException("Visitor cannot have password");
    }

    @Override
    public void editUser(String username, String name, String email) {
        throw new InvalidUsernameException("Visitor cannot be edited");
    }
}
