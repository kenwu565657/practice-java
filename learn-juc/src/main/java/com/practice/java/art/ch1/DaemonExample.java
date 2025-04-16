package com.practice.java.art.ch1;

import com.practice.java.art.SleepUtils;

/**
 * Copy from The Art of Java Concurrency Programming Second Edition
 *
 */
public class DaemonExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run");
            }
        }
    }
}
