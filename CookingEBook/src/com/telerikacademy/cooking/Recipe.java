package com.telerikacademy.cooking;

import com.telerikacademy.Globals;
import com.telerikacademy.exceptions.incompatibility.IncompatibleUnitTypes;
import com.telerikacademy.users.User;

import java.awt.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Recipe                                         string?
    ingredient List HashMap<Ingredient, quantity> ingedient
    Description
    User - creator
    List User - People who tried it
    Rating
    Date & time recipe added
    +List Category categories
    +Preparation time
    +Cooking Time
    +Ready time = preparation + cooking
    +Image images
 */
public class Recipe {
    private int id;
    private String title;
    private User author;
    private Map<Double, Component> recipe = new HashMap<>();
    private String description;
    private Image image;
    private Queue<Step> steps;
    private Timestamp recipeAdded;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public User getAuthor() {
        return author;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }
    
    public Map<Double, Component> getRecipe() {
        return recipe;
    }
    
    public void setRecipe(Map<Double, Component> recipe) {
        this.recipe = recipe;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Image getImage() {
        return image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }
    
    public Queue<Step> getSteps() {
        return steps;
    }
    
    public void setSteps(Queue<Step> steps) {
        this.steps = steps;
    }
    
    public Timestamp getRecipeAdded() {
        return recipeAdded;
    }
    
    public void setRecipeAdded(Timestamp recipeAdded) {
        this.recipeAdded = recipeAdded;
    }
    
    public Recipe(String title, User author, String description) {
         this.id = Globals.recipeId++;
        this.title = title;
        this.author = author;
        this.description = description;
        steps = new LinkedList<>();
        recipe = new HashMap<>();
    }
    
    
    protected  void addStep(Step step){}


}
