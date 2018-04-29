package com.telerikacademy.app;

import com.telerikacademy.components.Step;
import com.telerikacademy.enumerations.DishCategory;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Queue;

public class HeatTreatedDish extends Dish{

    public enum HeatTreatType {
        BOILING,
        FRYING,
        BAKING,
        STEAMED,
        GRILL,
        OPENFLAME,
        MICROWAVED
    }

    private Double temperature;
    private HeatTreatType heatTreatType;
    private Queue<Step> steps;

    public HeatTreatedDish(DishCategory category, Recipe recipe, Timestamp time, Double temperature, HeatTreatType type) {
        super( category, recipe, time );
        this.temperature = temperature;
        this.heatTreatType = type;
        this.steps = new LinkedList<>(  );
    }

    @Override
    public void addStep(Step step) {

    }

}
