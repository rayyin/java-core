package com.ray.java.core.app;

import com.ray.java.core.basic.*;

public class App 
{
    public static void main( String[] args )
    {
    	callBasic();
    }
    
    private static void callBasic() {

    	/**
    	 * Basic
    	 */
    	//Basic javaBasic = new Basic();
    	//javaBasic.helloWorld();
    	
    	/**
    	 * DataType  
    	 */
    	//DataType javaDataType= new DataType();
    	//javaDataType.printPrimitive();
    	//javaDataType.convertPrimitive();
    	//javaDataType.convertRefernece();
    	
    	/**
    	 * Variable
    	 */
    	Variable javaVar = new Variable();
    	Variable javaVar2 = new Variable();
    	System.out.println("instanceVar = " + javaVar.instanceVar);
    	System.out.println("staticVar = " + javaVar.staticVar);
    	Variable.staticVar = 100;
    	System.out.println("staticVar = " + javaVar.staticVar);
    	
    	
    }
}
