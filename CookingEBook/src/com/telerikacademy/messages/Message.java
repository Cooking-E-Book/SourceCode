package com.telerikacademy.messages;

import com.telerikacademy.Global;
import com.telerikacademy.users.User;
import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Message {
    
    private User author = Global.currentUser;
    private int recipeId;
    //private Timestamp timestamp;
    private String timestamp;
    
    public Message(int recipeId) {
        this.recipeId = recipeId;
        //timestamp = new Timestamp(System.currentTimeMillis());
        getTimestamp();
    }
    
    public User getAuthor() {
        return author;
    }
    
    public int getRecipeId() {
        return recipeId;
    }
    
    public String getTimestamp() {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String timestamp = format.format(curDate);
        return timestamp;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s", timestamp, author.getUsername());
    }
}
