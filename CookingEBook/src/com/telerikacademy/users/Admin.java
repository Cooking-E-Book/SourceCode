package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;

public class Admin extends Author {

    public Admin(String username, String password, String name, String email) {
        super(username, password, name, email); // Vladi: Pavka sorry, ama sveteshe v cherveno i go korigirah :)
                                                // Thanx :)
    }

    @Override
    public UserType getUserType() {
        return UserType.ADMIN;
    }

}
