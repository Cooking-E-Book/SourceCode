package com.telerikacademy.interfaces;

import com.telerikacademy.users.User;

public interface Security {

    void register(String username, String password, String name, String email);

    void logIn(String username, String password);

    void logOut();

    void changePassword(String oldPassword, String newPassword);

    void editUser();

}
