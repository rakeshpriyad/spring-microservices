package com.test.code.recursion;

import java.util.Arrays;

/**
 * Describe a recursive algorithm for finding the maximum element in an array, A, of n elements. 
 * What is your running time and space usage?
 * 
 * @author rogerio
 */
public class MaxmumArrRec {
   
   public static int maximumElement(int[] A, int index) {
      if (A.length == 1) {
         return A[0];
      }
      
      if (A[index] > A[index + 1]) {
         return A[index];
      }
      
      return maximumElement(A, index + 1);
   }
   public static void print(int arr[]){
      Arrays.stream(arr).forEach(System.out::println);
   }

   public static void main(String[] args) {
      int arr[] ={3,6,9,2,8};
     int m= maximumElement(arr,0);
      print(arr);
      System.out.println("Max--"+m);

   }
}