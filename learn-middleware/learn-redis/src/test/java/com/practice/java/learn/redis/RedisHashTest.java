package com.practice.java.learn.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class RedisHashTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisHashTest.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        List<Student> studentList = new ArrayList<>();
        List<Fruit> fruitList = new ArrayList<>();

        studentList.add(new Student("1", "student1", "studentName1"));
        studentList.add(new Student("2", "student2", "studentName2"));
        studentList.add(new Student("3", "student3", "studentName3"));

        fruitList.add(new Fruit("apple", "red"));
        fruitList.add(new Fruit("orange", "orange"));
        fruitList.add(new Fruit("banana", "yellow"));

        String studentKey = "key1";
        String fruitKey = "key2";

        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();

        for (Student student : studentList) {
            hashOperations.put(studentKey, student.getId(), student);
        }
        for (Fruit fruit : fruitList) {
            hashOperations.put(fruitKey, fruit.getName(), fruit);
        }
        Map<String, Object> studentMap = hashOperations.entries(studentKey);

        Student student = (Student) hashOperations.get(studentKey, "student1");
    }

    @Data
    @ToString
    @AllArgsConstructor
    private static class Student implements Serializable {
        private String id;
        private String name;
        private String userName;
    }

    @Data
    @ToString
    @AllArgsConstructor
    private static class Fruit implements Serializable {
        private String name;
        private String color;
    }
}
