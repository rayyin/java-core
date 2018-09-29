package com.ray.java.concurrent.executor;

import java.util.concurrent.Callable;

public class FutureTaskBasic {


    public void futureTask() {

    }

    private class SampleThread implements Callable {
        int a;
        int b;
        long sleepTime;

        public SampleThread(int a, int b, long sleepTime) {
            this.a=a;
            this.b=b;
            this.sleepTime=sleepTime;

        }

        public Integer call() throws Exception {
            Thread.sleep(sleepTime);
            return a*b;
        }
    }
}
