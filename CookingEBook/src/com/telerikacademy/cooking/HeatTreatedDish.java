package com.telerikacademy.cooking;

import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchTreatmentException;
import com.telerikacademy.exceptions.measurement.NoSuchBulkMeasurementException;

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

    private double temperature;
    private HeatTreatType heatTreatType;

    public HeatTreatedDish(DishCategory category, Recipe recipe, double temperature, HeatTreatType heatTreatType) {
        super(category, recipe);
        super.getTime();
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

    private void setType(HeatTreatType heatTreatType) {
        if (!(heatTreatType.equals( HeatTreatType.BAKING)
                || heatTreatType.equals(HeatTreatType.BOILING)
                || heatTreatType.equals(HeatTreatType.FRYING)
                || heatTreatType.equals(HeatTreatType.OPENFLAME)
                || heatTreatType.equals(HeatTreatType.MICROWAVED)
                || heatTreatType.equals(HeatTreatType.GRILL)
                || heatTreatType.equals(HeatTreatType.STEAMED))) {
            throw new NoSuchTreatmentException( heatTreatType.toString() );
        }

        this.heatTreatType = heatTreatType;
    }

}
