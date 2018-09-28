package com.ray.java.basic.language;

public class Variable {
	public int instanceVar = 1;
	public static int staticVar = 2;
	
	public void printLocalVar() {
		int localVar = 10;
		System.out.println("localVar = " + localVar);
	}
}
