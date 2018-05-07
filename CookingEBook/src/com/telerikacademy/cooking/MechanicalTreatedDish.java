package com.telerikacademy.cooking;

import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.exceptions.NoSuchTreatmentException;

import java.sql.Timestamp;

public class MechanicalTreatedDish extends Dish {

    public enum MechanicalTreatType {
        CUTTING,
        EXTRACTING,
        BLENDING,
        MIXING,
        MARINATING
    }

    private MechanicalTreatType type;

    public MechanicalTreatedDish(DishCategory category, Recipe recipe, MechanicalTreatType type) {
        super( category, recipe );
        super.getTime();
        this.setType( type );
    }

    public MechanicalTreatType getType() {
        return type;
    }

    public void setType(MechanicalTreatType type) {
        if (!(type.equals( MechanicalTreatType.BLENDING ) ||
                type.equals( MechanicalTreatType.CUTTING ) ||
                type.equals( MechanicalTreatType.EXTRACTING ) ||
                type.equals( MechanicalTreatType.MIXING ) ||
                type.equals( MechanicalTreatType.MARINATING ))) {
            throw new NoSuchTreatmentException( type.toString() );
        }
        this.type = type;
    }

}
