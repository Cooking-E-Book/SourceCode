package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchLiquidMeasurementException;
import com.telerikacademy.exceptions.NoSuchMeasurementException;

public class LiquidIngredient  extends Ingredient{
    private Unit unit;

    public LiquidIngredient(String name, Double quantity, Integer kcal, Unit unit) {
        super( name, quantity, kcal );
        this.setUnit( unit );
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    protected void setUnit(Unit unit) {
        if (unit != Unit.MILLILITER || unit != Unit.LITER || unit != Unit.TEACUP) {
            throw new NoSuchLiquidMeasurementException(unit.toString());
        }
        this.unit = unit;
    }
}
