package com.imoc.rxjava.backpressure;

public interface Drop {

    void request(long n);

    void drop();
}
