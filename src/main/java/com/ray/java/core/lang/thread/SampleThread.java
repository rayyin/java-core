package com.ray.java.core.lang.thread;

public class SampleThread implements Runnable {

	public int index;
	
	public SampleThread(int index) {
		this.index = index;
	}
	
	public void run() {
		try {
			System.out.println("Thread is running start, index=" + index + 
					" threadname=" + Thread.currentThread().getName());
			Thread.sleep(2000);
			System.out.println("Thread is running end, index=" + index + 
				" threadname=" + Thread.currentThread().getName());
		} catch(Exception e) {
			
		}
	}
}
