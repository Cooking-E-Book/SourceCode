package com.telerikacademy.components.solid;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;

public class PlantSolidIngredient extends SolidIngredient {

    private PlantSource plantSource;
    public PlantSolidIngredient(String name, Double quantity, Integer kcal, Unit unit, PlantSource plantSource) {
        super( name, quantity, kcal, unit );
        this.setSource(plantSource);
    }
    
    @Override
    public String getSource() {
        return this.plantSource.toString();
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format( "%s%n", this.getSource() ));
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
