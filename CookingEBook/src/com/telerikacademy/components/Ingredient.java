package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.interfaces.Component;
import com.telerikacademy.interfaces.Sourceable;

public abstract class Ingredient implements Component, Sourceable {
    private static int ingredientCounter = 1;
    private String name;
    private Unit unit;
    private Double quantity;
    private Integer kcal;

    public Ingredient(String name, Double quantity, Integer kcal, Unit unit) {
        this.name = name;
        this.quantity = quantity;
        this.kcal = kcal;
        this.unit = unit;
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

    public Unit getUnit(){
        return unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    protected abstract void setUnit(Unit unit);

    public abstract String getSource();

    @Override
    public String toString() {
        return String.format("%s. %s%nQuantity -> %s %s%nKcal -> %s%nSource -> ", ingredientCounter++, this.getName(), this.getQuantity(), this.getUnit(), this.getkCal());
    }

}
