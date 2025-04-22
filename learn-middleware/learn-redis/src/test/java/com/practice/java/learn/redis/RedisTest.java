package com.practice.java.learn.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testString() {
        final String content = "hello world";
        final String key = "redis:template:one:string";

        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, content);
        Object value = valueOperations.get(key);
        LOGGER.info("value:{}", value);
    }

    @Test
    public void testJson() throws JsonProcessingException {
        User user = new User(1, "user1", "userName1");
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        String key = "key";
        String content = objectMapper.writeValueAsString(user);
        valueOperations.set(key, content);
        Object value = valueOperations.get(key);
        User user1 = objectMapper.readValue(value.toString(), User.class);
        LOGGER.info("user1:{}", user1);
    }

    @Data
    @ToString
    @AllArgsConstructor
    private static class User {
        private Integer id;
        private String name;
        private String userName;
    }
}
