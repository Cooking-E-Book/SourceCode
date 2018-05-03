package com.telerikacademy.components.liquid;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.source.NoSuchAnimalSourceException;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;

public class PlantLiquidIngredient extends LiquidIngredient {

    private PlantSource plantSource;

    public PlantLiquidIngredient(String name, Double quantity, Integer kcal, Unit unit, PlantSource plantSource) {
        super( name, quantity, kcal, unit );
        this.setSource( plantSource );
    }

    @Override
    public String getSource() {
        return this.plantSource.toString();
    }

    private void setSource(PlantSource plantSource) {
        if (!(plantSource.equals(PlantSource.FRUIT) ||
                plantSource.equals(PlantSource.GRAIN) ||
                plantSource.equals(PlantSource.LEAF_VEGETABLE) ||
                plantSource.equals(PlantSource.ROOT_VEGETABLE))) {
            throw new NoSuchPlantSourceException();
        }

        this.plantSource = plantSource;
    }

}
