package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchMeasurementException;

public class BulkIngredient extends Ingredient{
    private Unit unit;

    public BulkIngredient(String name, Unit unit, Double quantity, Integer kcal) {
        super( name, quantity, kcal );
        this.setUnit( unit );
    }

    @Override
    protected void setUnit(Unit unit) {
        if (unit != Unit.TABLESPOON || unit != Unit.TEASPOON || unit != Unit.TEACUP || unit != Unit.PINCH) {
            throw new NoSuchMeasurementException(unit.toString());
        }
        this.unit = unit;
    }
}
