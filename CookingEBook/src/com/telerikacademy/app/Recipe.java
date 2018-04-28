package com.telerikacademy.app;

import com.telerikacademy.users.User;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private String title;
    private User author;
    private Map<Double, Component> recipe = new HashMap<>();
    private String description;
    private Double rating;

}
