package com.telerikacademy.exceptions.source;

public class NoSuchMineralSourceException extends NoSuchSourceException {

    public static final String INVALID_MINERAL_SOURCE = "SALТ, SODA or WATER";
    public static final String INVALID_BULK_MINERAL_SOURCE = "SALТ or SODA";
    public static final String WATER_SOURCE = "WATER";

    public NoSuchMineralSourceException() {
        super(INVALID_MINERAL_SOURCE);
    }
    public NoSuchMineralSourceException(String message) { super(INVALID_BULK_MINERAL_SOURCE);}
    public NoSuchMineralSourceException(String source, String water) { super(WATER_SOURCE); }
}
