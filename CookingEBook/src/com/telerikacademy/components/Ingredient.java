package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchMeasurementException;

public abstract class Ingredient implements Component{
    private String name;
    private Unit unit;
    private Double quantity;
    private Integer kcal;

    public Ingredient(String name, Unit unit, Double quantity, Integer kcal) {
        this.name = name;
        this.setUnit(unit);
        this.quantity = quantity;
        this.kcal = kcal;
    }

    public Integer getkCal() {
        return kcal;
    }

    public void setkCal(Integer kcal) {
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    protected void setUnit(Unit unit) {
        for (Unit u: Unit.values())
        {
            if (unit != u) {
                throw new NoSuchMeasurementException(unit.toString());
            }
        }
        this.unit = unit;
//        switch (unit)
//        {
//            case COUNT:
//            case PINCH:
//            case TABLESPOON:
//            case TEASPOON:
//            case LITER:
//            case MILLILITER:
//            case GRAM:
//            case KILOGRAM:
//
//            default: throw new NoSuchMeasurementException(  );
//        }
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
