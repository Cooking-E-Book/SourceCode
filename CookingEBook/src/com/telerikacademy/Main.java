package com.telerikacademy;

import com.telerikacademy.components.BulkIngredient;
import com.telerikacademy.components.Component;
import com.telerikacademy.components.LiquidIngredient;
import com.telerikacademy.components.SolidIngredient;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchBulkMeasurementException;
import com.telerikacademy.exceptions.NoSuchMeasurementException;

public class Main {

    public static void main(String[] args) {
        Component rise, potato, milk = null;
        try{
//            bulk = new BulkIngredient( "Rise", 1.5,  158, Unit.COUNT);
//            System.out.println(bulk);
            rise = new BulkIngredient( "Rise", 1.5,  158, Unit.TEACUP);
            potato = new SolidIngredient( "Potato", 500.0,  108, Unit.GRAM);
            milk = new LiquidIngredient( "Milk", 1.0,  308, Unit.LITER);
            System.out.println(rise);
            System.out.println(potato);
            System.out.println(milk);

        } catch (NoSuchMeasurementException e){
            throw new NoSuchBulkMeasurementException();
        }

    }
}
