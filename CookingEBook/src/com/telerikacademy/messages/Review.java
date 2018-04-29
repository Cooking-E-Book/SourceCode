package com.telerikacademy.messages;

import com.telerikacademy.messages.Message;

import java.sql.Timestamp;

public class Review extends Message {

    public Review(String author, Timestamp timestamp) {
        super( author, timestamp );
    }

    @Override
    public void postMessage() {

    }

    @Override
    public void like(String user) {

    }

    @Override
    public void dislike(String user) {

    }
}
