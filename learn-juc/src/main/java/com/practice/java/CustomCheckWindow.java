package com.practice.java;

import java.util.concurrent.Semaphore;

/**
 * copy from Easy Coding
 *
 */
public class CustomCheckWindow {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }
    }

    private static class SecurityCheckThread extends Thread {
        private int seq;
        private Semaphore semaphore;

        public SecurityCheckThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No. " + seq + " checking.");
                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("No. " + seq + " failed.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No. " + seq + " finished.");
            }
        }
    }
}
