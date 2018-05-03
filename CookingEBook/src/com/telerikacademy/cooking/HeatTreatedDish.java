package com.telerikacademy.cooking;

import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.exceptions.NoSuchTreatmentException;

import java.sql.Timestamp;

public class HeatTreatedDish extends Dish {

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

    public HeatTreatedDish(DishCategory category, Recipe recipe, Timestamp time, Double temperature, HeatTreatType heatTreatType) {
        super( category, recipe, time );
        this.temperature = temperature;
        this.setType(heatTreatType);
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public HeatTreatType getHeatTreatType() {
        return heatTreatType;
    }

    public void setType(HeatTreatType heatTreatType) {
        for (HeatTreatType u: HeatTreatType.values())
        {
            if (!heatTreatType.equals(u)) {
                throw new NoSuchTreatmentException( heatTreatType.toString() );
            }
        }

        this.heatTreatType = heatTreatType;
    }

}
