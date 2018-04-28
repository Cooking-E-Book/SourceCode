package com.telerikacademy.components;

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
}
