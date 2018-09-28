package com.ray.java.basic.language;

public class BasicMain {
	
    public static void main( String[] args )
    {
    	callBasic();
    }
	
	private static void callBasic() {
    	
		//testDataType();
    	
		//testVariable();
		
		//testAccessModifier();
		
		testKeyword();
    }
	
	private static void testDataType() {
    	DataType javaDataType= new DataType();
    	javaDataType.printPrimitive();
    	javaDataType.convertPrimitive();
    	javaDataType.convertRefernece();
	}
	
	private static void testVariable() {
    	Variable javaVar = new Variable();
    	Variable javaVar2 = new Variable();
    	System.out.println("javaVar instanceVar = " + javaVar.instanceVar);
    	System.out.println("javaVar2 instanceVar = " + javaVar2.instanceVar);
    	System.out.println("javaVar staticVar = " + javaVar.staticVar);
    	System.out.println("javaVar2 staticVar = " + javaVar2.staticVar);
    	javaVar.instanceVar = 200;
    	javaVar.staticVar = 100;
    	System.out.println("javaVar instanceVar = " + javaVar.instanceVar);
    	System.out.println("javaVar2 instanceVar = " + javaVar2.instanceVar);
    	System.out.println("javaVar staticVar = " + javaVar.staticVar);
    	System.out.println("javaVar2 staticVar = " + javaVar2.staticVar);
	}
	
	private static void testAccessModifier() {
		AccessModifier am = new AccessModifier();
		/*
    	 * only public/default/protected variable could be accessible, private(inner class)
    	 */
    	System.out.println("publicVar = " + am.publicVar);
    	System.out.println("defaultVar = " + am.defaultVar);
    	System.out.println("protectedVar = " + am.protectedVar);
	}
	
	private static void testKeyword() {
		Keyword key = new Keyword();
		//key.testSuperKeyword();
		key.testThisKeyword();
		
	}

}
