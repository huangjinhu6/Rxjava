package com.imoc.rxjava;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @author cody
 * @version V1.0
 * @create 2019-01-06 21:06
 */
public class Operator {

    private static final Logger logger = LoggerFactory.getLogger(Operator.class);

    public void map(){

         Observable.create(new Observable.OnSubscribe<String>() {

            public void call(Subscriber<? super String> subscriber) {

                if(!subscriber.isUnsubscribed()){
                    logger.info("call...");
                    subscriber.onNext("1");
                    subscriber.onNext("2");
                    subscriber.onNext("3");
                    subscriber.onCompleted();
                }
            }
        }).map(new Func1<String, Integer>() {

             public Integer call(String s) {
                 return Integer.valueOf(s);
             }

         }).subscribe(new Observer<Integer>() {
             public void onCompleted() {
                 logger.info("onCompleted...");
             }

             public void onError(Throwable e) {
                 logger.info("onError...");
             }

             public void onNext(Integer integer) {
                 logger.info("onNext...");
                 logger.info("The content is {}",integer);
             }
         });
    }



}
