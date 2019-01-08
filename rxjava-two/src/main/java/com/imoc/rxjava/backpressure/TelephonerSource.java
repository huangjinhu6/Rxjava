package com.imoc.rxjava.backpressure;

public interface TelephonerSource<T> {

    Telephoner<T> source();
}
