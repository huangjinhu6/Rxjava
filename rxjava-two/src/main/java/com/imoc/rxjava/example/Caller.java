package com.imoc.rxjava.example;

import io.reactivex.functions.Function;

/**
 * 打电话的人
 * @param <T>
 */
public abstract class Caller<T> {

    public static <T> Caller<T> create(CallerOnCall<T> callerOnCall){
        return new CallerCreate<T>(callerOnCall);
    }


    public void call(Callee<T> callee){
        callActual(callee);
    }

    protected abstract void callActual(Callee<T> callee);

    public <R> Caller<R> map(Function<T,R> function){
        return new CallerMap<T,R>(this,function);
    }

    public <R> Caller<R> lift(CallerOperator<R,T> operator){
        return new CallerLift<R,T>(this,operator);
    }

}
