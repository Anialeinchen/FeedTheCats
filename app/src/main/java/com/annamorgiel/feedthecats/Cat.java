package com.annamorgiel.feedthecats;

/**
 * Created by Anna Morgiel on 13.07.2017.
 */

public class Cat {

    int catWeight;
    int foodAmount;
    String name;
    String foodName;
    boolean newFood;

    public Cat(int catWeight, int foodAmount, String name, String foodName) {
        this.catWeight = catWeight;
        this.foodAmount = foodAmount;
        this.name = name;
        this.foodName = foodName;
        this.newFood = false;
    }

    public Cat(String name) {
        this.name = name;
        newFood = false;
    }
}
