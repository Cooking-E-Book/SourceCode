package com.telerikacademy.cooking;

import com.telerikacademy.Globals;
import com.telerikacademy.exceptions.incompatibility.IncompatibleUnitTypes;
import com.telerikacademy.messages.Comment;
import com.telerikacademy.users.User;

import java.awt.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

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
    private String description;
    private Image image;
    private Queue<Step> steps;
    private Map<Double, Component> recipe = new HashMap<>();
    private List<Comment> comments;
    private Timestamp recipeAdded;

    public Recipe(String title, User author, String description) {
        this.id++;
        this.title = title;
        this.author = author;
        this.description = description;
        steps = new LinkedList<>();
        recipe = new HashMap<>();
        comments = new ArrayList<>(  );
    }


    public int getId() {
        return id;
    }
    
    public void setId() {
        this.id++;
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
    
    public void addRecipe(Double amount, Component ingredient) {
            this.recipe.put( amount, ingredient );
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

    public Timestamp getRecipeAdded() {
        return recipeAdded;
    }
    
    public void setRecipeAdded(Timestamp recipeAdded) {
        this.recipeAdded = recipeAdded;
    }
    
    public   void addStep(Step step){
        this.steps.add( step );
    }


}
