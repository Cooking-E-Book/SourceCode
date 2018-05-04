package com.telerikacademy;

import com.telerikacademy.calculations.TemperatureConverter;
import com.telerikacademy.calculations.UnitConverter;
import com.telerikacademy.components.bulk.PlantBulkIngredient;
import com.telerikacademy.components.liquid.AnimalLiquidIngredient;
import com.telerikacademy.components.solid.PlantSolidIngredient;
import com.telerikacademy.enumerations.TemperatureScale;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.measurement.NoSuchBulkMeasurementException;
import com.telerikacademy.exceptions.measurement.NoSuchMeasurementException;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;
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
    
    public static void main(String[] args) {
        // Oxana's code:
        /*RecipeBox box = new RecipeBox();
        Component rise, potato, milk = null;
        try{
//            bulk = new BulkIngredient( "Rise", 1.5,  158, Unit.COUNT);
//            System.out.println(bulk);
            rise = new PlantBulkIngredient( "Rise", 1.5,  158, Unit.TEACUP, Sourceable.PlantSource.GRAIN);
            potato = new PlantSolidIngredient( "Red Potato", 500.0, 108, Unit.GRAM, Sourceable.PlantSource.ROOT_VEGETABLE );
            milk = new AnimalLiquidIngredient( "Milk", 1.0,  308, Unit.LITER,Sourceable.AnimalSource.MAMMALS );
           System.out.println(rise);
            System.out.println(potato);
            System.out.println(milk);

        } catch (NoSuchMeasurementException e){
            throw new NoSuchBulkMeasurementException();
        } catch (NoSuchPlantSourceException e){
            throw new NoSuchPlantSourceException();
        }*/

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

        System.out.println(Globals.currentUser.getUsername());

        Security.logOut();

        // Vladi's code (testing classes' functionality):

        Security.logIn("pavel", "pass");
        
        Comment ms = new Comment(Globals.currentUser, "This is one of my favorite recipes I have ever tried! Thank you for sharing!");
        
        System.out.println(ms.getTimestamp());
        System.out.println(ms.getAuthor().getUsername());
        System.out.println(ms.getComment());
        System.out.println(ms.getLikes());

        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");
        
        ms.like(Globals.currentUser);
        System.out.println(ms.getLikes());

        Security.logOut();
        Security.logIn("Pepi", "passwordPepi");

        ms.dislike(Globals.currentUser);
        System.out.println(ms.getDislikes());

        Comment rp = new Comment(Globals.currentUser, "This is an awful recipe! How could anyone post it here?!");

        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");

        Comment rp1 = new Comment(Globals.currentUser, "Pepi, I think you are delusional! Next time before posting any message take your purple pills!");

        ms.addReply(rp);
        ms.addReply(rp1);
        rp.delete(Globals.currentUser);
        rp.delete(Globals.currentUser);
        ms.readReplies();

        Security.logOut();
        Security.logIn("pavel", "pass");

        ms.delete(Globals.currentUser);

        Comment ddd = new Comment(Globals.currentUser, "Recipe was total failure!");
        ddd.delete(Globals.currentUser);

        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");
        ms.edit(Globals.currentUser, "Best recipe ever! 10x!");

        Security.logOut();
        Security.logIn("Pepi", "passwordPepi");
        ms.edit(Globals.currentUser, "Can we use chicken instead of pork for this recipe?");

        Review rv = new Review(Globals.currentUser, "This is a professionally made dish!");

        Security.logIn("Vladi", "passwordVladi");
        ms.edit(Globals.currentUser, "Best recipe ever! 10x!");
        rv.like(Globals.currentUser);

        Security.logOut();
        Security.logIn("pavel", "pass");
        rv.like(Globals.currentUser);
        

        System.out.println(rv.rate());

        UnitConverter uc = new UnitConverter(Unit.TEACUP, 1, Unit.TABLESPOON);
        System.out.println(uc.convert());

        TemperatureConverter tc = new TemperatureConverter(TemperatureScale.FAHRENHEIT, 32, TemperatureScale.CELSIUS);
        System.out.println(tc.convert());







    }
}
