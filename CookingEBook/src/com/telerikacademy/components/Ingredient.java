package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchMeasurementException;

public abstract class Ingredient implements Component{
    private String name;
    private Unit unit;
    private Double quantity;
    private Integer kcal;

    public Ingredient(String name, Double quantity, Integer kcal) {
        this.name = name;
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

    public abstract Unit getUnit();

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    protected abstract void setUnit(Unit unit);

}
