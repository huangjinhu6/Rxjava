package com.imoc.rxjava.backpressure;

public interface Receiver<T> {

    void onCall(Drop drop);

    void onReceive(T t);

    void onError(Throwable e);

    void onCompleted();

}
