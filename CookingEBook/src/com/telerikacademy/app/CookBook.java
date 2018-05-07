package com.telerikacademy.app;

import com.telerikacademy.Global;
import com.telerikacademy.calculations.TemperatureConverter;
import com.telerikacademy.calculations.UnitConverter;
import com.telerikacademy.components.bulk.PlantBulkIngredient;
import com.telerikacademy.components.liquid.AnimalLiquidIngredient;
import com.telerikacademy.components.solid.PlantSolidIngredient;
import com.telerikacademy.cooking.HeatTreatedDish;
import com.telerikacademy.cooking.Recipe;
import com.telerikacademy.cooking.Step;
import com.telerikacademy.cooking.Utensil;
import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.enumerations.TemperatureScale;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.measurement.NoSuchBulkMeasurementException;
import com.telerikacademy.exceptions.measurement.NoSuchMeasurementException;
import com.telerikacademy.exceptions.recipes.RecipeAlreadyExists;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;
import com.telerikacademy.help.*;
import com.telerikacademy.interfaces.Component;
import com.telerikacademy.interfaces.Likable;
import com.telerikacademy.interfaces.Security;
import com.telerikacademy.interfaces.Sourceable;
import com.telerikacademy.io.RecipeBox;
import com.telerikacademy.messages.Comment;
import com.telerikacademy.messages.Message;
import com.telerikacademy.messages.Review;
import com.telerikacademy.messages.Summary;
import com.telerikacademy.users.Admin;
import com.telerikacademy.users.User;
import com.telerikacademy.users.Visitor;

