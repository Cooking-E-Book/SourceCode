package com.telerikacademy.components.liquid;

import com.telerikacademy.components.Ingredient;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.measurement.NoSuchLiquidMeasurementException;

public abstract class LiquidIngredient  extends Ingredient {
    private Unit unit;

    public LiquidIngredient(String name, Double quantity, Integer kcal, Unit unit) {
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
        if (!(unit.equals(Unit.MILLILITER) || unit.equals(Unit.LITER) || unit.equals(Unit.TEACUP))) {
            throw new NoSuchLiquidMeasurementException();
        }
        this.unit = unit;
    }

}
