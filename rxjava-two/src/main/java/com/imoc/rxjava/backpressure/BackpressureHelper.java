package com.imoc.rxjava.backpressure;

import java.util.concurrent.atomic.AtomicLong;

public class BackpressureHelper {

    public static void add(AtomicLong requested,long n){
        long r = requested.get();
        if(r == Long.MAX_VALUE){
            return;
        }
        long u = n+r;
        if(u < 0L){
            u = Long.MAX_VALUE;
        }
        requested.compareAndSet(r,u);
    }

    public static void produced(AtomicLong requested,long n){
        long current = requested.get();

        if(current == Long.MAX_VALUE){
            return;
        }

        long update = current - n;

        if(update < 0L){
            update = 0L;
        }

        requested.compareAndSet(current,update);

    }
}
