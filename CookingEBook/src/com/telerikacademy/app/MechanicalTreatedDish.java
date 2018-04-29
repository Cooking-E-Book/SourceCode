package com.telerikacademy.app;

import com.telerikacademy.components.Step;
import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.enumerations.MechanicalTreatType;

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

    @Override
    protected void addStep(Step step) {

    }

}
