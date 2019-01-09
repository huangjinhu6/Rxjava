package com.imoc.rxjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchedulerTest {

    private Scheduler scheduler;

    @Before
    public void setUp() throws Exception {
        scheduler = new Scheduler();
    }

    @Test
    public void schedule() {

        scheduler.schedule();
    }
}