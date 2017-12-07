package com.ray.java.core.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadMain {
	
	 public static void main(String[] args) {
		//testSampleThread();
		testJoin();
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

}
