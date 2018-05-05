package com.telerikacademy.interfaces;

import com.telerikacademy.Global;
import com.telerikacademy.exceptions.user.DuplicateUserException;
import com.telerikacademy.exceptions.user.InvalidUsernameException;
import com.telerikacademy.users.Author;
import com.telerikacademy.users.Visitor;

import java.util.ArrayList;

public interface Security {

    ArrayList<Author> users = new ArrayList<>();

    static void register(String username, String password, String name, String email) {
        if (userExists(users, username)) {
            throw new DuplicateUserException(String.format("Username \"%s\" already exists.", username));
        } else {
            Author author = new Author(username, password, name, email);
            users.add(author);
            Global.currentUser = author;
        }
    }

    static void logIn(String username, String password) {
        if (username.equals("visitor")) {
            throw new InvalidUsernameException("Wrong Username.");
        } else {
            // Todo: change to lambda
            boolean validUsername = false;
            for (int i = 0; i < users.size(); i++) {
                Author user = users.get(i);
                if (user.getUsername().equals(username)) {
                    Global.currentUser = user;
                    validUsername = true;
                    if (user.getPassword("security").equals(password)) {
                        Global.currentUser = user;
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
    }

    static void logOut() {
        Global.currentUser = new Visitor("visitor");
    }

    void changePassword(String oldPassword, String newPassword);

    void editUser(String username, String name, String email);

    static boolean userExists(ArrayList<Author> users, String otherItem) {
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(otherItem));
    }

//    void adminEditOtherUser(String username, String name, String email);
//
//    void adminDeleteOtherUser(User user);

}
