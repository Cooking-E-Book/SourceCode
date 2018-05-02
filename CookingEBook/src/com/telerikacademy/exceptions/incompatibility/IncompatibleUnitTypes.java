package com.telerikacademy.exceptions.incompatibility;

import com.telerikacademy.enumerations.Unit;

public class IncompatibleUnitTypes extends RuntimeException {
		
		public static final String INCOMPATIBLE_UNITS = "Units must be of compatible (comparable) types.";
		
		public IncompatibleUnitTypes() {
			System.out.println(INCOMPATIBLE_UNITS);
		}
		
		public IncompatibleUnitTypes(Unit inputUnit, Unit outputUnit) {
			System.out.printf("%s is not compatible with %s; cannot be converted.", inputUnit, outputUnit);
		}
		
}
