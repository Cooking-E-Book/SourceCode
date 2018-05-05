package com.telerikacademy;

import com.telerikacademy.calculations.TemperatureConverter;
import com.telerikacademy.calculations.UnitConverter;
import com.telerikacademy.components.bulk.PlantBulkIngredient;
import com.telerikacademy.components.liquid.AnimalLiquidIngredient;
import com.telerikacademy.components.solid.AnimalSolidIngredient;
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
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;
import com.telerikacademy.interfaces.Security;
import com.telerikacademy.interfaces.Sourceable;
import com.telerikacademy.messages.Comment;
import com.telerikacademy.messages.Review;
import com.telerikacademy.interfaces.Component;

public class Main {
    
    public static void main(String[] args) {
    
        
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
        Component rise, potato, milk, ghee, mavaCrumbled = null;
        try{

            rise = new PlantBulkIngredient( "Sugar", 2.0,  158, Unit.TEACUP, Sourceable.PlantSource.FRUIT);
            potato = new PlantSolidIngredient( "Red carrots", 1.75, 324, Unit.KILOGRAM, Sourceable.PlantSource.ROOT_VEGETABLE );
            milk = new AnimalLiquidIngredient( "Milk", 0.25,  89, Unit.TEACUP, Sourceable.AnimalSource.MAMMALS );
            ghee = new AnimalLiquidIngredient( "Ghee", 7.0,  158, Unit.TABLESPOON, Sourceable.AnimalSource.MAMMALS);
            mavaCrumbled = new PlantBulkIngredient( "Mava crumbled", 400.0,  328, Unit.GRAM, Sourceable.PlantSource.GRAIN);
            potato = new PlantSolidIngredient( "Almounds", 20.0, 224, Unit.COUNT, Sourceable.PlantSource.FRUIT );

            Recipe gajar_halwa = new Recipe("Gajar Halwa (Carrot Pudding)", Global.currentUser, "Serves: 12\t Pressure Cooking Time 40 minute, in 5 Litre pressure cooker");
            Utensil pressureCooker = new Utensil( "Pressure cooker", "5 Litre, from stainless steel" );
            Utensil ladle = new Utensil( "Ladle" , "Wood ladle");
            System.out.println(pressureCooker);
            Step firstStep = new Step( "Put carrots and milk into cooker\n", 2.0 );
            Step secondStep = new Step( "Close cooker. Bring to full pressure on high heat(15 minutes). Remove cooker immediately from heat.\n" +
                    "Press finger-tip control/lift vent weight lightly to release pressure. Open cooker.\n", 15.0 );
            Step thirdStep = new Step( "Place open cooker with carrots and milk on high heat. Add sugar.\n" +
                    "Cook till liquid dries up (approximately 15 minutes), stirring occasionally. Add mava and ghee.\n", 15.0 );
            Step fourthStep = new Step( "Cook till ghee shows separately (approximately 10 minutes), stirring constantly. Serve hot, garnished with almonds\n", 10.0 );
            HeatTreatedDish htd = new HeatTreatedDish(DishCategory.MAIN_COURSE,  gajar_halwa, 100, HeatTreatedDish.HeatTreatType.BOILING);
            firstStep.add(pressureCooker);
            firstStep.add(ladle);
            secondStep.add(pressureCooker);
            thirdStep.add(pressureCooker);
            fourthStep.add(pressureCooker);
            System.out.println(gajar_halwa);
            System.out.println(gajar_halwa.getId());


            System.out.println(htd);


            System.out.println(firstStep);
            System.out.println(secondStep);
            System.out.println(thirdStep);
            System.out.println(fourthStep);

        } catch (NoSuchMeasurementException e){
            throw new NoSuchBulkMeasurementException();
        } catch (NoSuchPlantSourceException e){
            throw new NoSuchPlantSourceException();
        }
    }
}
