package com.telerikacademy.exceptions;

public class NoSuchMeasurementException extends RuntimeException{

    public static final String INVALID_UNIT = "Unit must be: TEASPOON, TABLESPOON, COUNT, GRAM, KILOGRAM, LITER, MILLILITER or PINCH";

    public NoSuchMeasurementException() { }

    public NoSuchMeasurementException(String unit) {
            super(String.format(INVALID_UNIT));
        }

}
