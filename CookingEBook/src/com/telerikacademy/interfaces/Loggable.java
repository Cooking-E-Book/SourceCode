package com.telerikacademy.interfaces;

import com.telerikacademy.users.User;

public interface Loggable {

    void logIn(User user);

    void logOut();

}
