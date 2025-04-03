package com.practice.java;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * copy from Easy Coding
 *
 */
public class UserThreadPool {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>(2);
        UserThreadFactory userThreadFactory1 = new UserThreadFactory("userThreadFactory1");
        UserThreadFactory userThreadFactory2 = new UserThreadFactory("userThreadFactory2");

        UserRejectHandler userRejectHandler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, workQueue, userThreadFactory1, userRejectHandler);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, workQueue, userThreadFactory2, userRejectHandler);

        Runnable runnable = new Task() {};
        for (int i = 0; i < 200; i++) {
            threadPoolExecutor1.execute(runnable);
            threadPoolExecutor2.execute(runnable);
        }
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " running");
        }
    }
}
