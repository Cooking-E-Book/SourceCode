package com.telerikacademy.exceptions;

public class NoSuchBulkMeasurementException extends NoSuchMeasurementException {

    public static final String INVALID_BULK_UNIT = "TEASPOON, TABLESPOON, TЕАCUP or PINCH";

    public NoSuchBulkMeasurementException() {
        super(INVALID_BULK_UNIT);
    }
}
