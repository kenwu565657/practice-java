package com.practice.java.learn.redis.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedPacketUtilsTest {

    @Test
    void divideRedPacket() {
        Integer amount = 1000;
        Integer peopleNumber = 10;
        var amountList = RedPacketUtils.divideRedPacket(amount, peopleNumber);
        Assertions.assertEquals(peopleNumber, amountList.size());
        int sum = 0;
        for (int i = 0; i < amountList.size(); i++) {
            Assertions.assertTrue(amountList.get(i) >= 0);
            sum += amountList.get(i);
        }
        Assertions.assertEquals(amount, sum);
    }
}