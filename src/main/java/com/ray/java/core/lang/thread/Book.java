package com.ray.java.core.lang.thread;

public class Book {

	String title;
	boolean isCompleted;
	 
	public Book(String title) {
		super();
		this.title = title;
	}
	 
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isCompleted() {
		return isCompleted;
	}
	
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}
