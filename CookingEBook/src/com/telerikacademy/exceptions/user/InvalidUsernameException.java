package com.telerikacademy.exceptions.user;


public class InvalidUsernameException extends RuntimeException {
    public static final String FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME =
            "The given name contains symbols that are not allowed to be used in usernames.";

    public InvalidUsernameException() {
        super(FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME);
    }

    public InvalidUsernameException(String message) {
        super(message);
    }
}