package com.telerikacademy.messages;

import com.telerikacademy.Global;
import com.telerikacademy.exceptions.messages.NoSuchMessageExists;
import com.telerikacademy.exceptions.user.UserAccessDeniedException;
import com.telerikacademy.interfaces.*;
import com.telerikacademy.users.Admin;
import com.telerikacademy.users.Author;
import com.telerikacademy.users.User;

import java.sql.Timestamp;

public class Review extends Message implements Likable, Dislikable, Editable, Deletable, Ratable {
    
    private String review;
    private int likes;
    private int dislikes;
    private boolean isDeleted;
    
    public Review(int recipeId, String review) {
        super(recipeId);
        this.review = review;
        likes = 0;
        dislikes = 0;
        isDeleted = false;
    }
    
    public String getReview() {
        return review;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public int getDislikes() {
        return dislikes;
    }
    
    @Override
    public void like() throws NoSuchMessageExists, UserAccessDeniedException {
        User user = Global.currentUser;
        if (isDeleted) {
            throw new NoSuchMessageExists(review);
        }
        else if (user instanceof Admin || user instanceof Author) {
            String log = String.format("%s liked: \"%s\"", user.getUsername(), review);
            System.out.println(log);
            likes++;
        }
        else {
            throw new UserAccessDeniedException(user.getUsername());
        }
    }
    
    @Override
    public void dislike() throws NoSuchMessageExists, UserAccessDeniedException {
        User user = Global.currentUser;
        if (isDeleted) {
            throw new NoSuchMessageExists(review);
        }
        else if (user instanceof Admin || user instanceof Author) {
            String log = String.format("%s disliked: \"%s\"", user.getUsername(), review);
            System.out.println(log);
            dislikes++;
        }
        else {
            throw new UserAccessDeniedException(user.getUsername());
        }
    }
    
    // modify to be deleted only by admin and/ or author
    @Override
    public void delete() throws NoSuchMessageExists, UserAccessDeniedException {
        User user = Global.currentUser;
        if (!isDeleted) {
            if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
                String log = String.format("%s deleted \"%s\"", user.getUsername(), review);
                System.out.println(log);
                isDeleted = true;
            }
            else {
                throw new UserAccessDeniedException(user.getUsername());
            }
        }
        else {
            throw new NoSuchMessageExists(review);
        }
    }
    
    @Override
    public void edit(String review) throws NoSuchMessageExists, UserAccessDeniedException {
        User user = Global.currentUser;
        String prevReview = this.review;
        if (!isDeleted) {
            if (user.getUsername().equals(this.getAuthor().getUsername()) || user instanceof Admin) {
                this.review = review;
                String log = String.format("%s edited \"%s\"\n into \"%s\"!", user.getUsername(), prevReview, review);
                System.out.println(log);
            }
            else {
                throw new UserAccessDeniedException(user.getUsername());
            }
        }
        else {
            throw new NoSuchMessageExists(this.review);
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
