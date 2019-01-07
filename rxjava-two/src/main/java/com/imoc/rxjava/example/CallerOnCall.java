package com.imoc.rxjava.example;

/**
 * 当打电话的时候
 * @param <T>
 */
public interface CallerOnCall<T> {

    void call(CallerEmitter<T> callerEmitter);
}
