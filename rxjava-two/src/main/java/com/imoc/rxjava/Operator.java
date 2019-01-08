package com.imoc.rxjava;

import com.imoc.rxjava.example.*;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cody
 * @version V1.0
 * @create 2019-01-06 21:15
 */
public class Operator {

    private static final Logger logger = LoggerFactory.getLogger(Operator.class);

    public void normal() {

        Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    logger.info("subscribe...");
                    emitter.onNext("1");
                    emitter.onNext("2");
                    emitter.onNext("3");

                    emitter.onComplete();
                }
            }
        }).map(new Function<String, Integer>() {
            public Integer apply(String s) throws Exception {

                return Integer.valueOf(s);
            }
        }).subscribe(new Observer<Integer>() {
            public void onSubscribe(Disposable d) {
                logger.info("onSubscribe...");
            }

            public void onNext(Integer integer) {
                logger.info("onNext...");
                logger.info("The content is {}", integer);
            }

            public void onError(Throwable e) {
                logger.info("onError...");
            }

            public void onComplete() {
                logger.info("onComplete...");
            }
        });
    }


    public void backPressure() {

        Flowable.create(new FlowableOnSubscribe<String>() {
            public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                if (!emitter.isCancelled()) {
                    logger.info("subscribe...");
                    emitter.onNext("4");
                    emitter.onNext("5");
                    emitter.onNext("6");

                    emitter.onComplete();
                }
            }
        }, BackpressureStrategy.DROP)
        .map(new Function<String, Integer>() {
            public Integer apply(String s) throws Exception {

                return Integer.valueOf(s);
            }
        }).subscribe(new Subscriber<Integer>() {
            public void onSubscribe(Subscription subscription) {
                logger.info("onSubscribe...");

                subscription.request(Integer.MAX_VALUE);
            }

            public void onNext(Integer integer) {
                logger.info("onNext...");
                logger.info("The content is {}",integer);
            }

            public void onError(Throwable throwable) {
                logger.info("onError...");
            }

            public void onComplete() {
                logger.info("onComplete...");
            }
        });
    }

}
