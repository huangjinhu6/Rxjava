package com.imoc.rxjava.example;

/**
 * 接电话的人
 * @param <T>
 */
public interface Callee<T> {

    void onCall(Release release);

    void onReceive(T t);

    void onCompleted();

    void onError(Throwable e);

}
