package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchMeasurementException;

public class SolidIngredient extends Ingredient {

    private Unit unit;
    public SolidIngredient(String name, Double quantity, Integer kcal, Unit unit) {
        super( name, quantity, kcal );
        this.setUnit( unit );
    }

    @Override
    protected void setUnit(Unit unit) {
        if (unit != Unit.GRAM || unit != Unit.KILOGRAM || unit != Unit.COUNT) {
            throw new NoSuchMeasurementException(unit.toString());
        }
        this.unit = unit;
    }
}
