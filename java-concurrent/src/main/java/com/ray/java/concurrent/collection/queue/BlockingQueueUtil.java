package com.ray.java.concurrent.collection.queue;

import com.ray.java.concurrent.executor.ExecutorUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueUtil {

    private static BlockingQueue<String> queue;

    public static void main(String[] args) {
        BlockingQueueUtil blockQueueUtil = new BlockingQueueUtil();
        //blockQueueUtil.BlockingQueueBasic();
        blockQueueUtil.BlockingQueueBasicWithSize();
    }

    public void BlockingQueueBasic() {
        queue = new LinkedBlockingQueue<String>();
        queue.add("File1");
        queue.add("File2");

        Executors.newSingleThreadExecutor().execute(new ConsumerSingleThread());
        // alt
        //new Thread(new ConsumerSingleThread()).start();
    }

    public void BlockingQueueBasicWithSize() {

        queue = new LinkedBlockingQueue<String>(1);
        // if using queue.add(), throw exception "queue full"
        queue.add("File1");
        queue.add("File2");

        // alt
        // if using queue.offer(), the 2nd returns false but no exception, recommend
        //queue.offer("File1");
        //queue.offer("File2");

        // alt
        // if using queue.put(), waiting for file1 consumed
        /*try {
            Executors.newSingleThreadExecutor().execute(new ConsumerSingleThread());
            queue.put("File1");
            queue.put("File2");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }*/

        Executors.newSingleThreadExecutor().execute(new ConsumerSingleThread());
    }

    private class ConsumerSingleThread implements Runnable {

        public void run() {
            while (true) {
                try {
                    System.out.println("queue size " + queue.size() + " by " + Thread.currentThread().getName());
                    String name = queue.take();
                    System.out.println("Fetching data from " + name + " by " + Thread.currentThread().getName());
                    Thread.sleep(5000); // Reading file
                    System.out.println("Read file successfully: " + name + " by " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
