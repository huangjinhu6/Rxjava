package com.imoc.rxjava;

import com.imoc.rxjava.example.Caller;
import com.imoc.rxjava.example.Calling;
import com.imoc.rxjava.example.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleTest {

    private static final Logger logger = LoggerFactory.getLogger(ExampleTest.class);

    public void self(){

        Calling call = Caller.create(new Caller.OnCall<String>() {
            public void call(Receiver<String> receiver) {
                if (!receiver.isUnCalled()){
                    logger.info("Call ...");
                    receiver.onNext("test");
                    receiver.onCompleted();
                }
            }
        }).call(new Receiver<String>() {
            public void onNext(String s) {
                logger.info("onNext ...");
                logger.info("The content is {}",s);
            }

            public void onError(Throwable e) {
                logger.info("onError ...");
            }

            public void onCompleted() {
                logger.info("onCompleted ...");
            }
        });

    }
}
