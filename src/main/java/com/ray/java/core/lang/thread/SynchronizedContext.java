package com.ray.java.core.lang.thread;

public class SynchronizedContext {

	private int count = 0;
	 
	public synchronized int incrementCount() {
		count++;
		return count;
	}
	 
	public int incrementCount2() {
		synchronized (this) {
			count++;
			return count;
		}
	}
}
