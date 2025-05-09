package com.practice.java.art.ch1;

import java.util.concurrent.TimeUnit;

/**
 * Copy from The Art of Java Concurrency Programming Second Edition
 *
 */
public class ThreadJoinExample {
    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;
        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
