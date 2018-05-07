package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.interfaces.Security;

public class Subscriber extends User implements Security {

    public Subscriber (String username, String password, String name, String email) {

        super(username, password, name, email);

    }

}
