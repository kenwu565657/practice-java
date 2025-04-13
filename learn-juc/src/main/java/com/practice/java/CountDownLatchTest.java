package com.practice.java;

/**
 * copy from Easy Coding
 *
 */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * copy from Easy Coding
 *
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread thread1 = new TranslateThread("thread1", countDownLatch);
        Thread thread2 = new TranslateThread("thread2", countDownLatch);
        Thread thread3 = new TranslateThread("thread3", countDownLatch);

        thread1.start();
        thread2.start();
        thread3.start();

        countDownLatch.await(10, TimeUnit.SECONDS);
        System.out.println("finished");
    }

    private static class TranslateThread extends Thread {
        private String content;
        private final CountDownLatch countDownLatch;

        public TranslateThread(String content, CountDownLatch countDownLatch) {
            this.content = content;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            if (Math.random() > 0.5) {
                throw new RuntimeException("");
            }
            countDownLatch.countDown();
        }

    }
}
