package com.telerikacademy.exceptions;

public class NoSuchSolidMeasurementException extends NoSuchMeasurementException {

    public static final String INVALID_SOLID_UNIT = "GRAM, KILOGRAM or COUNT";

    public NoSuchSolidMeasurementException() {
        super(INVALID_SOLID_UNIT);
    }
}
