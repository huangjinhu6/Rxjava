package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorTest {

    private Operator operator;
    @Before
    public void setUp() throws Exception {
        operator = new Operator();
    }

    @Test
    public void map() {
        operator.map();
    }
}