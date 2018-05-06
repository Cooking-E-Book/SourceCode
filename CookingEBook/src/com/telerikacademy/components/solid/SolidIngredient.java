package com.telerikacademy.components.solid;

import com.telerikacademy.components.Ingredient;
import com.telerikacademy.enumerations.Unit;

import com.telerikacademy.exceptions.measurement.NoSuchSolidMeasurementException;

public abstract class SolidIngredient extends Ingredient {

    private Unit unit;
    public SolidIngredient(String name, Double quantity, Integer kcal, Unit unit) {
        super( name, quantity, kcal, unit );
        this.setUnit( unit );
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    public abstract String getSource();
    
     @Override
    protected void setUnit(Unit unit) {
        if (!(unit.equals(Unit.GRAM) || unit.equals(Unit.KILOGRAM) || unit.equals(Unit.COUNT))) {
            throw new NoSuchSolidMeasurementException();
        }
        this.unit = unit;
    }

}
