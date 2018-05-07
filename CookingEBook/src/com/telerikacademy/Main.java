package com.telerikacademy;

import com.telerikacademy.app.CookBook;
import com.telerikacademy.calculations.TemperatureConverter;
import com.telerikacademy.calculations.UnitConverter;
import com.telerikacademy.enumerations.TemperatureScale;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.enumerations.UserType;
import com.telerikacademy.exceptions.recipes.RecipeAlreadyExists;
import com.telerikacademy.interfaces.Security;
import com.telerikacademy.messages.Comment;
import com.telerikacademy.messages.Review;

public class Main {
    public static void main(String[] args) throws RecipeAlreadyExists {
        
        // Pavel's code (testing register, login, logout of Author)
        // Info:
        // Visitor cannot comment or create recipes, does not have name and email, can only read recipes

        // Register users
        Security.register(UserType.AUTHOR,"pavel", "pass", "Pavel Ignatov", "lepaff@gmail.com");
        Security.register(UserType.AUTHOR,"Vladi", "passwordVladi", "Vladimir Georgiev", "vladig1984@gmail.com");
        Security.register(UserType.AUTHOR,"Pepi", "passwordPepi", "Petar Petrov", "pepi@gmail.com");
        // Will not create the new admin, will create the default admin and login
        Security.register(UserType.ADMIN,"test", "test", "test", "test@gmail.com");


        // Log out from last registered user
	    Security.logOut();
			  
        // Testing message and user class functionality
        
        // Log in as Pavel:
        Security.logIn("pavel", "pass");
        
        Comment ms = new Comment(1,"This is of my favorite recipes I have ever tried! Thank you for sharing!");
	    System.out.println(ms.getRecipeId());
        System.out.println(ms.getTimestamp());
        System.out.println(ms.getAuthor().getUsername());
        System.out.println(ms.getComment());
        System.out.println(ms.getLikes());
        ms.edit( "This is one of my favorite soups I have ever tried! Thanks!" );
        System.out.println(ms.getTimestamp());
	    Comment ms1 = new Comment(2,"This recipe rules!!!");
	    System.out.println(ms1.getRecipeId());
        Security.logOut();
        
        // Log in as Vladi:
        Security.logIn("Vladi", "passwordVladi");
        System.out.println(Global.currentUser.getUsername());
        
        ms.like();
        System.out.println(ms.getLikes());
        //ms.delete(); // throws exception because Vladi is not the author of ms and has no rights to delete it
        System.out.println(ms.getRecipeId());
        Security.logOut();
        
        // Log in as Pepi:
        Security.logIn("Pepi", "passwordPepi");

        ms.dislike();
        System.out.println(ms.getDislikes());
        Comment rp = new Comment(1,"This is an awful recipe! How could anyone post it here?!");
        Security.logOut();
        
        // Log in again as Vladi:
        Security.logIn("Vladi", "passwordVladi");

        Comment rp1 = new Comment(1,"Pepi, I think you are delusional! Next time before posting any message take your purple pills!");
        Comment rp2 = new Comment(1,"Pepi, tick-tack!");
        ms.addReply(rp);
        ms.addReply(rp1);
        ms.addReply(rp2);
        //rp.delete(); // throws exception
        rp1.delete();
        ms.readReplies();
        Security.logOut();
        
        // Log in again as Pavel:
        Security.logIn("pavel", "pass");

        ms.delete();
        Comment ms2 = new Comment(3,"Recipe was total failure!");
        System.out.println(ms2.getRecipeId());
        ms2.delete();
        Security.logOut();
        
        // Log in as Vladi:
        Security.logIn("Vladi", "passwordVladi");
        //ms.like(); // throws exception because ms is already deleted
        //ms.edit("Best recipe ever! 10x!"); // throws exception for the same reason
        Security.logOut();
        
        // Log in as Pepi:
        Security.logIn("Pepi", "passwordPepi");

        Review rv = new Review(1,"This is a professionally made dish!");
        
        // Log in as Vladi:
        Security.logIn("Vladi", "passwordVladi");
        rv.like();
        Security.logOut();
        
        // Log in as Pavel
        Security.logIn("pavel", "pass");
        rv.like();
        System.out.println(rv.rate());
    
        // Testing unit converter and temperature converter classes functionality
        
        UnitConverter uc = new UnitConverter(Unit.TEACUP, 1, Unit.TABLESPOON);
        System.out.println(uc.convert());

        TemperatureConverter tc = new TemperatureConverter(TemperatureScale.FAHRENHEIT, 32, TemperatureScale.CELSIUS);
        System.out.println(tc.convert());
    
        
        // Testing CookBook class functionality
        CookBook cookBook = new CookBook();
    
        // we should know which author is Admin, which one is Author, and which one is Subscriber
        
        // Log in as Pavel
        Security.logIn("admin", "adminPass");
        
        cookBook.addFAQ("How to register?", "Go to registration form and follow the instructions.");
        cookBook.addFAQ("Are the authors of your recipes professionally trained chefs?", "Yes, all of our recipe contributors are professional cooks with extensive work experience in the art of cooking.");
        cookBook.addFAQ("Can I change my password?", "Yes, please go to our password-change form!");
        cookBook.addRecipe(cookBook.getRecipeCreator().createGajarHalwa());
        Security.logOut();
        
        // Log in as Vladi
        Security.logIn("Vladi", "passwordVladi");
        
        cookBook.readHelp();
        cookBook.addComment(1, "A lovely recipe!");
        cookBook.addRecipe(cookBook.getRecipeCreator().createBasmatiRice());
        Security.logOut();
        
        // Log in as Pepi
        Security.logIn("Pepi", "passwordPepi");
        cookBook.addComment(2, "Not bad, but I would rather not try it again!");
        Security.logOut();
        
        // Log in as Pavel
        Security.logIn("pavel", "pass");
        cookBook.likeComment( "Vladi", "2018/05/07");
        cookBook.dislikeComment( "Pepi", "2018/05/07" );
    }
}
