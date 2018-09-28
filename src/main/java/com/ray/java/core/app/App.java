package com.ray.java.core.app;

import com.ray.java.basic.language.AccessModifier;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("hello world");
    	
    	testAccessModifier();
    }
    
    public static void testAccessModifier() {
    	/*
    	 * only public variable could be accessible, default(the same package), protected(the same package or extends), private(inner class)
    	 */
    	AccessModifier am = new AccessModifier();
    	System.out.println("publicVar = " + am.publicVar);
    }
}
