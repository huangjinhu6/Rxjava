package com.imoc.rxjava.example;

/**
 *
 * 接收信息的人
 * @param <T>
 */
public abstract class Receiver<T> implements Callee<T>,Calling{

    private volatile boolean unCalled;

    public void unCall() {
        unCalled = true;
    }

    public boolean isUnCalled() {
        return unCalled;
    }
}
