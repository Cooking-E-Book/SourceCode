package com.telerikacademy.users;

import com.telerikacademy.enumerations.UserType;

public class Admin extends Author {

//    private String password;
//    private String name;
//    private String email;
    private final UserType userType = UserType.ADMIN;

//    private Admin() {
//
//    }

    public Admin(String username, String password, String name, String email) {
        super(username, password, name, email); // Vladi: Pavka sorry, ama sveteshe v cherveno i go korigirah :)
    }



}
