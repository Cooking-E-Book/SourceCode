package com.telerikacademy.app;

import com.telerikacademy.Global;
import com.telerikacademy.components.bulk.MineralBulkIngredient;
import com.telerikacademy.components.bulk.PlantBulkIngredient;
import com.telerikacademy.components.liquid.AnimalLiquidIngredient;
import com.telerikacademy.components.liquid.MineralLiquidIngredient;
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
import com.telerikacademy.exceptions.source.NoSuchAnimalSourceException;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;
import com.telerikacademy.interfaces.Component;
import com.telerikacademy.interfaces.Sourceable;

import java.util.HashMap;

public class RecipeCreator {
    private  HashMap<Integer, Recipe> recipesByRecipeId = new HashMap<>(  );
    private StringBuilder output = new StringBuilder(  );

    private void updateConstants(){
        Global.INGREDIENT_ID = Global.DEFAULT_VALUE;
        Global.STEP_ID = Global.DEFAULT_VALUE;;
        Global.UTENSIL_ID = Global.DEFAULT_VALUE;;
    }

    public String createGajarHalwa() throws RecipeAlreadyExists {
        Component sugar, potato, milk, ghee, mavaCrumbled, almonds = null;
        try{
            this.updateConstants();
            Recipe gajar_halwa = new Recipe("Gajar Halwa (Carrot Pudding)", "Serves: 12\t Pressure Cooking Time 40 minute, in 5 Litre pressure cooker");
            sugar = new PlantBulkIngredient( "Sugar", 2.0,  158, Unit.TEACUP, Sourceable.PlantSource.FRUIT);
            String sugarAmount = "" + sugar.getQuantity() + sugar.getUnit().toString();
            gajar_halwa.addIngredient( sugarAmount, sugar );

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
            gajar_halwa.addStep( firstStep );
            gajar_halwa.addStep( secondStep );
            gajar_halwa.addStep( thirdStep );
            gajar_halwa.addStep( fourthStep );
            output.append( gajar_halwa ).append( htd );
             //System.out.println(gajar_halwa);
             //System.out.println(htd);
            return output.toString();

        } catch (NoSuchMeasurementException e){
            throw new NoSuchBulkMeasurementException();
        } catch (NoSuchPlantSourceException e){
            throw new NoSuchPlantSourceException();
        } catch (NoSuchAnimalSourceException e){
            throw new NoSuchAnimalSourceException();
        } catch (RecipeAlreadyExists recipeAlreadyExists) {
            throw new RecipeAlreadyExists();
        }
    }

    public String createBasmatiRice() throws RecipeAlreadyExists {
        Component rice, water, salt = null;
        try{
            this.updateConstants();
            Recipe basmati_rice = new Recipe("Basmati Rice", "Serves: 9\t Pressure Cooking Time 15 minute, in 5 Litre pressure cooker");
            rice = new PlantBulkIngredient( "Basmati rice washed", 3.0,  178, Unit.TEACUP, Sourceable.PlantSource.GRAIN);
            String riceAmount = "" + rice.getQuantity() + rice.getUnit().toString();
            basmati_rice.addIngredient( riceAmount, rice );
            salt = new MineralBulkIngredient( "Salt", 1.5, 24, Unit.TEASPOON, Sourceable.MineralSource.SALТ);
            String saltAmount = "" + salt.getQuantity() + salt.getUnit().toString();
            basmati_rice.addIngredient( saltAmount, salt );
            water = new MineralLiquidIngredient( "Water", 3.0, 14, Unit.TEACUP, Sourceable.MineralSource.WATER);
            String waterAmount = "" + water.getQuantity() + water.getUnit().toString();
            basmati_rice.addIngredient( waterAmount, water );
            if (recipesByRecipeId.containsKey( basmati_rice.getId() )) {
                throw new RecipeAlreadyExists();
            } else {
                recipesByRecipeId.put( basmati_rice.getId(), basmati_rice );
            }

            Utensil pressureCooker = new Utensil( "Pressure cooker", "5 Litre, from stainless steel" );
            Utensil ladle = new Utensil( "Ladle" , "Wood ladle");
            System.out.println(pressureCooker);
            Step firstStep = new Step( "Pour water into cooker. Bring to boil on high heat. Add salt and rice. Stir\n", 2.0 );
            Step secondStep = new Step( "Close cooker. Bring to full pressure on high heat. Reduce heat and cook for 3 minutes.\n", 3.0 );
            Step thirdStep = new Step( "Remove cooker from heat. Allow to cool naturally for 5 minutes. Press finger-tip control/lift vent weight lightly to release pressure.\n\n", 5.0 );
            Step fourthStep = new Step( "Open cooker. Fluff up rice gently with a fork to separate grains.\n", 1.0 );
            HeatTreatedDish htd = new HeatTreatedDish(DishCategory.MAIN_COURSE,  basmati_rice, 100, HeatTreatedDish.HeatTreatType.BOILING);
            firstStep.add(pressureCooker);
            firstStep.add(ladle);
            secondStep.add(pressureCooker);
            thirdStep.add(pressureCooker);
            fourthStep.add(pressureCooker);
            basmati_rice.addStep( firstStep );
            basmati_rice.addStep( secondStep );
            basmati_rice.addStep( thirdStep );
            basmati_rice.addStep( fourthStep );
            output.append( basmati_rice ).append( htd );
            //System.out.println(basmati_rice);
            //System.out.println(htd);
            return output.toString();

        } catch (NoSuchMeasurementException e){
            throw new NoSuchBulkMeasurementException();
        } catch (NoSuchPlantSourceException e){
            throw new NoSuchPlantSourceException();
        } catch (NoSuchAnimalSourceException e){
            throw new NoSuchAnimalSourceException();
        } catch (RecipeAlreadyExists recipeAlreadyExists) {
            throw new RecipeAlreadyExists();
        }
    }
}
