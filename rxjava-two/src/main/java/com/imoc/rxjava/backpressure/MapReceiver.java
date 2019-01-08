package com.imoc.rxjava.backpressure;

import io.reactivex.functions.Function;

public class MapReceiver<T,R> implements Receiver<T> {

    private final Receiver<R>  receiver;

    private final Function<T,R> function;

    public MapReceiver(Receiver<R> receiver,Function<T,R> function){
        this.receiver = receiver;
        this.function = function;
    }

    public void onCall(Drop drop) {
        receiver.onCall(drop);
    }

    public void onReceive(T t) {

        try {
            R apply = function.apply(t);
            receiver.onReceive(apply);

        } catch (Exception e) {

        }
    }

    public void onError(Throwable e) {
        receiver.onError(e);
    }

    public void onCompleted() {
        receiver.onCompleted();
    }
}
