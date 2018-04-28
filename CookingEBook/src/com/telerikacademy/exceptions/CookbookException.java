package com.telerikacademy.exceptions;

public abstract class CookbookException extends Exception {
    // Parameterless Constructor
    public CookbookException() {}

    // Constructor that accepts a message
    public CookbookException(String message)
    {
        super(message);
    }
}
