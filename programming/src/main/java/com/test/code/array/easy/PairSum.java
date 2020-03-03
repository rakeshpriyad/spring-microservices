package com.test.code.array.easy;// Java implementation using Hashing
import java.util.HashSet;
import java.util.stream.IntStream;

class PairSum { 
	static void printpairs(int arr[], int sum) 
	{ 
		HashSet<Integer> s = new HashSet<Integer>();
		IntStream.range(0, arr.length).forEach(i -> {
			int temp = sum - arr[i];

			// checking for condition
			if (s.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			s.add(arr[i]);
		});

	} 

	// Main to test the above function 
	public static void main(String[] args) 
	{ 
		int A[] = { 1, 4, 45, 6, 10, 8 }; 
		int n = 16; 
		printpairs(A, n); 
	} 
} 

// This article is contributed by Aakash Hasija 
