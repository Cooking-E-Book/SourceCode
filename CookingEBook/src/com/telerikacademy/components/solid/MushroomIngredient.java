package com.telerikacademy.components.solid;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.source.NoSuchAnimalSourceException;
import com.telerikacademy.exceptions.source.NoSuchMushroomSourceException;

public class MushroomIngredient extends SolidIngredient {

    private MushroomSource mushroomSource;

    public MushroomIngredient(String name, Double quantity, Integer kcal, Unit unit, MushroomSource mushroomSource) {
        super( name, quantity, kcal, unit );
        this.setSource( mushroomSource );
    }

    @Override
    public String getSource() {
        return this.mushroomSource.toString();
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format( "%s%n", this.getSource() ));
    }
    
    private void setSource(MushroomSource mushroomSource) {
        if (!(mushroomSource.equals(MushroomSource.CULTIVATED) ||
                mushroomSource.equals(MushroomSource.WILD))) {
            throw new NoSuchMushroomSourceException();
        }
        this.mushroomSource = mushroomSource;
    }

}
