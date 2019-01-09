package com.imoc.rxjava.example;

public class CallerLift<R,T> extends CallerWithUpstream<T,R>{

    private final CallerOperator<R,T> callerOperator;

    public CallerLift(Caller<T> source,CallerOperator<R,T> callerOperator) {
        super(source);
        this.callerOperator = callerOperator;
    }

    protected void callActual(Callee<R> callee) {
        Callee<T> tCallee = callerOperator.call(callee);
        source.call(tCallee);
    }
}
