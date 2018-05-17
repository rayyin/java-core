package com.ray.java.core.lang.thread;

public class ThreadLocalContext {
	
	public final static ThreadLocal<Long> MY_THREAD_LOCAL = new ThreadLocal<Long>();
	
	public static void setLong(Long number) {
		MY_THREAD_LOCAL.set(number);
	}
	
	public static Long getLong() {
		return MY_THREAD_LOCAL.get();
	}

}
