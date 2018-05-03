package com.telerikacademy.calculations;

import com.telerikacademy.enumerations.TemperatureScale;
import com.telerikacademy.interfaces.Convertible;

public class TemperatureConverter implements Convertible {
	private TemperatureScale inputScale;
	private TemperatureScale outputScale;
	private double inputTemperature;
	private double outputTemperature;
	
	public TemperatureConverter(TemperatureScale inputScale, double inputTemperature, TemperatureScale outputScale) {
		this.inputScale = inputScale;
		this.inputTemperature = inputTemperature;
		this.outputScale = outputScale;
		this.outputTemperature = convert();
	}
	
	@Override
	public double convert() {
		
		double outputTemperature = 0;
		
		if (inputScale == outputScale) {
			outputTemperature = inputTemperature;
		}
		else if (inputScale == TemperatureScale.CELSIUS) {
			outputTemperature = (inputTemperature * 1.8) + 32;
		}
		else {
			outputTemperature = (inputTemperature - 32) / 1.8;
		}
		return outputTemperature;
	}
}
