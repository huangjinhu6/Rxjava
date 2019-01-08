package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;


public class ExampleTest {


    private Example exampleOne;

    @Before
    public void init(){
        exampleOne = new Example();
    }

    @Test
    public void normalTest(){
        exampleOne.example();
    }
}
