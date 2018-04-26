package com.telerikacademy.messages;

import com.telerikacademy.interfaces.Likable;

import java.sql.Timestamp;

public abstract class Message implements Likable {
    
    private String author;
    private Timestamp timestamp;
    public int likes;
    
    public Message(String author, Timestamp timestamp) {
        this.author = author;
        timestamp = new Timestamp(System.currentTimeMillis());
        likes = 0;
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
    @Override
    public String toString() {
        return String.format("[%s] %s", timestamp, author);
    }
    
    public abstract void postMessage();
    
    public abstract void like(String user);
}
