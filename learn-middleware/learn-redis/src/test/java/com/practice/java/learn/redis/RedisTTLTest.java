package com.practice.java.learn.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTTLTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisTTLTest.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testTTL() throws InterruptedException {
        final String key = "key";
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, "value", 10L, TimeUnit.SECONDS);
        Thread.sleep(5000);
        Boolean isExist = redisTemplate.hasKey(key);
        Object value = valueOperations.get(key);
        Assertions.assertTrue(isExist);
        Assertions.assertEquals("value", value);

        Thread.sleep(5000);
        isExist = redisTemplate.hasKey(key);
        value = valueOperations.get(key);
        Assertions.assertFalse(isExist);
        Assertions.assertNull(value);
    }

    @Test
    public void testExpired() throws InterruptedException {
        String key = "key";
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, "value");
        redisTemplate.expire(key, 10L, TimeUnit.SECONDS);
        Thread.sleep(5000);
        Boolean isExist = redisTemplate.hasKey(key);
        Object value = valueOperations.get(key);
        Assertions.assertTrue(isExist);
        Assertions.assertEquals("value", value);

        Thread.sleep(5000);
        isExist = redisTemplate.hasKey(key);
        value = valueOperations.get(key);
        Assertions.assertFalse(isExist);
        Assertions.assertNull(value);
    }
}
