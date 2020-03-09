package com.test.code.recursion;

public class RecursionSumArrayElements {

	   public static int sumFromLast(int arr[], int n){
	   	if(n==0){
	   		return 0;
		}

	   	return sum(arr,n-1)+ arr[n-1];
	   }

	public static int sum(int arr[], int index){
		int total =0;
		if(index==arr.length || arr.length ==0){
			return total;
		}

		return sum(arr,index+1)+ arr[index];
	}
	   
	   public static void main(String[] args) {
		  int[] array = {2, 1, 3, 5};
		  int total = sum(array, 0);
		  System.out.println("Total: " + total);
		   total = sumFromLast(array, 4);
		   System.out.println("Total from last: " + total);
	   }
	}
