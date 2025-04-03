package com.practice.java;

/**
 * copy from Easy Coding
 *
 */
public class VolatileNotAtomic {
    private static volatile long count = 0L;
    private static final int number = 10000;

    public static void main(String[] args) {
        Thread subtractThread = new SubtractThread();
        subtractThread.start();
        for (int i = 0; i < number; i++) {
            count++;
        }

        while (subtractThread.isAlive()) {}
        System.out.println(count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < number; i++) {
                count--;
            }
        }
    }
}
