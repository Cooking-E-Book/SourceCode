package com.telerikacademy.exceptions;

public abstract class NoSuchMeasurementException extends RuntimeException{

    public final static String INVALID_UNIT = "Unit must be: ";

    public NoSuchMeasurementException(String unit) {
            super(String.format("%s %s", INVALID_UNIT, unit));
        }
    public NoSuchMeasurementException() {
        super();
    }
}
