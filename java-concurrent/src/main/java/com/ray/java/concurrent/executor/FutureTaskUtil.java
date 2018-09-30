package com.ray.java.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTaskUtil {

    public static void main(String[] args) {
        FutureTaskUtil futureTaskUtil = new FutureTaskUtil();
        futureTaskUtil.futureTask();
    }

    public void futureTask() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        SampleCallable task1 = new SampleCallable(10,20,2000L);
        SampleCallable task2 = new SampleCallable(20,40,4000L);

        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(task1);
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(task2);

        es.submit(futureTask1);
        es.submit(futureTask2);

        while(true)
        {
            try {
                if(!futureTask1.isDone())
                {
                    System.out.println("FutureTask1 output = " + futureTask1.get());
                }
                if(!futureTask2.isDone())
                {
                    System.out.println("Waitng for futureTask2 for completion");
                    System.out.println("FutureTask2 output = " + futureTask2.get());
                }
                if(futureTask1.isDone() && futureTask2.isDone())
                {
                    System.out.println("Completed both the FutureTasks, shutting down the executors");
                    es.shutdown();
                    return;
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public void task() {


    }

    private class SampleCallable implements Callable {
        int a;
        int b;
        long sleepTime;

        public SampleCallable(int a, int b, long sleepTime) {
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
