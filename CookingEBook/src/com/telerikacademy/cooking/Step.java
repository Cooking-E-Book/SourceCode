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

    private String printUtensils(){
        StringBuffer sb = new StringBuffer( );
        int length = this.getUtensils().size();
        for (int i = 0; i < length - 1; i++) {
            sb.append( this.getUtensils().get( i ).getName() );
            sb.append( ", " );
        }
        sb.append( this.getUtensils().get( length - 1 ).getName() ).toString();

       return sb.toString();

    }


    @Override
    public String toString() {
        return String.format("Step %s. Time -> %s minutes, Utensils: %s%n%s", this.getId(), this.getTime(), this.printUtensils(), getDescription());
    }

    public void add(Utensil utensil) {
        this.utensils.add( utensil );
    }
}
