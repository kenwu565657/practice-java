package com.practice.java;

import com.practice.java.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private List<ICuisine> cuisineList = new ArrayList<>();
    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }
    public synchronized void placeOrder() {
        for (ICuisine cuisine : cuisineList) {
            cuisine.cook();
        }
        cuisineList.clear();
    }
}