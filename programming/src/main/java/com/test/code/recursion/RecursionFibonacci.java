package com.test.code.recursion;

public class RecursionFibonacci {

   public static int get(int n) {
      if (n <= 1) {
         return 1;
      } else {
         return get(n - 1) + get(n - 2);
      }
   }
}