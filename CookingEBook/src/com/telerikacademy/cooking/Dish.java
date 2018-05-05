package com.telerikacademy.cooking;

import com.telerikacademy.Global;
import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.interfaces.Component;
import com.telerikacademy.users.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Dish {

    private DishCategory category;
    private Recipe recipe;
    private Timestamp time;
    private List<User> users;// some users who set the rating after testing
    private Double rating;

    public Dish(DishCategory category, Recipe recipe) {
        this.category = category;
        this.recipe = recipe;
        this.time = new Timestamp(System.currentTimeMillis());
        this.users = new ArrayList<>(  );
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    private String printIngredients(){
        StringBuilder sb = new StringBuilder(  );
        Map<String, Component> recipe = this.recipe.getRecipe();
        for (Component component : recipe.values()) {
            sb.append( component );
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s, %s%n%s", this.getRecipe().getTitle(), this.getCategory(), this.printIngredients());
    }
}
