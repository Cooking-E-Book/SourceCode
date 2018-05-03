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
        
        // Vladi's code (testing classes' functionality):
        Author vladi = new Author("Vladi", "passwordVladi", "Vladimir Georgiev", "vladig1984@gmail.com");
        
        Admin pepi = new Admin("Pepi", "passwordPepi", "Petar Petrov", "pepi@gmail.com");
        
        Visitor sashka = new Visitor("Sashka");
        
        Comment ms = new Comment(vladi, "This is one of my favorite recipes I have ever tried! Thank you for sharing!");
        
        System.out.println(ms.getTimestamp());
        System.out.println(ms.getAuthor().getUsername());
        System.out.println(ms.getComment());
        System.out.println(ms.getLikes());
        
        ms.like(pepi);
        System.out.println(ms.getLikes());
        ms.dislike(sashka);
        System.out.println(ms.getDislikes());
        
        Comment rp = new Comment(pepi, "This is an awful recipe! How could anyone post it here?!");
        Comment rp1 = new Comment(vladi, "Pepi, I think you are delusional! Next time before posting any message take your purple pills!");
        
        ms.addReply(rp);
        ms.addReply(rp1);
        rp.delete(vladi);
        rp.delete(pepi);
        ms.readReplies();
        
        ms.delete(vladi);
        
        Comment ddd = new Comment(sashka, "Recipe was total failure!");
        ddd.delete(sashka);
        
        ms.edit(vladi, "Best recipe ever! 10x!");
        ms.edit(sashka, "Can we use chicken instead of pork for this recipe?");
        
        Review rv = new Review(vladi, "This is a professionally made dish!");
        
        rv.like(pepi);
        
        Visitor asen = new Visitor("Asen");
        rv.like(asen);
        
        Author vanya = new Author("Vanya", "passwordVanya", "Vanya Vaneva", "vanya@gmail.com");
        
        Admin ayshe = new Admin("Ayshe", "passwordAyshe", "Ayshe Aysheva", "ayshe@abv.bg");
        rv.dislike(vanya);
        rv.like(ayshe);
        
        System.out.println(rv.rate());
        
        UnitConverter uc = new UnitConverter(Unit.TEACUP, 1, Unit.TABLESPOON);
        System.out.println(uc.convert());
        
        TemperatureConverter tc = new TemperatureConverter(TemperatureScale.FAHRENHEIT, 32, TemperatureScale.CELSIUS);
        System.out.println(tc.convert());
        
        
        Security.register("pavel", "pass", "Pavel Ignatov", "lepaff@gmail.com");
    }
}
