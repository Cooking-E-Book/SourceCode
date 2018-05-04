package com.telerikacademy.messages;

import com.telerikacademy.Globals;
import com.telerikacademy.interfaces.Deletable;
import com.telerikacademy.interfaces.Dislikable;
import com.telerikacademy.interfaces.Editable;
import com.telerikacademy.interfaces.Likable;
import com.telerikacademy.users.User;

import java.sql.Time;
import java.sql.Timestamp;

public abstract class Message {
    
    private User author = Globals.currentUser;
    private Timestamp timestamp;
    
    public Message() {
        timestamp = new Timestamp(System.currentTimeMillis());
    }
    
    public User getAuthor() {
        return author;
    }
    
    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s", timestamp, author.getUsername());
    }
}
