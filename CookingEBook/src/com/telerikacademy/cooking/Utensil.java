package com.telerikacademy.cooking;

import com.telerikacademy.Global;

public class Utensil {
    private String name;
    private String type;

    public Utensil(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s, %s%n", this.getName(), this.getType());
    }
}
