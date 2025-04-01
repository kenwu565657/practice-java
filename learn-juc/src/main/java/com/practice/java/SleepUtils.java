package com.practice.java;

import java.util.concurrent.TimeUnit;

/**
 * Example in The Art of Java Concurrency Programming Second Edition Chapter 1
 *
 */
public class SleepUtils {
    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }
}
