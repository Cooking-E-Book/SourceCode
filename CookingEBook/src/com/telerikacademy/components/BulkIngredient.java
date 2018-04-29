package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;

public class BulkIngredient extends Ingredient{
    public BulkIngredient(String name, Unit unit, Double quantity, Integer kcal) {
        super( name, unit, quantity, kcal );
    }
}
