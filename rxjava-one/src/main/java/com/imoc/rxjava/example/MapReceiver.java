package com.imoc.rxjava.example;

import rx.functions.Func1;

/**
 * @author cody
 * @version V1.0
 * @create 2019-01-08 10:49
 */
public class MapReceiver<T,R> extends Receiver<T> {

    private final Receiver<R> actual;

    private final Func1<T,R> mapper;

    public MapReceiver(Receiver<R> actual,Func1<T,R> mapper){
        this.actual = actual;
        this.mapper = mapper;
    }

    public void onNext(T t) {
        R r = mapper.call(t);
        actual.onNext(r);
    }

    public void onError(Throwable e) {
        actual.onError(e);
    }

    public void onCompleted() {
        actual.onCompleted();
    }
}
