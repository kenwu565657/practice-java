package com.practice.java.learn.redis.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPacketUtils {
    public static List<Integer> divideRedPacket(Integer totalAmount, Integer totalNumber) {
        List<Integer> amountList = new ArrayList<>();
        if (totalAmount > 0 && totalNumber > 0) {
            Integer remainAmount = totalAmount;
            Integer remainNumber = totalNumber;

            Random random = new Random();

            for (int i = 0; i < totalNumber - 1; i++) {
                int amount = random.nextInt(remainAmount / remainNumber * 2 - 1) + 1;
                remainAmount -= amount;
                remainNumber--;
                amountList.add(amount);
            }
            amountList.add(remainAmount);
        }
        return amountList;
    }
}
