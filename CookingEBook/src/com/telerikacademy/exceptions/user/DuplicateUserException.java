package com.telerikacademy.exceptions.user;

public class DuplicateUserException extends RuntimeException {

    public static final String DUPLICATE_USER = "The %s already exists.";

    public DuplicateUserException() { }

    public DuplicateUserException(String username) {
        super(String.format(DUPLICATE_USER, username));
    }
}
