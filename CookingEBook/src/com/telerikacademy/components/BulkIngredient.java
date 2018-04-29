package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchBulkMeasurementException;

public class BulkIngredient extends Ingredient{
    private Unit unit;

    public BulkIngredient(String name, Double quantity, Integer kcal, Unit unit) {
        super( name, quantity, kcal );
        this.setUnit( unit );
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    public void setUnit(Unit unit) {
        if (!(unit.equals(Unit.TABLESPOON) || unit.equals(Unit.TEASPOON) || unit.equals(Unit.TEACUP) || unit.equals(Unit.PINCH))) {
            throw new NoSuchBulkMeasurementException();
        }
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("Ingredient -> %s%nQuantity -> %s %s%nKcal -> %s%n", this.getName(), this.getQuantity(), this.getUnit(), this.getkCal());
    }
}
