package com.telerikacademy.exceptions.source;

public class NoSuchMushroomSourceException extends NoSuchSourceException {

    public static final String INVALID_MUSHROOM_SOURCE = "WILD or CULTIVATED";

    public NoSuchMushroomSourceException() {
        super(INVALID_MUSHROOM_SOURCE);
    }
}
