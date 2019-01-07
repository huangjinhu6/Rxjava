package com.imoc.rxjava.example;

/**
 * 用于发射数据
 * @param <T>
 */
public interface Emitter<T> {

    void onError(Throwable e);

    void onReceice(T t);

    void onCompleted();

}
