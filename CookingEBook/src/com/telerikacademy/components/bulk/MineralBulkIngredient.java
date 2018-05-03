package com.telerikacademy.components.bulk;

import com.telerikacademy.components.solid.SolidIngredient;
import com.telerikacademy.enumerations.Unit;
import com.telerikacademy.exceptions.source.NoSuchMineralSourceException;
import com.telerikacademy.exceptions.source.NoSuchPlantSourceException;

public class MineralBulkIngredient extends BulkIngredient {

    private MineralSource mineralSource;

    public MineralBulkIngredient(String name, Double quantity, Integer kcal, Unit unit, MineralSource mineralSource) {
        super( name, quantity, kcal, unit );
        this.setSource( mineralSource );
    }

    private void setSource(MineralSource mineralSource) {
        if (!(mineralSource.equals(MineralSource.SALТ) || mineralSource.equals(MineralSource.SODA))) {
            throw new NoSuchMineralSourceException("Minerals");
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
