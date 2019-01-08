package com.imoc.rxjava.backpressure;


import io.reactivex.functions.Function;

public class TelephonerMap<T,R> extends TelephonerWithUpstream<T,R> {

    private final Function<T,R> function;

    public TelephonerMap(Telephoner<T> source,Function<T,R> function) {
        super(source);
        this.function = function;
    }

    protected void callActual(Receiver<R> receiver) {
        source.call(new MapReceiver<T,R>(receiver,function));
    }
}
