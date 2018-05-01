package com.telerikacademy.exceptions.source;

public abstract class NoSuchSourceException extends RuntimeException{

    public final static String INVALID_SOURCE = "Source must be: ";

    public NoSuchSourceException(String unit) {
            super(String.format("%s %s", INVALID_SOURCE, unit));
        }
}
