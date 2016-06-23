package com.example.androidfluxarchitecture;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by joanna on 23.06.16.
 */
public class SubscribeBase {
    public AtomicBoolean testDone;

    public SubscribeBase setTestDone(AtomicBoolean testDone) {
        this.testDone = testDone;
        return this;
    }
}
