package com.imoc.rxjava;

import com.imoc.rxjava.example.Caller;
import com.imoc.rxjava.example.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.functions.Func1;

public class SelfOperator {

    private static final Logger logger = LoggerFactory.getLogger(SelfOperator.class);

    public void map(){
        Caller.create(new Caller.OnCall<String>(){
            public void call(Receiver<String> receiver) {
                if(!receiver.isUnCalled()){
                    logger.info("call....");
                    receiver.onNext("1");
                    receiver.onCompleted();
                }
            }
        }).map(new Func1<String, Integer>() {
            public Integer call(String s) {
                return Integer.parseInt(s);
            }
        }).call(new Receiver<Integer>() {
            public void onNext(Integer integer) {
                logger.info("onNext....");
                logger.info("The content is {}",integer);
            }

            public void onError(Throwable e) {
                logger.info("onError....");
            }

            public void onCompleted() {
                logger.info("onCompleted....");
            }
        });
    }
}
