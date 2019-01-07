package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;


public class ExampleOneTest {


    private ExampleOne exampleOne;

    @Before
    public void init(){
        exampleOne = new ExampleOne();
    }

    @Test
    public void normalTest(){
        exampleOne.normal();
    }
}
