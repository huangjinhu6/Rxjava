package com.imoc.rxjava;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public void example(){
        Subscription subscription = Observable.create(new Observable.OnSubscribe<String>() {

            public void call(Subscriber<? super String> subscriber) {
                if(!subscriber.isUnsubscribed()){
                    logger.info("subscriber something...");
                    subscriber.onNext("test");
                    subscriber.onCompleted();
                }
            }
        }).subscribe(new Observer<String>() {

            public void onCompleted() {
                logger.info("onCompleted...");
            }

            public void onError(Throwable throwable) {
                logger.error(throwable.getClass().getName());
            }

            public void onNext(String s) {
                logger.info("onNext....");
                logger.info("The content is {}",s);
            }
        });
    }
}
