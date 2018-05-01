package com.telerikacademy.exceptions.source;

public class NoSuchAnimalSourceException extends NoSuchSourceException {

    public static final String INVALID_ANIMAL_SOURCE = "MAMMALS, BIRDS, REPTILES, AMPHIBIANS or FISH";
    public static final String INVALID_LIQUID_ANIMAL_SOURCE = "MAMMALS";


    public NoSuchAnimalSourceException() {
        super(INVALID_ANIMAL_SOURCE);
    }
    public NoSuchAnimalSourceException(String message) {
        super(INVALID_LIQUID_ANIMAL_SOURCE);
    }

}
