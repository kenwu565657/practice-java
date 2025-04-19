package com.practice.java.art.ch5;

import com.practice.java.art.SleepUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Copy from The Art of Java Concurrency Programming Second Edition
 *
 */
public class TwinsLockTest {

    @Test
    public void test() {
        final Lock lock = new TwinsLockExample();

        class Worker extends Thread {

            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
