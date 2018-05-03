package com.telerikacademy.interfaces;

import com.telerikacademy.exceptions.user.DuplicateUserException;
import com.telerikacademy.users.Author;
import com.telerikacademy.users.User;
import com.telerikacademy.users.UserList;

import static com.telerikacademy.users.Author.userExists;

public interface Security {

    static void register(String username, String password, String name, String email) {
        if (userExists(UserList.users, username)) {
            throw new DuplicateUserException(String.format("Username \"%s\" already exists.", username));
        } else {
            Author author = new Author(username, password, name, email);
            UserList.users.add(author);
        }
    }

    void logIn(String username, String password);

    void logOut();

    void changePassword(String oldPassword, String newPassword);

    void editUser(String username, String name, String email);

//    void adminEditOtherUser(String username, String name, String email);
//
//    void adminDeleteOtherUser(User user);

}
