package com.telerikacademy.exceptions.measurement;

public class NegativeNumberUnitConversion extends RuntimeException {
	public static final String NEGATIVE_QUANTITIES = "Input quantity must be a positive number!";
	
	public NegativeNumberUnitConversion(double inputQuantity) {
		System.out.printf("Input quantity must be a positive number (not %.2f)", inputQuantity);
	}
}
