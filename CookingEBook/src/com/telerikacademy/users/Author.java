package com.telerikacademy.users;

import com.telerikacademy.Globals;
import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.exceptions.user.DuplicateUserException;
import com.telerikacademy.exceptions.user.InvalidUsernameException;
import com.telerikacademy.interfaces.Security;

import java.util.ArrayList;

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

    @Override
    public void logIn(String username, String password) {

        if (username.equals("visitor")) {
            throw new InvalidUsernameException("Wrong Username.");
        } else {
            // Todo: change to lambda
            boolean validUsername = false;
            for (int i = 0; i < UserList.users.size(); i++) {
                Author user = UserList.users.get(i);
                if (user.username.equals(username)) {
                    Globals.currentUser = user;
                    validUsername = true;
                    if (user.password.equals(password)) {
                        Globals.currentUser = user;
                    } else {
                        throw new InvalidUsernameException("Wrong Password");
                    }
                    break;
                }
            }
            if (!validUsername) {
                throw new InvalidUsernameException("Wrong Username");
            }
        }

//        Globals.currentUser = user;
    }

    @Override
    public void logOut() {
        Globals.currentUser = new Visitor("visitor");
    }


    public static boolean userExists(ArrayList<Author> users, String otherItem) {
        return users.stream()
                .anyMatch(user -> user.username.equals(otherItem));
    }

}
