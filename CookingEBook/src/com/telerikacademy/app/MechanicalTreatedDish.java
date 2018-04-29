package com.telerikacademy.app;

import com.telerikacademy.components.Step;
import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.enumerations.MechanicalTreatType;
import com.telerikacademy.exceptions.NoSuchTreatmentException;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Queue;

public class MechanicalTreatedDish extends Dish {

    private MechanicalTreatType type;
    private Queue<Step> steps;

    public MechanicalTreatedDish(DishCategory category, Recipe recipe, Timestamp time, MechanicalTreatType type) {
        super( category, recipe, time );
        this.type = type;
        this.steps = new LinkedList<>();
    }

    public MechanicalTreatType getType() {
        return type;
    }

    public void setType(MechanicalTreatType type) {
        for (MechanicalTreatType u: MechanicalTreatType.values())
        {
            if (type != u) {
                throw new NoSuchTreatmentException( type.toString() );
            }
        }
        this.type = type;
    }

    @Override

    protected void addStep(Step step) {

    }

}
