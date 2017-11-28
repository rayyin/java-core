package com.ray.java.core.basic;

public class Keyword {

	public void testSuperKeyword() {
		ClassB b = new ClassB();
		b.printSuperName();	//ClassB super name (vairable level) = Default
		
		ClassC c = new ClassC("John");
		c.printSuperNameConstructor();	//ClassC super name (constructor level) = John
		c.printSuperNameMethod();	//ClassA name = John, since super(name) is implemented 
		
		ClassC c2 = new ClassC();
		c2.printSuperNameConstructor();	//ClassC super name (constructor level) = Default
		c2.printSuperNameMethod();	//ClassA name = Default
	}
	
	public void testThisKeyword() {
		ClassA a = new ClassA();
		a.printName();	//ClassA this name = Default
		
		ClassA a2 = new ClassA("Ray", 80);	//Calling ClassA constructor Calling ClassA constructor with two params
		System.out.println("get object by using this = " + a2.getObject());	//get object by using this = com.ray.java.core.basic.ClassA@7637f22
	}
}

class ClassA {
	String name;
	public ClassA()
	{
		System.out.println("Calling ClassA constructor");
		name="Default";
	}
	
	public ClassA(String name)
	{
		this.name = name;
		System.out.println("Calling ClassA constructor with param");
	}
	
	public void printName()
	{
		System.out.println("ClassA this name = " + this.name);
	}
	
	public ClassA(String name, int age)
	{
		this();
		System.out.println("Calling ClassA constructor with two params");
	}
	
	public ClassA getObject() {
		return this;
	}
}

class ClassB extends ClassA {
	String name;
	public ClassB()
	{
		System.out.println("Calling ClassB constructor");
		name="Martin";
	}
	
	public void printSuperName()
	{
		System.out.println("ClassB super name (vairable level) = " + super.name);
	}
	
	public void printThisName()
	{
		System.out.println("ClassB this name = " + this.name);
	}
}

class ClassC extends ClassA {

	public ClassC()
	{
		System.out.println("Calling ClassC constructor");
	}
	
	public ClassC(String name)
	{
		super(name);
		System.out.println("Calling ClassC constructor with param");
	}
	
	public void printSuperNameConstructor()
	{
		System.out.println("ClassC super name (constructor level) = " + name);
	}
	
	public void printSuperNameMethod()
	{
		super.printName();
	}
}