package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;

import com.telerikacademy.exceptions.NoSuchSolidMeasurementException;

public class SolidIngredient extends Ingredient {

    private Unit unit;
    public SolidIngredient(String name, Double quantity, Integer kcal, Unit unit) {
        super( name, quantity, kcal, unit );
        this.setUnit( unit );
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    protected void setUnit(Unit unit) {
        if (!(unit.equals(Unit.GRAM) || unit.equals(Unit.KILOGRAM) || unit.equals(Unit.COUNT))) {
            throw new NoSuchSolidMeasurementException();
        }
        this.unit = unit;
    }

}
