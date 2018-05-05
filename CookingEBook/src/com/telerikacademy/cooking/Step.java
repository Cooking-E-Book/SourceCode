package com.telerikacademy.cooking;

import com.telerikacademy.Global;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Step {
    private int id;
    private String description;
    private double time;
    private List<Utensil> utensils;

    public Step(String description, double time) {
        this.setId();
        this.description = description;
        this.time = time;
        this.utensils = new ArrayList<>(  );

    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = Global.STEP_ID++;
    }

    public String getDescription() {
        return description;
    }

    public double getTime() {
        return time;
    }

    public List<Utensil> getUtensils() {
        return utensils;
    }

    @Override
    public String toString() {
        return String.format("%s. %s minutes, %s%n%s", this.getId(), this.getTime(), this.getUtensils(), getDescription());
    }
}
