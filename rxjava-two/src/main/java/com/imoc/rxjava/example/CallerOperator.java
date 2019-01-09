package com.imoc.rxjava.example;

public interface CallerOperator<T,R> {

    Callee<R> call(Callee<T> callee);
}
