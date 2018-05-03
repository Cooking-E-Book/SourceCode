package com.telerikacademy.exceptions.source;

public class NoSuchPlantSourceException extends NoSuchSourceException {

    public static final String INVALID_PLANT_SOURCE = "GRAIN, ROOT_VEGETABLE, LEAF_VEGETABLE or FRUIT";
    public static final String INVALID_BULK_PLANT_SOURCE = "GRAIN";

    public NoSuchPlantSourceException() {
        super(INVALID_PLANT_SOURCE);
    }
    public NoSuchPlantSourceException(String message) {
        super(INVALID_BULK_PLANT_SOURCE);
    }

}
