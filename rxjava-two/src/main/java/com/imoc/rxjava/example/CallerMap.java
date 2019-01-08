package com.imoc.rxjava.example;

import io.reactivex.functions.Function;

public class CallerMap<T,U> extends CallerWithUpstream<T,U> {

    private final Function<T,U> function;

    public CallerMap(Caller<T> source,Function<T,U> function) {
        super(source);
        this.function = function;
    }

    protected void callActual(Callee<U> callee) {
        source.call(new MapCallee<T,U>(callee,function));
    }
}
