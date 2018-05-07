package com.telerikacademy;

import com.telerikacademy.app.CookBook;
import com.telerikacademy.app.RecipeCreator;
import com.telerikacademy.calculations.TemperatureConverter;
import com.telerikacademy.calculations.UnitConverter;
import com.telerikacademy.components.bulk.PlantBulkIngredient;
import com.telerikacademy.components.liquid.AnimalLiquidIngredient;
import com.telerikacademy.components.solid.PlantSolidIngredient;
import com.telerikacademy.cooking.Dish;
import com.telerikacademy.cooking.HeatTreatedDish;
import com.telerikacademy.cooking.Recipe;
import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.enumerations.TemperatureScale;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.measurement.NoSuchBulkMeasurementException;
import com.telerikacademy.exceptions.measurement.NoSuchMeasurementException;
import com.telerikacademy.exceptions.recipes.RecipeAlreadyExists;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;
import com.telerikacademy.interfaces.Dislikable;
import com.telerikacademy.interfaces.Security;
import com.telerikacademy.interfaces.Sourceable;
import com.telerikacademy.io.RecipeBox;
import com.telerikacademy.messages.Comment;
import com.telerikacademy.messages.Review;
import com.telerikacademy.interfaces.Component;
import com.telerikacademy.users.Admin;
import com.telerikacademy.users.Author;
import com.telerikacademy.users.User;
import com.telerikacademy.users.Visitor;

import java.text.ParseException;

public class Main {
    
    public static void main(String[] args) throws RecipeAlreadyExists, ParseException {
   
    
        
        // Pavel's code (testing register, login, logout of Author)
        // Info:
        // Visitor cannot comment or create recipes, does not have name and email
        // Can only read


        Security.register("pavel", "pass", "Pavel Ignatov", "lepaff@gmail.com");
        Security.register("Vladi", "passwordVladi", "Vladimir Georgiev", "vladig1984@gmail.com");
        Security.register("Pepi", "passwordPepi", "Petar Petrov", "pepi@gmail.com");
	
			Security.logOut();
        // Exception Test - working
//        Security.register("pavel", "pass", "Pavel Ignatov", "lepaff@gmail.com");

        for (int i = 0; i < Security.users.size(); i++) {
            System.out.println(Security.users.get(i).getName());
        }

        System.out.println(Global.currentUser.getUsername());
        
        // Vladi's code (testing classes' functionality):

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
        Security.logIn("Vladi", "passwordVladi");
        
        ms.like();
        System.out.println(ms.getLikes());
        //ms.delete();
				System.out.println(ms.getRecipeId());

        Security.logOut();
        Security.logIn("Pepi", "passwordPepi");

        ms.dislike();
        System.out.println(ms.getDislikes());

        Comment rp = new Comment(1,"This is an awful recipe! How could anyone post it here?!");

        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");

        Comment rp1 = new Comment(1,"Pepi, I think you are delusional! Next time before posting any message take your purple pills!");
        Comment rp2 = new Comment(1,"Pepi, tick-tack!");

        ms.addReply(rp);
        ms.addReply(rp1);
        ms.addReply(rp2);
        //rp.delete();
        rp1.delete();
        ms.readReplies();

        Security.logOut();
        Security.logIn("pavel", "pass");

        ms.delete();

        Comment ddd = new Comment(3,"Recipe was total failure!");
				System.out.println(ddd.getRecipeId());
        ddd.delete();

        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");
        //ms.like();
        //ms.edit("Best recipe ever! 10x!");

        Security.logOut();
        Security.logIn("Pepi", "passwordPepi");
        //ms.edit("Can we use chicken instead of pork for this recipe?");

        Review rv = new Review(1,"This is a professionally made dish!");

        Security.logIn("Vladi", "passwordVladi");
        //ms.edit("Best recipe ever! 10x!");
        rv.like();

        Security.logOut();
        Security.logIn("pavel", "pass");
        rv.like();
        

        System.out.println(rv.rate());

        UnitConverter uc = new UnitConverter(Unit.TEACUP, 1, Unit.TABLESPOON);
        System.out.println(uc.convert());

        TemperatureConverter tc = new TemperatureConverter(TemperatureScale.FAHRENHEIT, 32, TemperatureScale.CELSIUS);
        System.out.println(tc.convert());
    
        CookBook cookBook = new CookBook();
    
        // we should know which author is Admin, which one is Author, and which one is Subscriber
        Security.logIn("pavel", "pass");
        
        cookBook.addFAQ("How to register?", "Go to registration form and follow the instructions.");
        cookBook.addFAQ("Are the authors of your recipes professionally trained chefs?", "Yes, all of our recipe contributors are professional cooks with extensive work experience in the art of cooking.");
    
        cookBook.addRecipe(); //method must be changed if truly new recipes are to be added (not just GajarHalwa)
        
        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");
        
        cookBook.readHelp();
    
        cookBook.addComment(1, "A lovely recipe!");
        cookBook.addRecipe(); //method must be changed if truly new recipes are to be added (not just GajarHalwa)
    
        Security.logOut();
        Security.logIn("Pepi", "passwordPepi");
        
        cookBook.addComment(2, "Not bad, but I would rather not try it again!");
    
        Security.logOut();
        Security.logIn("pavel", "pass");
        
        cookBook.likeComment( "Vladi", "2018/05/07");
        cookBook.dislikeComment( "Pepi", "2018/05/07" );
        //RecipeBox box = new RecipeBox();
        // Gajar Halwa
        try{
            RecipeCreator rs = new RecipeCreator();
            rs.createGajarHalwa();
        } catch (RecipeAlreadyExists e){
            throw new RecipeAlreadyExists();
        }
    }
}
