package com.imoc.rxjava.backpressure;

import com.imoc.rxjava.example.Emitter;

public interface TelephonerEmitter<T> extends Emitter<T> {

    boolean isDroped();
}
