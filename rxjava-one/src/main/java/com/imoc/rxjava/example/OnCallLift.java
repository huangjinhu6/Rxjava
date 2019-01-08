package com.imoc.rxjava.example;

/**
 * @author cody
 * @version V1.0
 * @create 2019-01-08 10:34
 */
public class OnCallLift<T,R> implements Caller.OnCall<R> {


    private final Caller.OnCall<T> parent;

    private final Caller.Operator<R,T> operator;

    public OnCallLift(Caller.OnCall<T> parent, Caller.Operator<R,T>operator){
        this.parent = parent;
        this.operator = operator;
    }

    public void call(Receiver<R> rReceiver) {
        Receiver<T> tReceiver = operator.call(rReceiver);
        parent.call(tReceiver);
    }
}
