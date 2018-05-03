package com.telerikacademy.messages;

import com.telerikacademy.interfaces.Deletable;
import com.telerikacademy.interfaces.Dislikable;
import com.telerikacademy.interfaces.Editable;
import com.telerikacademy.interfaces.Likable;

import java.sql.Time;
import java.sql.Timestamp;

public abstract class Message {
    
    private String author;
    private Timestamp timestamp;
    
    public Message(String author) {
        this.author = author;
        timestamp = new Timestamp(System.currentTimeMillis());
    }
    
    public String getAuthor() {
        return author;
    }
    
    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s", timestamp, author);
    }
}
