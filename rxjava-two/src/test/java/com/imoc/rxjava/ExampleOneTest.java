package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleOneTest {

    private ExampleOne exampleOne;

    @Before
    public void init(){
        exampleOne = new ExampleOne();
    }

    @Test
    public void normal() {
        exampleOne.normal();
    }

    @Test
    public void flowable() {
        exampleOne.flowable();
    }
}