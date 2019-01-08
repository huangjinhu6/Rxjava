package com.imoc.rxjava.example;

public abstract class CallerWithUpstream<T,U> extends Caller<U> implements CallerSource<T>{

    protected final Caller<T> source;

    public CallerWithUpstream(Caller<T> source){
        this.source = source;
    }

    public Caller<T> source() {
        return source;
    }
}
