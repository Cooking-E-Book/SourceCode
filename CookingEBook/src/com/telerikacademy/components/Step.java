package com.telerikacademy.components;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Step {
    private String stepName;
    private String description;
    private Timestamp time;
    private List<Utensil> utensils;

    public Step(String stepName, String description, Timestamp time) {
        this.stepName = stepName;
        this.description = description;
        this.time = time;
        this.utensils = new ArrayList<>(  );

    }

    public String getStepName() {
        return stepName;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getTime() {
        return time;
    }

    public List<Utensil> getUtensils() {
        return utensils;
    }
}
