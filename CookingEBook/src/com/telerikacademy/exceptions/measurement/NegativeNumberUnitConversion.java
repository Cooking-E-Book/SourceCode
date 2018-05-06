package com.telerikacademy.exceptions.measurement;

public class NegativeNumberUnitConversion extends RuntimeException {
	
	public NegativeNumberUnitConversion(double inputQuantity) {
		System.out.printf("Input quantity must be a positive number (not %.2f)", inputQuantity);
	}
}
