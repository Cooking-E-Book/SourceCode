package com.telerikacademy.exceptions.measurement;

public class NoSuchLiquidMeasurementException extends NoSuchMeasurementException {

    public static final String INVALID_LIQUID_UNIT = "LITER, MILLILITER or TEACUP";

    public NoSuchLiquidMeasurementException() {
        super(INVALID_LIQUID_UNIT);
    }

}
