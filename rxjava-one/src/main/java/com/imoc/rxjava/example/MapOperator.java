package com.imoc.rxjava.example;

import rx.functions.Func1;

/**
 * @author cody
 * @version V1.0
 * @create 2019-01-08 10:46
 */
public class MapOperator<T,R> implements Caller.Operator<R,T> {

    private final Func1<T,R> mapper;

    public MapOperator(Func1<T,R> mapper){
        this.mapper = mapper;
    }

    public Receiver<T> call(Receiver<R> tReceiver) {
        return new MapReceiver<T,R>(tReceiver,this.mapper);
    }
}
