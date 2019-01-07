package com.imoc.rxjava.example;

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

}
