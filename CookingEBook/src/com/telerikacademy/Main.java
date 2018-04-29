package com.telerikacademy;

import com.telerikacademy.components.BulkIngredient;
import com.telerikacademy.components.Component;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.NoSuchBulkMeasurementException;
import com.telerikacademy.exceptions.NoSuchMeasurementException;

public class Main {

    public static void main(String[] args) {
        Component bulk = null;
        try{
//            bulk = new BulkIngredient( "Rise", 1.5,  158, Unit.COUNT);
//            System.out.println(bulk);
            bulk = new BulkIngredient( "Rise", 1.5,  158, Unit.TEACUP);
            System.out.println(bulk);

        } catch (NoSuchMeasurementException e){
            throw new NoSuchBulkMeasurementException();
        }

    }
}
