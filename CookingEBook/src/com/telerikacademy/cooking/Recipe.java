package com.telerikacademy.cooking;

import com.telerikacademy.cooking.Step;
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
    private Integer id;
    private String title;
    private User author;
    private Map<Double, Component> recipe = new HashMap<>();
    private String description;
    private Image image;
    private Queue<Step> steps;
    private Timestamp recipeAdded;


    protected  void addStep(Step step){}


}
