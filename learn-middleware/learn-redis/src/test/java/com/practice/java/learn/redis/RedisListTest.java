package com.practice.java.learn.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RedisListTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisListTest.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, 21, "person1"));
        list.add(new Person(2, 21, "person2"));
        list.add(new Person(3, 21, "person3"));
        final String key = "list";
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        for (Person person : list) {
            listOperations.leftPush(key, person);
        }

        Object value = listOperations.rightPop(key);
        Person person;
        while (value != null) {
            person = (Person) value;
            LOGGER.info(person.toString());
            value = listOperations.rightPop(key);
        }
    }

    @Data
    @ToString
    @AllArgsConstructor
    private static class Person implements Serializable {
        private Integer id;
        private Integer age;
        private String name;
    }
}
