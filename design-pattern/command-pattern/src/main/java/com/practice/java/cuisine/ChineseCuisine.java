package com.practice.java.cuisine;

import com.practice.java.cook.ICook;

public class ChineseCuisine implements ICuisine {
    private ICook cook;
    public ChineseCuisine(ICook cook) {
        this.cook = cook;
    }
    public void cook() {
        cook.doCooking();
    }
}
