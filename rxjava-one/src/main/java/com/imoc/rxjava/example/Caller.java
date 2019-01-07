package com.imoc.rxjava.example;

import rx.functions.Action1;

/**
 *
 * 打电话的人
 */
public class Caller<T> {

    final OnCall<T> onCall;

    public Caller(OnCall<T> onCall){
        this.onCall = onCall;
    }


    public static <T> Caller<T> create(OnCall<T> onCall){
        return new Caller<T>(onCall);
    }


    public Calling call(Receiver<T> receiver){
        this.onCall.call(receiver);
        return receiver;
    }


    public interface OnCall<T> extends Action1<Receiver<T>>{

    }
}
