package com.practice.java.learn.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class RedisSortedSetTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSortedSetTest.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        List<PhoneUser> list = new ArrayList<>();
        list.add(new PhoneUser("101", 111.0));
        list.add(new PhoneUser("111", 113.0));

        final String key = "key";
        redisTemplate.delete(key);

        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        for (PhoneUser phoneUser : list) {
            zSetOperations.add(key, phoneUser, phoneUser.getFare());
        }
        Long size = zSetOperations.size(key);
        Set<Object> sortedSet = zSetOperations.reverseRange(key, 0L, size);
    }

    @Data
    @ToString
    @AllArgsConstructor
    private static class PhoneUser implements Serializable {
        private String phone;
        private Double fare;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PhoneUser phoneUser = (PhoneUser) o;
            return phone != null ? phone.equals(phoneUser.phone) : phoneUser.phone == null;
        }

        @Override
        public int hashCode() {
            return phone != null ? phone.hashCode() : 0;
        }
    }
}
