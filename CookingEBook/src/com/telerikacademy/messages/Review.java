package com.telerikacademy.messages;

import com.telerikacademy.interfaces.*;
import com.telerikacademy.users.Admin;
import com.telerikacademy.users.Author;
import com.telerikacademy.users.User;

public class Review extends Message implements Likable, Dislikable, Editable, Deletable, Ratable {
    
    private String review;
    private int likes;
    private int dislikes;
    private boolean isDeleted;
    
    public Review(User author, String review) {
        super(author);
        super.getTimestamp();
        this.review = review;
        likes = 0;
        dislikes = 0;
        isDeleted = false;
    }
    
    @Override
    public void like(User user) {
        if (user instanceof Admin || user instanceof Author) {
            String log = String.format("%s liked: \"%s\"", user.getUsername(), review);
            System.out.println(log);
            likes++;
        }
        else {
            String log = String.format("%s is a visitor. In order to like, please sign up or log in your profile first!", user.getUsername());
            System.out.println(log);
        }
    }
    
    @Override
    public void dislike(User user) {
        if (user instanceof Admin || user instanceof Author) {
            String log = String.format("%s disliked: \"%s\"", user.getUsername(), review);
            System.out.println(log);
            dislikes++;
        }
        else {
            String log = String.format("%s is a visitor. In order to dislike, please sign up or log in your profile first!", user.getUsername());
            System.out.println(log);
        }
    }
    
    // modify to be deleted only by admin and/ or author
    @Override
    public void delete(User user) {
        if (!isDeleted) {
            if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
                String log = String.format("%s deleted \"%s\"", user.getUsername(), review);
                System.out.println(log);
                isDeleted = true;
            }
            else {
                String log = String.format("%s does not have the rights to delete this review!", user.getUsername());
                System.out.println(log);
            }
        }
        else {
            System.out.printf("Comment \"%s\": already deleted!", review);
            System.out.println();
        }
    }
    
    @Override
    public void edit(User user, String review) {
        String prevReview = this.review;
        if (!isDeleted) {
            if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
                this.review = review;
                String log = String.format("%s edited \"%s\"\n into \"%s\"!", user.getUsername(), prevReview, review);
                System.out.println(log);
            }
            else {
                String log = String.format("%s does not have the rights to edit this review!", user.getUsername());
                System.out.println(log);
            }
        }
        else {
            String log = String.format("Review \"%s\": already deleted!", this.review);
            System.out.println(log);
        }
    }
    
    @Override
    public double rate() {
        
        double rating = 0;
        
        if (likes == 0 && dislikes == 0) {
            return rating;
        }
        
        double score = (double) likes / (likes + dislikes);
        if (score <= 0.1) {
            rating = 0.5;
        }
        else if (score <= 0.2) {
            rating = 1;
        }
        else if (score <= 0.3) {
            rating = 1.5;
        }
        else if (score <= 0.4) {
            rating = 2;
        }
        else if (score <= 0.5) {
            rating = 2.5;
        }
        else if (score <= 0.6) {
            rating = 3;
        }
        else if (score <= 0.7) {
            rating = 3.5;
        }
        else if (score <= 0.8) {
            rating = 4;
        }
        else if (score <= 0.9) {
            rating = 4.5;
        }
        else {
            rating = 5;
        }
        return rating;
    }
}
