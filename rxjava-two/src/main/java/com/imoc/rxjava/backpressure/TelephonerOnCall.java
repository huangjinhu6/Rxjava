package com.imoc.rxjava.backpressure;

public interface TelephonerOnCall<T> {

    void call(TelephonerEmitter<T> emitter);
}
