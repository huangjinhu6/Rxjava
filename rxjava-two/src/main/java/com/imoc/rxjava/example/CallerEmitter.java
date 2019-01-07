package com.imoc.rxjava.example;

/**
 * 打电话人的电话
 * @param <T>
 */
public interface CallerEmitter<T> extends Emitter<T> {

    boolean isReleased();
}
