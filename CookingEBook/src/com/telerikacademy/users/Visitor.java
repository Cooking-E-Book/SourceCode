package com.telerikacademy.users;

import com.telerikacademy.interfaces.Loggable;
import com.telerikacademy.Globals;

public class Visitor extends User implements Loggable {

    @Override
    public void logIn(User user) {
        Globals.currentUser = user;
    }

    @Override
    public void logOut() {

    }
}
