package com.imoc.rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleOne {

    private static final Logger logger = LoggerFactory.getLogger(ExampleOne.class);

    /**
     * 无背压方式
     */
    public void normal(){

        Observable.create(new ObservableOnSubscribe<String>() {

            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                if(!observableEmitter.isDisposed()){
                    logger.info("ObservableOnSubscribe subscribe ...");

                    observableEmitter.onNext("test");
                    observableEmitter.onComplete();
                }

            }
        }).subscribe(new Observer<String>() {
            public void onSubscribe(Disposable disposable) {
                logger.info("onSubscribe...");
            }

            public void onNext(String s) {
                logger.info("onReceive...");
                logger.info("The content is {}",s);
            }

            public void onError(Throwable throwable) {
                logger.info("onError...");
                logger.error(throwable.getClass().getName());
            }

            public void onComplete() {
                logger.info("onComplete...");
            }
        });
    }


    /**
     * 有背压方式
     */
    public void flowable(){
        Flowable.create(new FlowableOnSubscribe<String>() {

            public void subscribe(FlowableEmitter<String> flowableEmitter) throws Exception {
                if(!flowableEmitter.isCancelled()){
                    logger.info("FlowableOnSubscribe subscribe...");
                    flowableEmitter.onNext("test");
                    flowableEmitter.onComplete();
                }
            }
        },BackpressureStrategy.DROP).subscribe(new Subscriber<String>() {
            public void onSubscribe(Subscription subscription) {
                logger.info("onSubscribe...");
                //响应式拉取，如果没有此代码。则不会调用响应
                subscription.request(Long.MAX_VALUE);
            }

            public void onNext(String s) {
                logger.info("onReceive...");
                logger.info("The content is {}",s);
            }

            public void onError(Throwable throwable) {
                logger.info("onError...");
                logger.error(throwable.getClass().getName());
            }

            public void onComplete() {
                logger.info("onComplete...");
            }
        });
    }
}
