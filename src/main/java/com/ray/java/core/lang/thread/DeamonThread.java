package com.ray.java.core.lang.thread;

public class DeamonThread implements Runnable {
	
	public void run() {
		try {
			if (Thread.currentThread().isDaemon()) {
				System.out.println(Thread.currentThread().getName() + " is deamon thread start");
				Thread.sleep(3000);
			} else {
				System.out.println(Thread.currentThread().getName() + " is user thread start");
				Thread.sleep(1000);
			}
			
			System.out.println(Thread.currentThread().getName() + " end");
		} catch (Exception e) {
			
		}
	}

}
