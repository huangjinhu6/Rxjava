package com.imoc.rxjava.backpressure;

import java.util.concurrent.atomic.AtomicLong;

public class TelephonerCreate<T> extends Telephoner<T> {

    final TelephonerOnCall<T> telephonerOnCall;

    public TelephonerCreate(TelephonerOnCall<T> telephonerOnCall){
        this.telephonerOnCall = telephonerOnCall;
    }

    protected void callActual(Receiver<T> receiver) {
        DropEmitter<T> tDropEmitter = new DropEmitter<T>(receiver);
        receiver.onCall(tDropEmitter);
        telephonerOnCall.call(tDropEmitter);
    }


    private static class DropEmitter<T> extends AtomicLong implements TelephonerEmitter<T>,Drop{

        private Receiver<T> receiver;

        private volatile boolean mIsDropped;

        public DropEmitter(Receiver<T> receiver){
            this.receiver = receiver;
        }

        public void request(long n) {
            BackpressureHelper.add(this,n);
        }

        public void drop() {
            mIsDropped = true;
        }

        public void onError(Throwable e) {
            receiver.onError(e);
        }

        public void onReceice(T t) {
            if(get() != 0){
                receiver.onReceive(t);
                BackpressureHelper.produced(this,1);
            }
        }

        public void onCompleted() {
            receiver.onCompleted();
        }

        public boolean isDroped() {
            return mIsDropped;
        }
    }
}
