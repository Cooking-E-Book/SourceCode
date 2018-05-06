package com.telerikacademy.messages;

import com.telerikacademy.Global;
import com.telerikacademy.users.User;
import java.sql.Timestamp;

public abstract class Message {
    
    private User author = Global.currentUser;
    private int recipeId;
    private Timestamp timestamp;
    
    public Message(int recipeId) {
        this.recipeId = recipeId;
        timestamp = new Timestamp(System.currentTimeMillis());
    }
    
    public User getAuthor() {
        return author;
    }
    
    public int getRecipeId() {
        return recipeId;
    }
    
    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s", timestamp, author.getUsername());
    }
}
