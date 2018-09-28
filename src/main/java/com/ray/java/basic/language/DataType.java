package com.ray.java.basic.language;

import java.math.BigDecimal;

public class DataType {

	/**
	 * Java primitive data type
	 */
	public byte byteVal = 127;	// 1 byte (8 bits), –128 to 127
	public short shortVal = -32768;	// 2 byte (16 bits), –32768 to 32767
	public int intVal = 2147483647;	// 4 byte (32 bits), –2147483648 to 2147483647
	public long longVal = 9223372036854775807L;	// 8 byte (64 bits), –9223372036854775808 to 9223372036854775807
	public double doubleVal = 1.5d;	// 4 byte (32 bits)
	public float floatVal = 1.2f;	// 8 byte (64 bits)
	public boolean boolVal = true;	// 1 bit
	public char charVal = 'c';	// 2 byte (16 bits)
	
	/**
	 * Java reference data type
	 */
	public String stringVal = "1234";
	public Integer integerVal = 1;
	public Long longObjVal = 9223372036854775807L;
	public BigDecimal bigDecimal = new BigDecimal(32.546);
	
	public void printPrimitive() {
		System.out.println("byte = " + byteVal);
		System.out.println("short = " + shortVal);
		System.out.println("int = " + intVal);
		System.out.println("long = " + longVal);
		System.out.println("double = " + doubleVal);
		System.out.println("float = " + floatVal);
		System.out.println("boolean = " + boolVal);
		System.out.println("charVal = " + charVal);
	}
	
	public void convertPrimitive() {
		double intToDouble = (double) intVal;
		int doubleToInt = (int) doubleVal;
		byte intToByteOverflow = (byte) intVal;
		long intToLong = (long) intVal;
		
		System.out.println("intToDouble = " + intToDouble);
		System.out.println("doubleToInt = " + doubleToInt);
		System.out.println("intToByteOverflow = " + intToByteOverflow);
		System.out.println("intToLong = " + intToLong);
	}
	
	public void convertRefernece() {
		Integer stringToInteger = Integer.parseInt(stringVal);
		String integerToString = integerVal.toString();
		
		System.out.println("stringToInteger = " + stringToInteger);
		System.out.println("integerToString = " + integerToString);
	}

}
