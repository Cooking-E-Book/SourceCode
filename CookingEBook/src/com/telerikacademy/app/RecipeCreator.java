package com.telerikacademy.app;

import com.telerikacademy.Global;
import com.telerikacademy.components.bulk.PlantBulkIngredient;
import com.telerikacademy.components.liquid.AnimalLiquidIngredient;
import com.telerikacademy.components.solid.PlantSolidIngredient;
import com.telerikacademy.cooking.HeatTreatedDish;
import com.telerikacademy.cooking.Recipe;
import com.telerikacademy.cooking.Step;
import com.telerikacademy.cooking.Utensil;
import com.telerikacademy.enumerations.DishCategory;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.measurement.NoSuchBulkMeasurementException;
import com.telerikacademy.exceptions.measurement.NoSuchMeasurementException;
import com.telerikacademy.exceptions.recipes.RecipeAlreadyExists;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;
import com.telerikacademy.interfaces.Component;
import com.telerikacademy.interfaces.Sourceable;

import java.util.HashMap;

public class RecipeCreator {
    private static HashMap<Integer, Recipe> recipesByRecipeId = new HashMap<>(  );

    public static void createGajarHalwa() throws RecipeAlreadyExists {
        Component rise, potato, milk, ghee, mavaCrumbled, almonds = null;
        try{
            Recipe gajar_halwa = new Recipe("Gajar Halwa (Carrot Pudding)", Global.currentUser, "Serves: 12\t Pressure Cooking Time 40 minute, in 5 Litre pressure cooker");
            rise = new PlantBulkIngredient( "Sugar", 2.0,  158, Unit.TEACUP, Sourceable.PlantSource.FRUIT);
            String riseAmount = "" + rise.getQuantity() + rise.getUnit().toString();
            gajar_halwa.addIngredient( riseAmount, rise );

            potato = new PlantSolidIngredient( "Red carrots", 1.75, 324, Unit.KILOGRAM, Sourceable.PlantSource.ROOT_VEGETABLE );
            String potatoAmount = "" + potato.getQuantity() + potato.getUnit().toString();
            gajar_halwa.addIngredient( potatoAmount, potato );
            milk = new AnimalLiquidIngredient( "Milk", 0.25,  89, Unit.TEACUP, Sourceable.AnimalSource.MAMMALS );
            String milkAmount = "" + milk.getQuantity() + milk.getUnit().toString();
            gajar_halwa.addIngredient( milkAmount, milk );
            ghee = new AnimalLiquidIngredient( "Ghee", 7.0,  158, Unit.TABLESPOON, Sourceable.AnimalSource.MAMMALS);
            String gheeAmount = "" + ghee.getQuantity() + ghee.getUnit().toString();
            gajar_halwa.addIngredient( gheeAmount, ghee );
            mavaCrumbled = new PlantBulkIngredient( "Mava crumbled", 400.0,  328, Unit.GRAM, Sourceable.PlantSource.GRAIN);
            String mavaAmount = "" + mavaCrumbled.getQuantity() + mavaCrumbled.getUnit().toString();
            gajar_halwa.addIngredient( mavaAmount, mavaCrumbled );
            almonds = new PlantSolidIngredient( "Almonds", 20.0, 224, Unit.COUNT, Sourceable.PlantSource.FRUIT );
            String almondsAmount = "" + almonds.getQuantity() + almonds.getUnit().toString();
            gajar_halwa.addIngredient( almondsAmount, almonds );
            if (recipesByRecipeId.containsKey( gajar_halwa.getId() )) {
                throw new RecipeAlreadyExists();
            } else {
                recipesByRecipeId.put( gajar_halwa.getId(), gajar_halwa );
            }

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
            System.out.println(htd);

        } catch (NoSuchMeasurementException e){
            throw new NoSuchBulkMeasurementException();
        } catch (NoSuchPlantSourceException e){
            throw new NoSuchPlantSourceException();
        } catch (RecipeAlreadyExists recipeAlreadyExists) {
            throw new RecipeAlreadyExists();
        }
    }
}
