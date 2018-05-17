package com.ray.java.core.lang.thread;

public class BookWriteThread implements Runnable{
	 
	 Book book;
	 
	 public BookWriteThread(Book book) {
	  super();
	  this.book = book;
	 }
	 
	 public void run() {
		 synchronized (book) {
			 System.out.println("Author is Starting book : " +book.getTitle() );
			 try {
				 Thread.sleep(1000);
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
			 book.setCompleted(true);
			 System.out.println("Book has been completed now");
	   
			 book.notify();
			 System.out.println("notify one reader");
		 } 
	 }
	 

}
