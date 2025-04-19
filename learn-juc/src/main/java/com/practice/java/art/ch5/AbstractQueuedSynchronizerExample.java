package com.practice.java.art.ch5;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AbstractQueuedSynchronizerExample {

    static class AbstractQueuedSynchronizerMethod extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            return false;
        }
    }
}
