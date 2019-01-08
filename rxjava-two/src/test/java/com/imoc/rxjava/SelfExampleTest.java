package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;

public class SelfExampleTest {

    private SelfExample selfExample;

    @Before
    public void init(){
        selfExample = new SelfExample();
    }

    @Test
    public void selfNormal() {
        selfExample.normal();
    }

    @Test
    public void selfBackpressureTest(){
        selfExample.backPressure();
    }
}