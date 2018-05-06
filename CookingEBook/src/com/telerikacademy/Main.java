package com.telerikacademy;

import com.telerikacademy.app.RecipeCreator;
import com.telerikacademy.calculations.TemperatureConverter;
import com.telerikacademy.calculations.UnitConverter;

import com.telerikacademy.enumerations.TemperatureScale;
import com.telerikacademy.enumerations.Unit;

import com.telerikacademy.exceptions.recipes.RecipeAlreadyExists;
import com.telerikacademy.interfaces.Security;
import com.telerikacademy.messages.Comment;
import com.telerikacademy.messages.Review;


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
        
        Comment ms = new Comment(Global.currentUser, "This is one of my favorite recipes I have ever tried! Thank you for sharing!");
        
        System.out.println(ms.getTimestamp());
        System.out.println(ms.getAuthor().getUsername());
        System.out.println(ms.getComment());
        System.out.println(ms.getLikes());

        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");
        
        ms.like(Global.currentUser);
        System.out.println(ms.getLikes());

        Security.logOut();
        Security.logIn("Pepi", "passwordPepi");

        ms.dislike(Global.currentUser);
        System.out.println(ms.getDislikes());

        Comment rp = new Comment(Global.currentUser, "This is an awful recipe! How could anyone post it here?!");

        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");

        Comment rp1 = new Comment(Global.currentUser, "Pepi, I think you are delusional! Next time before posting any message take your purple pills!");

        ms.addReply(rp);
        ms.addReply(rp1);
        rp.delete(Global.currentUser);
        rp.delete(Global.currentUser);
        ms.readReplies();

        Security.logOut();
        Security.logIn("pavel", "pass");

        ms.delete(Global.currentUser);

        Comment ddd = new Comment(Global.currentUser, "Recipe was total failure!");
        ddd.delete(Global.currentUser);

        Security.logOut();
        Security.logIn("Vladi", "passwordVladi");
        ms.edit(Global.currentUser, "Best recipe ever! 10x!");

        Security.logOut();
        Security.logIn("Pepi", "passwordPepi");
        ms.edit(Global.currentUser, "Can we use chicken instead of pork for this recipe?");

        Review rv = new Review(Global.currentUser, "This is a professionally made dish!");

        Security.logIn("Vladi", "passwordVladi");
        ms.edit(Global.currentUser, "Best recipe ever! 10x!");
        rv.like(Global.currentUser);

        Security.logOut();
        Security.logIn("pavel", "pass");
        rv.like(Global.currentUser);
        

        System.out.println(rv.rate());

        UnitConverter uc = new UnitConverter(Unit.TEACUP, 1, Unit.TABLESPOON);
        System.out.println(uc.convert());

        TemperatureConverter tc = new TemperatureConverter(TemperatureScale.FAHRENHEIT, 32, TemperatureScale.CELSIUS);
        System.out.println(tc.convert());

        // RecipeBox box = new RecipeBox();
        // Gajar Halwa
        try{
            RecipeCreator.createGajarHalwa();
        } catch (RecipeAlreadyExists e){
                throw new RecipeAlreadyExists();
        }
    }
}
