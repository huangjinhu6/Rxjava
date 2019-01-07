package com.imoc.rxjava.example;

/**
 *
 * 接 电话的人
 */
public interface Callee<T> {

    void onNext(T t);

    void onError(Throwable e);

     void onCompleted();
}
