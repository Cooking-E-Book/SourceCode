package com.telerikacademy.components.liquid;

import com.telerikacademy.components.solid.SolidIngredient;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.source.NoSuchAnimalSourceException;

public class AnimalLiquidIngredient extends LiquidIngredient {

    private AnimalSource animalSource;

    public AnimalLiquidIngredient(String name, Double quantity, Integer kcal, Unit unit, AnimalSource animalSource) {
        super( name, quantity, kcal, unit );
        this.setSource(animalSource);
    }

    @Override
    public String getSource() {
        return this.animalSource.toString();
    }

    private void setSource(AnimalSource animalSource) {
        if (!animalSource.equals(AnimalSource.MAMMALS)) {
            throw new NoSuchAnimalSourceException("Mammals");
        }
        this.animalSource = animalSource;
    }

}
