package com.telerikacademy.messages;

import com.telerikacademy.interfaces.*;
import com.telerikacademy.messages.Message;

import java.sql.Timestamp;

public class Review extends Message implements Likable, Dislikable, Editable, Deletable, Ratable {

    private String review;
    //private Timestamp timestamp;
    private int likes;
    private int dislikes;
    private boolean isDeleted;
    
    public Review(String author, Timestamp timestamp, String review) {
        super(author, timestamp);
        //timestamp = new Timestamp(System.currentTimeMillis());
        this.review = review;
        likes = 0;
        dislikes = 0;
        isDeleted = false;
    }

    @Override
    public void postMessage() {
        System.out.println(this);
    }
    
    public void like(String user) {
        String log = String.format("%s liked %s", user, review);
        System.out.println(log);
        likes++;
    }
    
    public void dislike(String user) {
        String log = String.format("%s disliked %s", user, review);
        System.out.println(log);
        dislikes++;
    }
    
    // modify to be deleted only by admin and/ or author
    public void delete(String user) {
        if (!isDeleted) {
            String log = String.format("%s deleted %s", user, review);
            System.out.println(log);
        }
        else {
            System.out.printf("Review \"%s\": already deleted!", review);
        }
    }
    
    public double getRating() {
        
        double rating = 0;
        
        if (likes == 0 && dislikes == 0) {
            return rating;
        }
        
        double score = likes / (likes + dislikes);
        if (score <= 0.1) {
            rating = 0.5;
        }
        else if (likes <= 0.2) {
            rating = 1;
        }
        else if (likes <= 0.3) {
            rating = 1.5;
        }
        else if (likes <= 0.4) {
            rating = 2;
        }
        else if (likes <= 0.5) {
            rating = 2.5;
        }
        else if (likes <= 0.6) {
            rating = 3;
        }
        else if (likes <= 0.7) {
            rating = 3.5;
        }
        else if (likes <= 0.8) {
            rating = 4;
        }
        else if (likes <= 0.9) {
            rating = 4.5;
        }
        else {
            rating = 5;
        }
        return rating;
    }
}
