package com.telerikacademy.app;

import com.telerikacademy.components.Step;
import com.telerikacademy.users.User;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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
    private String title;
    private User author;
    private Map<Double, Component> recipe = new HashMap<>();
    private String description;
    private Image image;

}
