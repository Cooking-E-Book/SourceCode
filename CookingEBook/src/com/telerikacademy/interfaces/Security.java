package com.telerikacademy.interfaces;

import com.telerikacademy.Global;
import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.exceptions.user.DuplicateUserException;
import com.telerikacademy.exceptions.user.InvalidUsernameException;
import com.telerikacademy.exceptions.user.UserAccessDeniedException;
import com.telerikacademy.users.*;

import java.util.ArrayList;

public interface Security {

    ArrayList<User> users = new ArrayList<>();

    static void createMainAdmin() {
        User mainAdmin = new Admin("admin", "adminPass", "Main Administrator", "admin@example.com");
        users.add(mainAdmin);
        Global.currentUser = mainAdmin;
        System.out.println("Couldn't create new Admin, since no main admin exists");
        System.out.println("Main admin created and logged in");
    }

    static void register(UserType userType, String username, String password, String name, String email) {
        if (userExists(users, username)) {
            throw new DuplicateUserException(String.format("Username \"%s\" already exists.", username));
        } else if(username.equals("visitor") || username.equals("admin")) {
            throw new InvalidUsernameException("Wrong Username.");
        } else {
            if (userType.equals(UserType.SUBSCRIBER)) {
                User user = new Subscriber(username, password, name, email);
                users.add(user);
                Global.currentUser = user;
            } else if (userType.equals(UserType.AUTHOR)) {
                User user = new Author(username, password, name, email);
                users.add(user);
                Global.currentUser = user;
            } else if (userType.equals(UserType.ADMIN)) {
                if (userExists(users, "admin")) {
                    if (Global.currentUser instanceof Admin) {
                        User user = new Admin(username, password, name, email);
                        users.add(user);
                        Global.currentUser = user;
                    } else {
                        throw new UserAccessDeniedException("Only Admin can create new admins");
                    }
                } else {
                    createMainAdmin();
                }
            }

        }
    }

    static void logIn(String username, String password) {
        if (username.equals("visitor")) {
            throw new InvalidUsernameException("Wrong Username.");
        } else {
            // Todo: change to lambda
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                if (user.getUsername().equals(username)) {
                    Global.currentUser = user;
                    if (user.getPassword("security").equals(password)) {
                        Global.currentUser = user;
                        System.out.println(user.getName() + " logged in");
                    } else {
                        throw new InvalidUsernameException("Wrong Password");
                    }
                    break;
                }
            }
        }
    }

    static void logOut() {
        Global.currentUser = new Visitor();
        System.out.println("Logged out, current user - Visitor");
    }

    static void changePassword(String oldPassword, String newPassword) {
        if (Global.currentUser instanceof Visitor) {
            throw new UserAccessDeniedException("Visitor does not have password");
        } else {
            if (oldPassword.equals(Global.currentUser.password)) {
                Global.currentUser.password = newPassword;
            }
        }
    }

    static void editUser(String username, String name, String email) {
        if (Global.currentUser instanceof Visitor) {
            throw new UserAccessDeniedException("Visitor cannot be edited");
        } else {
            Global.currentUser.username = username;
            Global.currentUser.name = name;
            Global.currentUser.email = email;
        }
    }

    static boolean userExists(ArrayList<User> users, String newUser) {
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(newUser));
    }

//    void adminDeleteOtherUser(User user);

}
