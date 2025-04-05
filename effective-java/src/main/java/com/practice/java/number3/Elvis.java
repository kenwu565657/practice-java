package com.practice.java.number3;

/**
 * copy from effective java
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    public static Elvis getInstance() {
        return INSTANCE;
    }

    private Elvis() {}

    private Object readResolve() {
        return INSTANCE;
    }

    public void leaveTheBuilder() {

    }
}
