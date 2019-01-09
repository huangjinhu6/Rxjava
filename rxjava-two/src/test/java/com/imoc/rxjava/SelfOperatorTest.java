package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;

public class SelfOperatorTest {

    private SelfOperator selfOperator;

    @Before
    public void setUp() throws Exception {
        selfOperator = new SelfOperator();
    }

    @Test
    public void normal() {
        selfOperator.normal();
    }

    @Test
    public void backPressure(){
        selfOperator.backPressure();
    }

    @Test
    public void lift(){
        selfOperator.lift();
    }
}