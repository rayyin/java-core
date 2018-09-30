package com.ray.java.concurrent.executor;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorUtil {

    public static void main(String[] args) {
        ExecutorUtil executor = new ExecutorUtil();
        executor.executorServiceFixedThreadPool();
        executor.executorServiceFixedThreadPoolCallable();
        executor.executorServiceFixedThreadPoolCallableInvokeAll();

        executor.threadPoolExecutorFixedThreadPool();
        executor.threadPoolExecutorQueueOverload();
        executor.threadPoolExecutorQueue();
    }

    private void executorServiceFixedThreadPool() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        System.out.println("main thread = " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            SampleThread st = new SampleThread("File" + i);
            System.out.println("A new file has been added to read : " + st.getName());
            es.execute(st);
        }
        es.shutdown();
    }

    private void executorServiceFixedThreadPoolCallable() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        System.out.println("main thread = " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            SampleCallable sc = new SampleCallable("File" + i);
            System.out.println("A new file has been added to read : " + sc.getName());
            Future<String> future = es.submit(sc);
            futureList.add(future);
        }
        System.out.println("----do other---- ");
        for (Future<String> future : futureList) {
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println("*******" + new Date() + "::" + future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("----do finish---- ");
        es.shutdown();
    }

    private void executorServiceFixedThreadPoolCallableInvokeAll() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        List<Callable<String>> callables = new ArrayList<Callable<String>>();

        for (int i = 1; i <= 10; i++) {
            SampleCallable sc = new SampleCallable("File" + i);
            callables.add(sc);
        }

        try {
            List<Future<String>> futureList = es.invokeAll(callables);
            for (Future<String> future : futureList) {
                System.out.println("*******" + new Date() + "::" + future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        es.shutdown();
    }

    private void threadPoolExecutorFixedThreadPool() {
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        System.out.println("main thread = " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            SampleThread st = new SampleThread("File" + i);
            System.out.println("A new file has been added to read : " + st.getName());
            tpe.execute(st);
        }
        tpe.shutdown();
    }

    private void threadPoolExecutorQueueOverload() {
        int corePoolSize = 2;
        int maxPoolSize = 5;
        long keepAlive = 5000;

        // Wait queue is used to store waiting task
        BlockingQueue queue = new LinkedBlockingQueue(4);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // Rejection handler in case task get rejected
        RejectTaskHandler rth = new RejectTaskHandler();

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAlive, TimeUnit.MILLISECONDS, queue, threadFactory, rth);
        for (int i = 1; i <= 10; i++) {
            SampleThread st = new SampleThread("File" + i);
            System.out.println("A new file has been added to read : " + st.getName());
            tpe.execute(st);
        }
        tpe.shutdown();
    }

    private void threadPoolExecutorQueue() {
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAlive = 5000;

        // Wait queue is used to store waiting task, not size here
        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        // Rejection handler in case task get rejected
        RejectTaskHandler rth = new RejectTaskHandler();

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAlive, TimeUnit.MILLISECONDS, queue, threadFactory, rth);
        for (int i = 1; i <= 10; i++) {
            SampleThread st = new SampleThread("File" + i);
            System.out.println("A new file has been added to read : " + st.getName());
            tpe.execute(st);
        }
        tpe.shutdown();
    }

    private class SampleThread implements Runnable {

        private final String name;

        public SampleThread(String name) {
            super();
            this.name = name;
        }

        public void run() {
            try {
                System.out.println("Fetching data from " + name + " by " + Thread.currentThread().getName());
                Thread.sleep(5000); // Reading file
                System.out.println("Read file successfully: " + name + " by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }
    }

    private class SampleCallable implements Callable {

        private final String name;

        public SampleCallable(String name) {
            super();
            this.name = name;
        }

        public String call() {
            try {
                System.out.println("Fetching data from " + name + " by " + Thread.currentThread().getName());
                Thread.sleep(5000); // Reading file
                System.out.println("Read file successfully: " + name + " by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return name + " " + Thread.currentThread().getName();
        }

        public String getName() {
            return name;
        }
    }

    private class RejectTaskHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            SampleThread st = (SampleThread) r;
            System.out.println("xxxxxxxxxxxxxxSorry!! We won't be able to read :" + st.getName());
        }
    }
}
