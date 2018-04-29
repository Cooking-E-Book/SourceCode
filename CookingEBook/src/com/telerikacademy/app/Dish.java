package com.telerikacademy.app;

import com.telerikacademy.components.Step;
import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.users.User;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Dish {

    private DishCategory category;
    private Recipe recipe;
    private Timestamp time;
    private Queue<Step> steps;
    private List<User> users;
    private Double rating;

    public Dish(DishCategory category, Recipe recipe, Timestamp time) {
        this.category = category;
        this.recipe = recipe;
        this.time = time;
        this.steps = new LinkedList<>(  );
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

    public Queue<Step> getSteps() {
        return steps;
    }

    protected abstract void addStep(Step step);
}
