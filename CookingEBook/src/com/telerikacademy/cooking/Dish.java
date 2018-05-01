package com.telerikacademy.cooking;

import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.users.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class Dish {

    private DishCategory category;
    private Recipe recipe;
    private Timestamp time;
    private List<User> users;// some users who set the rating after testing
    private Double rating;

    public Dish(DishCategory category, Recipe recipe, Timestamp time) {
        this.category = category;
        this.recipe = recipe;
        this.time = time;
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

}
