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
    public void selfOperator() {
        selfOperator.map();
    }
}