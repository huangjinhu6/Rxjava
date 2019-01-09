package com.imoc.rxjava;

import com.imoc.rxjava.backpressure.*;
import com.imoc.rxjava.example.*;
import io.reactivex.functions.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelfOperator {

    private static final Logger logger = LoggerFactory.getLogger(SelfOperator.class);

    public void normal(){

        Caller.create(new CallerOnCall<String>() {
            public void call(CallerEmitter<String> callerEmitter) {
                if(!callerEmitter.isReleased()){
                    logger.info("call...");
                    callerEmitter.onReceice("11");
                    callerEmitter.onReceice("12");
                    callerEmitter.onReceice("13");
                    callerEmitter.onCompleted();
                }
            }
        }).map(new Function<String, Integer>() {
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        }).call(new Callee<Integer>() {
            public void onCall(Release release) {
                logger.info("onCall...");
            }

            public void onReceive(Integer integer) {
                logger.info("onReceive...");
                logger.info("The content is {}",integer);
            }

            public void onCompleted() {
                logger.info("onCompleted...");
            }

            public void onError(Throwable e) {
                logger.info("onError...");
            }
        });
    }


    public void backPressure(){

        Telephoner.create(new TelephonerOnCall<String>() {
            public void call(TelephonerEmitter<String> emitter) {
                if(!emitter.isDroped()){
                    logger.info("call...");
                    emitter.onReceice("21");
                    emitter.onReceice("22");
                    emitter.onReceice("23");
                    emitter.onCompleted();
                }
            }
        }).map(new Function<String, Integer>() {
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        }).call(new Receiver<Integer>() {
            public void onCall(Drop drop) {
                logger.info("onCall...");
//                drop.request(Long.MAX_VALUE);
            }

            public void onReceive(Integer integer) {
                logger.info("onReceive...");
                logger.info("The content is {}",integer);
            }

            public void onError(Throwable e) {
                logger.info("onError...");
            }

            public void onCompleted() {
                logger.info("onCompleted...");
            }
        });
    }

    public void lift(){

        Caller.create(new CallerOnCall<String>() {
            public void call(CallerEmitter<String> callerEmitter) {
                if(!callerEmitter.isReleased()){
                    logger.info("call...");
                    callerEmitter.onReceice("31");
                    callerEmitter.onReceice("32");
                    callerEmitter.onReceice("33");
                    callerEmitter.onCompleted();
                }
            }
        }).lift(new CallerOperator<Integer, String>() {
            public Callee<String> call(final Callee<Integer> callee) {
                return new Callee<String>() {
                    public void onCall(Release release) {
                        logger.info("operator onCall...");
                        callee.onCall(release);
                    }

                    public void onReceive(String s) {
                        logger.info("operator onReceive...");
                        logger.info("String is {}",s);
                        int parseInt = Integer.parseInt(s);
                        callee.onReceive(parseInt);
                    }

                    public void onCompleted() {
                        logger.info("operator onCompleted...");
                        callee.onCompleted();
                    }

                    public void onError(Throwable e) {
                        logger.info("operator onError...");
                        callee.onError(e);
                    }
                };
            }
        }).call(new Callee<Integer>() {
            public void onCall(Release release) {
                logger.info("onCall...");
            }

            public void onReceive(Integer integer) {
                logger.info("onReceive...");
                logger.info("Integer is {}",integer);
            }

            public void onCompleted() {
                logger.info("onCompleted...");
            }

            public void onError(Throwable e) {
                logger.info("onError...");
            }
        });
    }
}
