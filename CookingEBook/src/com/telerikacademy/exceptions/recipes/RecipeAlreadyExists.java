package com.telerikacademy.exceptions.recipes;

public class RecipeAlreadyExists extends Throwable {
    public static final String INVALID_RECIPE_ID = "RECIPE WITH THIS ID ALREADY EXISTS";

    public RecipeAlreadyExists() {
        super(INVALID_RECIPE_ID);
    }
}
