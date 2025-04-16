package com.practice.java.art.ch1;

import com.practice.java.art.SleepUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Copy from The Art of Java Concurrency Programming Second Edition
 *
 */
public class DeprecatedExample {
    public static void main(String[] args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);

        printThread.suspend();
        System.out.println("main suspend PrintThread at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        printThread.resume();
        System.out.println("main resume PrintThread at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        printThread.stop();
        System.out.println("main stop PrintThread at " + dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Run at " + dateFormat.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
