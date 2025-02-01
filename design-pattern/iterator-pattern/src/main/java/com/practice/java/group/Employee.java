package com.practice.java.group;

import java.text.MessageFormat;

public class Employee {
    private String uid;
    private String name;

    public Employee(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Employee Id: {0} Name: {1}.", uid, name);
    }
}
