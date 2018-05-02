package com.telerikacademy.calculations;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.incompatibility.IncompatibleUnitTypes;
import com.telerikacademy.exceptions.measurement.NegativeNumberUnitConversion;
import com.telerikacademy.interfaces.Convertible;

public class UnitConverter implements Convertible {
	private Unit inputUnit;
	private Unit outputUnit;
	private double inputQuantity;
	private double outputQuantity;
	
	public UnitConverter(Unit inputUnit, double inputQuantity, Unit outputUnit) {
		this.inputUnit = inputUnit;
		this.inputQuantity = inputQuantity;
		this.outputUnit = outputUnit;
		this.outputQuantity = convert();
	}
	
	/*public Unit getOutputUnit() {
		return outputUnit;
	}*/
	
	public double convert() {
		
		if (inputQuantity < 0) {
			throw new NegativeNumberUnitConversion(inputQuantity);
		}
		
		switch(inputUnit) {
			case TEACUP:
				switch (outputUnit) {
					case TEACUP:
						outputQuantity = 1 * inputQuantity;
						break;
					case TABLESPOON:
						outputQuantity = 16 * inputQuantity;
						break;
					case TEASPOON:
						outputQuantity = 48 * inputQuantity;
						break;
					case MILLILITER:
						outputQuantity = 237 * inputQuantity;
						break;
					case LITER:
						outputQuantity = 0.237 * inputQuantity;
						break;
					default:
						outputQuantity = -999;
					break;
				}
			break;
			case TABLESPOON:
				switch (outputUnit) {
					case TEACUP:
						outputQuantity = 1 / 16 * inputQuantity;
						break;
					case TABLESPOON:
						outputQuantity = 1 * inputQuantity;
						break;
					case TEASPOON:
						outputQuantity = 3 * inputQuantity;
						break;
					case MILLILITER:
						outputQuantity = 15 * inputQuantity;
						break;
					case LITER:
						outputQuantity = 0.015 * inputQuantity;
						break;
					default:
						outputQuantity = -999;
						break;
				}
			break;
			case TEASPOON:
				switch (outputUnit) {
					case TEACUP:
						outputQuantity = 1 / 48 * inputQuantity;
						break;
					case TABLESPOON:
						outputQuantity = 1 / 3 * inputQuantity;
						break;
					case TEASPOON:
						outputQuantity = 1 * inputQuantity;
						break;
					case MILLILITER:
						outputQuantity = 5 * inputQuantity;
						break;
					case LITER:
						outputQuantity = 0.005 * inputQuantity;
						break;
					default:
						outputQuantity = -999;
						break;
				}
			break;
			case MILLILITER:
				switch (outputUnit) {
					case TEACUP:
						outputQuantity = 1 / 80 * inputQuantity;
						break;
					case TABLESPOON:
						outputQuantity = 1 / 15 * inputQuantity;
						break;
					case TEASPOON:
						outputQuantity = 1 / 5 * inputQuantity;
						break;
					case MILLILITER:
						outputQuantity = 1 * inputQuantity;
						break;
					case LITER:
						outputQuantity = 0.001 * inputQuantity;
						break;
					default:
						outputQuantity = -999;
						break;
				}
			break;
			case GRAM:
				switch (outputUnit) {
					case GRAM:
						outputQuantity = 1 * inputQuantity;
						break;
					case KILOGRAM:
						outputQuantity = 0.001 * inputQuantity;
						break;
					default:
						outputQuantity = -999;
					break;
				}
			break;
			default:
				outputQuantity = -999;
			break;
		}
		
		if (outputQuantity == -999) {
			throw new IncompatibleUnitTypes(inputUnit, outputUnit);
		}
		
		return outputQuantity;
	}
}
