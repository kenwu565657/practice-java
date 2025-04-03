package com.practice.java;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * copy from Easy Coding
 *
 */
public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public UserThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + "-" + threadNumber.getAndIncrement();
        Thread thread = new Thread(null, r, name, 0, false);
        return thread;
    }
}
