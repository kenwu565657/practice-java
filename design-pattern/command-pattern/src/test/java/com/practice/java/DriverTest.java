package com.practice.java;

import com.practice.java.cook.ChineseCook;
import com.practice.java.cuisine.ChineseCuisine;
import org.junit.Test;

public class DriverTest {

    @Test
    public void testDriver() {
        ChineseCuisine chineseCuisine = new ChineseCuisine(new ChineseCook());

        Driver driver = new Driver();
        driver.order(chineseCuisine);

        driver.placeOrder();
    }
}