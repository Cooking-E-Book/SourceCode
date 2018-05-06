package com.telerikacademy.components.solid;

import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.source.NoSuchAnimalSourceException;

public class AnimalSolidIngredient extends SolidIngredient {

    private AnimalSource animalSource;

    public AnimalSolidIngredient(String name, Double quantity, Integer kcal, Unit unit, AnimalSource animalSource) {
        super( name, quantity, kcal, unit );
        this.setSource(animalSource);
    }

    @Override
    public String getSource() {
        return this.animalSource.toString();
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format( "%s%n", this.getSource() ));
    }
    
    private void setSource(AnimalSource plantSource) {
        if (!(plantSource.equals(AnimalSource.AMPHIBIANS) ||
                plantSource.equals(AnimalSource.BIRDS) ||
                plantSource.equals(AnimalSource.MAMMALS) ||
                plantSource.equals(AnimalSource.REPTILES))) {
            throw new NoSuchAnimalSourceException();
        }
        this.animalSource = animalSource;
    }
}
