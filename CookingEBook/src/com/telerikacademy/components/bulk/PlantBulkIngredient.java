package com.telerikacademy.components.bulk;

import com.telerikacademy.components.solid.SolidIngredient;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.source.NoSuchAnimalSourceException;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;

public class PlantBulkIngredient extends BulkIngredient {

    private PlantSource plantSource;

    public PlantBulkIngredient(String name, Double quantity, Integer kcal, Unit unit, PlantSource plantSource) {
        super( name, quantity, kcal, unit );
        this.setSource( plantSource );
    }

    private void setSource(PlantSource plantSource) {
        if (!(plantSource.equals(PlantSource.GRAIN) || plantSource.equals(PlantSource.FRUIT))) {
            throw new NoSuchPlantSourceException("Grain");
        }
        this.plantSource = plantSource;
    }

    @Override
    public String getSource() {
        return this.plantSource.toString();
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format( "%s%n", this.getSource() ));
    }

}
