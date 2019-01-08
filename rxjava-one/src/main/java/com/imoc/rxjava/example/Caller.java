package com.imoc.rxjava.example;

import rx.functions.Action1;
import rx.functions.Func1;

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


    public interface Operator<R,T> extends Func1<Receiver<R>,Receiver<T>>{

    }

    public final <R> Caller<R> lift(Operator<R,T> operator){
        return create(new OnCallLift<T,R>(onCall,operator));
    }

    public final <R> Caller<R> map(Func1<T,R> func){
        return lift(new MapOperator<T,R>(func));
    }
}
