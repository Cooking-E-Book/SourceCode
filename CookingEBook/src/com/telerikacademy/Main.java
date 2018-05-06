package com.telerikacademy;

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

public class Main {
    
    public static void main(String[] args) throws RecipeAlreadyExists {
   
    
        
        // Pavel's code (testing register, login, logout of Author)
        // Info:
        // Visitor cannot comment or create recipes, does not have name and email
        // Can only read


        Security.register("pavel", "pass", "Pavel Ignatov", "lepaff@gmail.com");
        Security.register("Vladi", "passwordVladi", "Vladimir Georgiev", "vladig1984@gmail.com");
        Security.register("Pepi", "passwordPepi", "Petar Petrov", "pepi@gmail.com");

        // Exception Test - working
//        Security.register("pavel", "pass", "Pavel Ignatov", "lepaff@gmail.com");

        for (int i = 0; i < Security.users.size(); i++) {
            System.out.println(Security.users.get(i).getName());
        }

        System.out.println(Global.currentUser.getUsername());

        Security.logOut();

        // Vladi's code (testing classes' functionality):

        Security.logIn("pavel", "pass");
        
        Comment ms = new Comment(1,"This is one of my favorite recipes I have ever tried! Thank you for sharing!");
	
				System.out.println(ms.getRecipeId());
        System.out.println(ms.getTimestamp());
        System.out.println(ms.getAuthor().getUsername());
        System.out.println(ms.getComment());
        System.out.println(ms.getLikes());
	
				Comment ms1 = new Comment(2,"This recipe rules!!!");
	
				System.out.println(ms1.getRecipeId());
				
        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");
        
        ms.like();
        System.out.println(ms.getLikes());
        ms.delete();
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
        rp.delete();
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
        ms.like();
        ms.edit("Best recipe ever! 10x!");

        Security.logOut();
        Security.logIn("Pepi", "passwordPepi");
        ms.edit("Can we use chicken instead of pork for this recipe?");

        Review rv = new Review(1,"This is a professionally made dish!");

        Security.logIn("Vladi", "passwordVladi");
        ms.edit("Best recipe ever! 10x!");
        rv.like();

        Security.logOut();
        Security.logIn("pavel", "pass");
        rv.like();
        

        System.out.println(rv.rate());

        UnitConverter uc = new UnitConverter(Unit.TEACUP, -1, Unit.TABLESPOON);
        System.out.println(uc.convert());

        TemperatureConverter tc = new TemperatureConverter(TemperatureScale.FAHRENHEIT, 32, TemperatureScale.CELSIUS);
        System.out.println(tc.convert());
    
         try{
            RecipeCreator.createGajarHalwa();
        } catch (RecipeAlreadyExists e){
                throw new RecipeAlreadyExists();
        }


    }
}
