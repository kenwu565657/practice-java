package com.practice.java.art.ch1;

import java.util.concurrent.TimeUnit;

/**
 * Copy from The Art of Java Concurrency Programming Second Edition
 *
 */
public class ThreadLocalExample {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        ThreadLocalExample.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + ThreadLocalExample.end() + " mills");
    }
}
