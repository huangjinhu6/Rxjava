package com.imoc.rxjava.backpressure;

public abstract class TelephonerWithUpstream<T,R> extends Telephoner<R> implements TelephonerSource<T> {

    protected final Telephoner<T> source;

    public TelephonerWithUpstream(Telephoner<T> source){
        this.source = source;
    }

    public Telephoner<T> source() {
        return source;
    }
}