import java.nio.channels.Channel;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CookBook {
    
    private List<User> users;
    private List<Recipe> recipes;
    private List<Comment> comments;
    private List<Summary> summaries;
    private List<Review> reviews;
    private ContactInfo contactInfo;
    private Help help;
    private RecipeCreator recipeCreator;
    private RecipeBox recipeBox;
    
    public CookBook() {
        users = new ArrayList<>();
        recipes = new ArrayList<>();
        comments = new ArrayList<>();
        summaries = new ArrayList<>();
        reviews = new ArrayList<>();
        contactInfo = new ContactInfo("CookBook", "+359888111111", "CookBook@CookBook.com");
        help = new Help(contactInfo);
    }
    
    public void addFAQ(String question, String answer) {
        User user = Global.currentUser;
        if (user instanceof Admin) {
            Question q = new Question(question);
            Answer anw = new Answer(answer);
            FAQ faq = new FAQ(q, anw);
            help.addFAQ(faq);
        }
        else {
            String log = String.format("User (%s) has no rights to edit FAQs' list!", user.getUsername());
            System.out.println(log);
        }
    }
    
    public void readHelp() {
        String contactName = contactInfo.getContactName();
        String contactPhone = contactInfo.getPhoneNumber();
        String contactEmail = contactInfo.getEmailAddress();
    
        System.out.printf("Contact information:\nOrganization's name: \"%s\"\nPhone number: \"%s\"\nE-mail: \"%s\"\n", contactName, contactPhone, contactEmail);
    
        System.out.println("Frequently Asked Questions list:");
        help.readFAQs();
    }
    
    public void convertMeasurementUnits(Unit inputUnit, double inputQuantity, Unit outputUnit) {
        UnitConverter unitConv = new UnitConverter(inputUnit, inputQuantity, outputUnit);
        double outputQuantity = unitConv.convert();
        System.out.printf("%f %s converts to %f %s.\n", inputQuantity, inputUnit, outputQuantity, outputUnit);
    }
    
    public void convertTemperature(TemperatureScale inputScale, double inputTemperature, TemperatureScale outputScale) {
        TemperatureConverter tempConv = new TemperatureConverter(inputScale, inputTemperature, outputScale);
        double outputTemperature = tempConv.convert();
        System.out.printf("%f %s converts to %f %s.\n", inputTemperature, inputScale, outputTemperature, outputScale);
    }
    
    public void addComment(int recipeId, String text) {
        Comment comment = new Comment(recipeId, text);
        comments.add(comment);
        System.out.printf("Comment \"%s\" added at %s\n", comment.getComment(),comment.getTimestamp());
    }
    
    /*private Timestamp setTimestamp(String timestampText) throws ParseException{
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss.SSS" );
            Date parsedDate = dateFormat.parse( timestampText );
            Timestamp timestamp = new java.sql.Timestamp( parsedDate.getTime() );
            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }*/
    
    public void likeComment(String authorName, String commentEntryDate) {
        boolean commentFound = false;
        for (Comment comment : comments) {
            if (comment.getAuthor().getUsername().equals(authorName) && comment.getTimestamp().equals(commentEntryDate)) {
                commentFound = true;
                comment.like();
            }
        }
        
        if (!commentFound) {
            System.out.println("Comment not found! Check author's name and comment's entry date!");
        }
    }
    
    public void dislikeComment(String authorName, String commentEntryDate) {
        boolean commentFound = false;
        for (Comment comment : comments) {
            if (comment.getAuthor().getUsername().equals(authorName) && comment.getTimestamp().equals(commentEntryDate)) {
                commentFound = true;
                comment.dislike();
            }
        }
        
        if (!commentFound) {
            System.out.println("Comment not found! Check author's name and comment's entry date!");
        }
    }
    
    public void deleteComment(String authorName, String commentEntryDate) {
        boolean commentFound = false;
        for (Comment comment : comments) {
            if (comment.getAuthor().getUsername().equals(authorName) && comment.getTimestamp().equals(commentEntryDate)) {
                commentFound = true;
                comment.delete();
            }
        }
        
        if (!commentFound) {
            System.out.println("Comment not found! Check author's name and comment's entry date!");
        }
    }
    
    public void editComment(String authorName, String commentEntryDate, String newComment) {
        boolean commentFound = false;
        for (Comment comment : comments) {
            if (comment.getAuthor().getUsername().equals(authorName) && comment.getTimestamp().equals(commentEntryDate)) {
                commentFound = true;
                comment.edit(newComment);
            }
        }
        
        if (!commentFound) {
            System.out.println("Comment not found! Check author's name and comment's entry date!");
        }
    }
    
    public void addReview(int recipeId, String text) {
        Review review = new Review(recipeId, text);
        reviews.add(review);
    }
    
    public void likeReview(String authorName, String reviewEntryDate) {
        boolean reviewFound = false;
        for (Review review : reviews) {
            if (review.getAuthor().getUsername().equals(authorName) && review.getTimestamp().equals(reviewEntryDate)) {
                reviewFound = true;
                review.like();
            }
        }
        
        if (!reviewFound) {
            System.out.println("Review not found! Check author's name and review's entry date!");
        }
    }
    
    public void dislikeReview(String authorName, String reviewEntryDate) {
        boolean reviewFound = false;
        for (Review review : reviews) {
            if (review.getAuthor().getUsername().equals(authorName) && review.getTimestamp().equals(reviewEntryDate)) {
                reviewFound = true;
                review.dislike();
            }
        }
        
        if (!reviewFound) {
            System.out.println("Review not found! Check author's name and review's entry date!");
        }
    }
    
    public void deleteReview(String authorName, String reviewEntryDate) {
        boolean reviewFound = false;
        for (Review review : reviews) {
            if (review.getAuthor().getUsername().equals(authorName) && review.getTimestamp().equals(reviewEntryDate)) {
                reviewFound = true;
                review.delete();
            }
        }
        
        if (!reviewFound) {
            System.out.println("Review not found! Check author's name and review's entry date!");
        }
    }
    
    public void editReview(String authorName, String reviewEntryDate, String newReview) {
        boolean reviewFound = false;
        for (Review review : reviews) {
            if (review.getAuthor().getUsername().equals(authorName) && review.getTimestamp().equals(reviewEntryDate)) {
                reviewFound = true;
                review.edit(newReview);
            }
        }
        
        if (!reviewFound) {
            System.out.println("Review not found! Check author's name and review's entry date!");
        }
    }
    
    public void rateReview(String authorName, String reviewEntryDate) {
        boolean reviewFound = false;
        for (Review review : reviews) {
            if (review.getAuthor().getUsername().equals(authorName) && review.getTimestamp().equals(reviewEntryDate)) {
                reviewFound = true;
                review.rate();
            }
        }
        
        if (!reviewFound) {
            System.out.println("Review not found! Check author's name and review's entry date!");
        }
    }
    
    public void likeSummary(String authorName, String summaryEntryDate) {
        boolean summaryFound = false;
        for (Summary summary : summaries) {
            if (summary.getAuthor().getUsername().equals(authorName) && summary.getTimestamp().equals(summaryEntryDate)) {
                summaryFound = true;
                summary.like();
            }
        }
        
        if (!summaryFound) {
            System.out.println("Summary not found! Check author's name and summary's entry date!");
        }
    }
    
    public void dislikeSummary(String authorName, String summaryEntryDate) {
        boolean summaryFound = false;
        for (Summary summary : summaries) {
            if (summary.getAuthor().getUsername().equals(authorName) && summary.getTimestamp().equals(summaryEntryDate)) {
                summaryFound = true;
                summary.dislike();
            }
        }
        
        if (!summaryFound) {
            System.out.println("Summary not found! Check author's name and summary's entry date!");
        }
    }
    
    public void deleteSummary(String authorName, String summaryEntryDate) {
        boolean summaryFound = false;
        for (Summary summary : summaries) {
            if (summary.getAuthor().getUsername().equals(authorName) && summary.getTimestamp().equals(summaryEntryDate)) {
                summaryFound = true;
                summary.delete();
            }
        }
        
        if (!summaryFound) {
            System.out.println("Summary not found! Check author's name and summary's entry date!");
        }
    }
    
    public void editSummary(String authorName, String summaryEntryDate, String newSummary) {
        boolean summaryFound = false;
        for (Summary summary : summaries) {
            if (summary.getAuthor().getUsername().equals(authorName) && summary.getTimestamp().equals(summaryEntryDate)) {
                summaryFound = true;
                summary.edit(newSummary);
            }
        }
        
        if (!summaryFound) {
            System.out.println("Summary not found! Check author's name and summary's entry date!");
        }
    }
    
    public void rateSummary(String authorName, String summaryEntryDate) {
        boolean summaryFound = false;
        for (Summary summary : summaries) {
            if (summary.getAuthor().getUsername().equals(authorName) && summary.getTimestamp().equals(summaryEntryDate)) {
                summaryFound = true;
                summary.rate();
            }
        }
        
        if (!summaryFound) {
            System.out.println("Summary not found! Check author's name and summary's entry date!");
        }
    }
    
    public void listRecipesComments(int recipeId) {
        boolean recipeFound = false;
        for (Recipe recipe : recipes) {
            if(recipeId == recipe.getId()) {
                recipeFound = true;
                boolean commentFound = false;
                for (Comment comment : comments) {
                    if (recipeId == comment.getRecipeId()) {
                        commentFound = true;
                        String author = comment.getAuthor().getUsername();
                        String timestamp = comment.getTimestamp();
                        String commentText = comment.getComment();
                        System.out.printf("%s: %s said: \"%s\".\n", timestamp, author, commentText);
                    }
                    
                    if (!commentFound) {
                        System.out.println("The recipe has no comments!");
                    }
                }
            }
        }
    
        if (!recipeFound) {
            System.out.println("No such recipe found!");
        }
    }
    
    public void listRecipesReviews(int recipeId) {
        boolean recipeFound = false;
        for (Recipe recipe : recipes) {
            if(recipeId == recipe.getId()) {
                recipeFound = true;
                boolean reviewFound = false;
                for (Review review : reviews) {
                    if (recipeId == review.getRecipeId()) {
                        reviewFound = true;
                        String author = review.getAuthor().getUsername();
                        String timestamp = review.getTimestamp();
                        String reviewText = review.getReview();
                        System.out.printf("%s: %s reviewed recipe saying: \"%s\".\n", timestamp, author, reviewText);
                    }
                    
                    if (!reviewFound) {
                        System.out.println("The recipe has no reviews!");
                    }
                }
            }
        }
        
        if (!recipeFound) {
            System.out.println("No such recipe found!");
        }
    }
    
    public void addRecipe() throws RecipeAlreadyExists{
        //RecipeCreator recipeCreator = new RecipeCreator();
        try{recipeBox.writeRecipe( "recipes/Cook book.txt", recipeCreator.createGajarHalwa() );
            //recipeCreator.createGajarHalwa();
        } catch (RecipeAlreadyExists e){
            throw new RecipeAlreadyExists();
        }
    }

}
