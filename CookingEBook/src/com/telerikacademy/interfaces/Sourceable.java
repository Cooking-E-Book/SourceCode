package com.telerikacademy.interfaces;

public interface Sourceable {

     enum AnimalSource{
        MAMMALS, BIRDS, REPTILES, AMPHIBIANS, FISH
    }
     enum MineralSource {
        SALТ, SODA, WATER
    }

     enum PlantSource {
        GRAIN, ROOT_VEGETABLE, LEAF_VEGETABLE, FRUIT
    }

    enum MushroomSource {
        WILD, CULTIVATED
    }

    String getSource();
}