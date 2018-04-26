package com.telerikacademy.messages;

import com.telerikacademy.interfaces.Likable;

import java.sql.Timestamp;

public abstract class Message implements Likable {
    
    private String author;
    private Timestamp timestamp;
    public int likes;
    public int dislikes;
    
    public Message(String author, Timestamp timestamp) {
        this.author = author;
        timestamp = new Timestamp(System.currentTimeMillis());
        likes = 0;
        dislikes = 0;
    }
    
    public String getAuthor() {
        return author;
    }
    
    
    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public int getDislikes() {return dislikes; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s", timestamp, author);
    }
    
    public abstract void postMessage();
    
    public abstract void like(String user);
    
    public abstract void dislike(String user);
}
