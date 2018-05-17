package com.ray.java.core.lang.thread;

public class BookReadThread implements Runnable {
	
	private Book book;
	public BookReadThread(Book book) {
		super();
		this.book = book;
	}
	
	public void run() {
		synchronized (book) {
			System.out.println(Thread.currentThread().getName()+" is waiting for the book to be completed: "+book.getTitle());
			try {
				book.wait();
			} catch (InterruptedException e) {    
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+": Book has been completed now!! you can read it");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {    
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()+": completed to read");
			book.notify();
		}
	 } 
	 
}
