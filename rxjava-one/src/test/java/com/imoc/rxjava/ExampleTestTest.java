package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTestTest {

    private ExampleTest exampleTest;

    @Before
    public void init(){
        exampleTest = new ExampleTest();
    }

    @Test
    public void self() {
        exampleTest.self();
    }
}