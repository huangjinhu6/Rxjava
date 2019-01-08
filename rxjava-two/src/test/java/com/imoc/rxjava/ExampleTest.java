package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;

public class ExampleTest {

    private Example example;

    @Before
    public void init(){
        example = new Example();
    }

    @Test
    public void normal() {
        example.normal();
    }

    @Test
    public void flowable() {
        example.flowable();
    }
}