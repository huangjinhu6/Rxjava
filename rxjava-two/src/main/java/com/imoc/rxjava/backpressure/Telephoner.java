package com.imoc.rxjava.backpressure;

public abstract class Telephoner<T> {

    public static <T> Telephoner<T> create(TelephonerOnCall<T> telephonerOnCall){
        return new TelephonerCreate<T>(telephonerOnCall);
    }

    public void call(Receiver<T> receiver){
        callActual(receiver);
    }


    protected abstract void callActual(Receiver<T> receiver);

}
