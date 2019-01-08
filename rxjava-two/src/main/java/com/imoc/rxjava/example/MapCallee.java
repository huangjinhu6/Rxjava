package com.imoc.rxjava.example;

import io.reactivex.functions.Function;

public class MapCallee<T,R> implements Callee<T> {

    private final Callee<R> oCallee;

    private final Function<T,R> function;

    public MapCallee(Callee<R> oCallee,Function<T,R> function){
        this.oCallee = oCallee;
        this.function = function;
    }

    public void onCall(Release release) {
        oCallee.onCall(release);
    }

    public void onReceive(T t) {
        try {
            R apply = function.apply(t);
            oCallee.onReceive(apply);
        } catch (Exception e) {

        }
    }

    public void onCompleted() {
        oCallee.onCompleted();
    }

    public void onError(Throwable e) {
        oCallee.onError(e);
    }
}
