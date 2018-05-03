package com.telerikacademy.cooking;

import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.enumerations.MechanicalTreatType;
import com.telerikacademy.exceptions.NoSuchTreatmentException;

import java.sql.Timestamp;

public class MechanicalTreatedDish extends Dish {

    private MechanicalTreatType type;

    public MechanicalTreatedDish(DishCategory category, Recipe recipe, Timestamp time, MechanicalTreatType type) {
        super( category, recipe, time );
        this.setType(type);
    }

    public MechanicalTreatType getType() {
        return type;
    }

    public void setType(MechanicalTreatType type) {
        for (MechanicalTreatType u: MechanicalTreatType.values())
        {
            if (!type.equals(u)) {
                throw new NoSuchTreatmentException( type.toString() );
            }
        }
        this.type = type;
    }

}
