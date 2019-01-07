package com.imoc.rxjava;

import com.imoc.rxjava.backpressure.*;
import com.imoc.rxjava.example.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleTest {
    private static final Logger logger = LoggerFactory.getLogger(ExampleTest.class);

    public void selfNormal(){

        Caller.create(new CallerOnCall<String>() {

            public void call(CallerEmitter<String> callerEmitter) {
                if(!callerEmitter.isReleased()){
                    logger.info("call...");
                    callerEmitter.onReceice("test");
                    callerEmitter.onCompleted();
                }
            }

        }).call(new Callee<String>() {
            public void onCall(Release release) {
                logger.info("onCall...");
                release.release();
            }

            public void onReceive(String s) {
                logger.info("onReceive...");
                logger.info("The content is {}",s);
            }

            public void onCompleted() {
                logger.info("onCompleted...");
            }

            public void onError(Throwable e) {
                logger.info("onError...");
            }
        });
    }



    public void selfBackpressure(){

        Telephoner.create(new TelephonerOnCall<String>() {
            public void call(TelephonerEmitter<String> emitter) {
                if(!emitter.isDroped()){
                    logger.info("call....");
                    emitter.onReceice("test");
                    emitter.onCompleted();
                }
            }
        }).call(new Receiver<String>() {
            public void onCall(Drop drop) {
                logger.info("onCall....");
                drop.request(1L);
            }

            public void onReceive(String s) {
                logger.info("onReceive....");
                logger.info("The content is {}",s);
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
