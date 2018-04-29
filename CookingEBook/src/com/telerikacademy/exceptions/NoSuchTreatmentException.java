package com.telerikacademy.exceptions;

public class NoSuchTreatmentException extends RuntimeException{

    public static final String INVALID_TREATMENT = "Treatment must be: CUTTING, EXTRACTING, BLENDING, MIXING, MARINATING";

    public NoSuchTreatmentException() { }

    public NoSuchTreatmentException(String treatment) {
            super(String.format(INVALID_TREATMENT));
        }

}
