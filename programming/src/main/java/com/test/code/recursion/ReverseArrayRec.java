package com.test.code.recursion;

import java.util.Arrays;

public class ReverseArrayRec {

   public static int[] reverseArray(int[] array, int beginIndex, int endIndex) {
      if (beginIndex > endIndex) {
         return array;
      }
      
      int aux = array[beginIndex];
      array[beginIndex] = array[endIndex];
      array[endIndex] = aux;
      
      return reverseArray(array, beginIndex + 1, endIndex - 1);
   }

   public static void print(int arr[]){
      Arrays.stream(arr).forEach(System.out::println);
   }
   public static void main(String[] args) {
      int[] data = {4, 3, 6, 2, 6};
      System.out.println("original array");
      print(data);
      int[] dataReverse = reverseArray(data, 0, 4);
      System.out.println("reversed array");
      for (int i = 0; i < dataReverse.length; i++) {
         System.out.print(dataReverse[i] + " ");
      }
   }
}