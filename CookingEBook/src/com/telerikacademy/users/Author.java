package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.interfaces.Security;

public class Author extends Subscriber implements Security {

    public Author (String username, String password, String name, String email) {

        super(username, password, name, email);

    }

    public String getPassword(String token) {
        if (token.equals("security")) {
            return this.password;
        } else {
            System.out.println("Invalid token");
            return null;
        }
    }

}
