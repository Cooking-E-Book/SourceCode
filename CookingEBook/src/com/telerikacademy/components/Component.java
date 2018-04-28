package com.telerikacademy.components;

import com.telerikacademy.enumerations.Unit;

public interface Component {

    Integer getkCal();

    void setkCal(Integer kcal);

    String getName();

    void setName(String name);

    Unit getUnit();

    Double getQuantity();

    void setQuantity(Double quantity);

}
