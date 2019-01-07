package com.imoc.rxjava.example;

import java.util.concurrent.atomic.AtomicReference;

public enum  ReleaseHelper implements Release{
    RELEASE;

    public static boolean isRelease(Release release){
        return release == RELEASE;
    }

    public static boolean release(AtomicReference<Release> release){
        Release current = release.get();
        Release re = RELEASE;
        if(current != re){
            current = release.getAndSet(re);
            if(current != re){
                if(current != null){
                    current.release();
                }
                return true;
            }
        }
        return false;
    }

    public boolean isReleased() {
        return true;
    }

    public void release() {

    }
}
