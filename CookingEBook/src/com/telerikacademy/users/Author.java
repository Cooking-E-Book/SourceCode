package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.interfaces.Security;

public class Author extends Visitor implements Security {

    private String password;
    private String name;
    private String email;
    private final UserType userType = UserType.AUTHOR;

    public Author(String username, String password, String name, String email) {

        super(username);
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
