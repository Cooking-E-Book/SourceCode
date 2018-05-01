package com.telerikacademy.components.liquid;

import com.telerikacademy.components.solid.SolidIngredient;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.source.NoSuchMineralSourceException;

public class MineralLiquidIngredient extends LiquidIngredient {

    private MineralSource mineralSource;

    public MineralLiquidIngredient(String name, Double quantity, Integer kcal, Unit unit, MineralSource mineralSource) {
        super( name, quantity, kcal, unit );
        this.setSource( mineralSource );
    }

    private void setSource(MineralSource mineralSource) {
        if (!mineralSource.equals(MineralSource.WATER)) {
            throw new NoSuchMineralSourceException("Source", "Water");
        }
        this.mineralSource = mineralSource;
    }

    @Override
    public String getSource() {
        return this.mineralSource.toString();
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format( "%s%n", this.getSource() ));
    }

}
