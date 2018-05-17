package com.ray.java.core.lang.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadMain {
	
	public static void main(String[] args) {
		//testSampleThread();
		//testJoin();
		//testDeamon();
		//testSleepInterrupt();
		//testStartMutipleTimes();
		//testStartMutipleTimes2();
		//testBookThreads();
		//testThreadLocal();
		
		testSynchronized();
	}
	
	private static void testSampleThread() {
		List<Thread> tList = new ArrayList<Thread>();
		
		for (int i = 0; i < 5; i++) {
			tList.add(new Thread(new SampleThread(i)));
		}
	
		for (Thread t : tList) {
			t.start();
		}
	}
	
	private static void testJoin() {
		List<Thread> tList = new ArrayList<Thread>();
		
		for (int i = 0; i < 3; i++) {
			tList.add(new Thread(new SampleThread(i)));
		}
	
		System.out.println("Main thread execution starts");
		Thread t1 = tList.get(0);
		Thread t2 = tList.get(1);
		Thread t3 = tList.get(2);
		
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
		}
		
		t2.start();
		try {
			t2.join(1000);
		} catch (Exception e) {
		}
		
		t3.start();
		try {
			t3.join();
			t2.join();
		} catch (Exception e) {
		}
		
		System.out.println("Main thread execution ends");
	}
	
	private static void testDeamon() {
		Thread t1 = new Thread(new DeamonThread());
		Thread t2 = new Thread(new DeamonThread());
		Thread t3 = new Thread(new DeamonThread());
		
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static void testSleepInterrupt() {
		Thread t1 = new Thread(new SampleThread(0));
		Thread t2 = new Thread(new SampleThread(1));
		Thread t3 = new Thread(new SampleThread(2));
		
		t1.start(); // t1 will sleep 2 secs
		
		try {
			Thread.sleep(1000);
			t1.interrupt();  // interrupt t1 after 1 second
			t1.join();
		} catch (Exception e) {	
		}
		
		t2.start();
		t3.start();
	}
	
	private static void testStartMutipleTimes() {
		Thread t1 = new Thread(new SampleThread(0));
		
		t1.start(); 
		try {
			t1.start(); 
		} catch (Exception e) {
			System.out.println("can not start the t1 before it finished " + e.getMessage());
		}
	}
	
	private static void testStartMutipleTimes2() {
		Thread t1 = new Thread(new SampleThread(0));
		
		t1.start(); 
		try {
			t1.join(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			t1.start(); 
		} catch (Exception e) {
			System.out.println("can not start the t1 after it finished " + e.getMessage());
		}
	}
	
	private static void testBookThreads() {
		Book book=new Book("The Alchemist");
		BookReadThread johnReader=new BookReadThread(book);
		BookReadThread arpitReader=new BookReadThread(book);
		  
		// BookReader threads which will wait for completion of book
		Thread johnThread = new Thread(johnReader,"John");
		Thread arpitThread = new Thread(arpitReader,"Arpit");
	
		arpitThread.start();
		johnThread.start();
		  
		// To ensure both readers started waiting for the book
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// BookWriter thread which will notify once book get completed
		BookWriteThread bookWriter=new BookWriteThread(book);
		Thread bookWriterThread=new Thread(bookWriter);
		bookWriterThread.start();
	}
	
	private static void testThreadLocal() {
		Long test = 123L;
		ThreadLocalContext.MY_THREAD_LOCAL.set(test);
		System.out.println(ThreadLocalContext.getLong());
		
		Thread t1 = new Thread(new MyThread(1), "t1");
		
		Thread t2 = new Thread(new MyThread(2), "t2");
		
		t1.start();
		t2.start();
	}
	
	static class MyThread implements Runnable {
        private int index;

        private static ThreadLocal<Long> value = ThreadLocalContext.MY_THREAD_LOCAL;
        public MyThread(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("线程" + index + "的初始value:" + value.get());
            for (Long i = 0L; i < 10; i++) {
                value.set(i);
            }
            System.out.println("线程" + index + "的累加value:" + value.get());
        }
    }
	
	private static void testSynchronized() {
		SynchronizedContext sync = new SynchronizedContext();
		
		Thread t1 = new Thread(new SyncThread(sync), "t1");
		Thread t2 = new Thread(new SyncThread(sync), "t2");
		
		t1.start();
		t2.start();
	}
	
	static class SyncThread implements Runnable {
        private SynchronizedContext sync;

       
        public SyncThread(SynchronizedContext sync) {
            this.sync = sync;
        }

        public void run() {
        	for (int i = 0; i < 5; i++) {
        		int count = sync.incrementCount();
        		//int count = sync.incrementCount2();
        		System.out.println(Thread.currentThread().getName() + " " + count);
        	}
        }
    }


}
