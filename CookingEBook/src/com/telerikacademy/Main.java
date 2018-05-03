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
import com.telerikacademy.users.Author;
import com.telerikacademy.users.User;

public class Main {

    public static void main(String[] args) {
        // Oxana's code:
        RecipeBox box = new RecipeBox();
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
        }
    
        // Vladi's code (testing classes' functionality):
        Comment ms = new Comment("Vladi", "This is one of my favorite recipes I have ever tried! Thank you for sharing!");
    
        System.out.println(ms.getTimestamp());
        System.out.println(ms.getAuthor());
        System.out.println(ms.getComment());
        System.out.println(ms.getLikes());
    
        ms.like("Pepi");
        System.out.println(ms.getLikes());
        ms.dislike("Sashka");
        System.out.println(ms.getDislikes());
    
        Comment rp = new Comment("Pepi", "This is an awful recipe! How could anyone post it here?!");
        Comment rp1 = new Comment("Vladi", "Pepi, I think you are delusional! Next time before posting any message take your purple pills!");
        
        ms.addReply(rp);
        ms.addReply(rp1);
        rp.delete("Vladi");
        rp.delete("Pepi");
        ms.readReplies();
    
        ms.delete("Vladi");
        
        Comment ddd = new Comment("Sashka", "Recipe was total failure!");
        ddd.delete("Sashka");
        
        ms.edit("Vladi", "Best recipe ever! 10x!");
        ms.edit("Sashka", "Can we use chicken instead of pork for this recipe?");
    
        Review rv = new Review("Vladi", "This is a professionally made dish!");
        
        rv.like("Pepi");
        rv.like("Asen");
        rv.dislike("Vanya");
        rv.like("Ayshe");
    
        System.out.println(rv.rate());
    
        UnitConverter uc = new UnitConverter(Unit.TEACUP, 1, Unit.TABLESPOON);
        System.out.println(uc.convert());
    
        TemperatureConverter tc = new TemperatureConverter(TemperatureScale.FAHRENHEIT, 32, TemperatureScale.CELSIUS);
        System.out.println(tc.convert());


        Security.register("pavel", "pass", "Pavel Ignatov", "lepaff@gmail.com");
    }
}
