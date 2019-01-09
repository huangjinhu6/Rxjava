package com.imoc.rxjava;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class Scheduler {

    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

    public void schedule(){

        Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                if(!subscriber.isUnsubscribed()){
                    logger.info("call:Thread is {}",Thread.currentThread().getName());
                    subscriber.onNext("Test");
                    subscriber.onCompleted();
                }
            }
        }).observeOn(Schedulers.newThread())
        .subscribe(new Observer<String>() {
            public void onCompleted() {
                logger.info("onCompleted:Thread is {}",Thread.currentThread().getName());
            }

            public void onError(Throwable e) {
                logger.info("onError:Thread is {}",Thread.currentThread().getName());
            }

            public void onNext(String s) {
                logger.info("onNext:Thread is {}",Thread.currentThread().getName());
            }
        });


    }
}
