package com.practice.java;

/**
 * copy from Easy Coding
 *
 */
public class LazyInitDemo {
    private static Service service = null;

    // double check locking
    public Service getService() {
        if (service == null) {
            synchronized (this) {
                if (service == null) {
                    service = new Service();
                }
            }
        }
        return service;
    }


    private static class Service {}
}
