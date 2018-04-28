package com.telerikacademy.app;

import com.telerikacademy.components.Step;
import com.telerikacademy.enumerations.DishCategory;

import java.sql.Timestamp;
import java.util.List;
import java.util.Queue;

public abstract class Dish {

    private DishCategory category;
    private Recipe recipe;
    private Timestamp time;
    private Queue<Step> steps;
}
