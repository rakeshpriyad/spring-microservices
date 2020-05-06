package com.test.code;

// Java program to Compute the minimum
// or maximum of two integers without if

public class PrintMaxWithoutIf {

	/*Function to find minimum of x and y*/
	static int min(int x, int y) 
	{
		System.out.println("x: "+ x + " y: "+ y);
		System.out.println("x ^ y "+ (x^y));
		System.out.println("x << y "+ -(x<<y));
		System.out.println("((x ^ y) & -(x << y)) "+ ((x ^ y) & -(x << y)));
		return y ^ ((x ^ y) & -(x << y));
	} 
	
	/*Function to find maximum of x and y*/
	static int max(int x, int y) 
	{ 
	return x ^ ((x ^ y) & -(x << y)); 
	} 
	
	/* Driver program to test above functions */
	public static void main(String[] args) { 
		
		int x = 6;
		int y = 16;
		System.out.println("x: "+ x + " and  y: "+ y);
		System.out.println("x ^ y "+ (x^y));
		System.out.println("x << y "+ -(x<<y));
		System.out.println(22 & -393216);
		System.out.println(y ^ 0);
		System.out.println("((x ^ y) & -(x << y)) "+ ((x ^ y) & -(x << y)));
		//System.out.print("Minimum of "+x+" and "+y+" is ");
		System.out.println(min(x, y));
		//System.out.print("Maximum of "+x+" and "+y+" is ");
		//System.out.println( max(x, y));
	} 

} 
