package com.telerikacademy.components.bulk;

import com.telerikacademy.components.Ingredient;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.measurement.NoSuchBulkMeasurementException;

public abstract class BulkIngredient extends Ingredient {
    private Unit unit;

    public BulkIngredient(String name, Double quantity, Integer kcal, Unit unit) {
        super( name, quantity, kcal, unit );
        this.setUnit( unit );
    }

    @Override
    public void setUnit(Unit unit) {
        if (!(unit.equals(Unit.TABLESPOON)
                || unit.equals(Unit.TEASPOON) || unit.equals(Unit.TEACUP)
                || unit.equals(Unit.PINCH) || unit.equals(Unit.GRAM))) {
            throw new NoSuchBulkMeasurementException();
        }
        this.unit = unit;
    }

    public abstract String getSource();

}
