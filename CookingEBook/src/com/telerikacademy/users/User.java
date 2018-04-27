package com.telerikacademy.users;

import com.telerikacademy.Globals;
import com.telerikacademy.interfaces.Loggable;

abstract class User implements Loggable {


    @Override
    public void logIn(User user) {
        Globals.currentUser = user;
    }

    @Override
    public void logOut() {

    }

}
