package com.telerikacademy.users;

import com.telerikacademy.Globals;
import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.interfaces.Loggable;

public abstract class User implements Loggable {

    @Override
    public void logIn(User user) {
        Globals.currentUser = user;
    }

    @Override
    public void logOut() {
        Globals.currentUser = new Visitor();
    }

}
