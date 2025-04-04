package com.practice.java;

import java.util.ArrayList;
import java.util.List;

/**
 * copy from easy coding
 */
public class ForEachExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("2".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
