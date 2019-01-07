package com.imoc.rxjava.example;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 实际打电话的人
 * @param <T>
 */
public class CallerCreate<T> extends Caller<T> {

    final CallerOnCall<T> callerOnCall;

    public CallerCreate(CallerOnCall<T> callerOnCall){
        this.callerOnCall = callerOnCall;
    }


    protected void callActual(Callee<T> callee) {
        CreateEmitter<T> createEmitter = new CreateEmitter<T>(callee);
        callee.onCall(createEmitter);
        callerOnCall.call(createEmitter);
    }


    public class CreateEmitter<T> extends AtomicReference<Release> implements Release,CallerEmitter<T>{


        final Callee<T> callee;

        public CreateEmitter(Callee<T> callee){
            this.callee = callee;
        }

        public void onError(Throwable e) {
            if(!isReleased()){
                callee.onError(e);
            }
        }

        public void onReceice(T t) {
            if(!isReleased()){
                callee.onReceive(t);
            }
        }

        public void onCompleted() {
            if(!isReleased()){
                callee.onCompleted();
            }
        }

        public boolean isReleased() {
            return ReleaseHelper.isRelease(get());
        }

        public void release() {
            ReleaseHelper.release(this);
        }
    }
}
