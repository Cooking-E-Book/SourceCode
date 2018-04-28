package com.telerikacademy.interfaces;

import com.telerikacademy.users.User;

public interface Security {

    void register();

    void logIn(User user);

    void logOut();

    void setPassword(String password);

    void changePassword(String oldPassword, String newPassword);

}
