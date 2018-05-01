package com.telerikacademy;

import com.telerikacademy.components.bulk.PlantBulkIngredient;
import com.telerikacademy.components.liquid.AnimalLiquidIngredient;
import com.telerikacademy.components.solid.PlantSolidIngredient;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.measurement.NoSuchBulkMeasurementException;
import com.telerikacademy.exceptions.measurement.NoSuchMeasurementException;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;
import com.telerikacademy.interfaces.Component;
import com.telerikacademy.interfaces.Sourceable;
import com.telerikacademy.io.RecipeBox;

public class Main {

    public static void main(String[] args) {
        //RecipeBox box = new RecipeBox();
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

    }
}
