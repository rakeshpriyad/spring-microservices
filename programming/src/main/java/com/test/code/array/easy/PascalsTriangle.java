package com.test.code.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//In mathematics, Pascal's triangle is a triangular array of the binomial coefficients. I
/**
 *
 *
 * <p>Given an index k, return the kth row of the Pascal's triangle.
 *
 * <p>For example, given k = 3, Return [1,3,3,1].
 *
 * <p>Note: Could you optimize your algorithm to use only O(k) extra space?
 * m
 * n
 * 0	1	2	3	4	5	... col
 * 0	1	0	0	0	0	0	... row
 * 1	1	1	0	0	0	0	...
 * 2	1	2	1	0	0	0	...
 * 3	1	3	3	1	0	0	...
 * 4	1	4	6	4	1	0	...
 */

/**
 * if we enter 3
 *
 *      1
 *    1 1
 *   1 2 1
 *   if we enter 4
 *      1
 *     1 1
 *    1 2 1
 *   1 3 3 1
 *
 *   4C4 =
 *   0C0
 *  0C0 0C1
 *  0C0 0C1 0C2
 *  0C0 0C1 0C2 0C3
 *
 */
public class PascalsTriangle {
  public static Function<Integer,Integer> fact = (num) -> IntStream.rangeClosed(1,num).reduce(1,(x,y)-> x*y);

  public static BiFunction<Integer,Integer,Integer> ncr = (n,r) -> fact.apply(n) / ( fact.apply(n-r) * fact.apply(r) );
  public static Function<Integer,List<Integer>> getPascalRow = (rows) -> IntStream.rangeClosed(0,rows-1).map(j -> ncr.apply(rows-1, j)).boxed().collect(Collectors.toList());
  public static void main(String[] args) throws Exception {

    System.out.println("Pascal Triangle:");
    int rows =inputRow();
    System.out.println(getPascalRow.apply(rows));
    printPascalTriangle(rows);
  }

  public static int inputRow(){
    int rows;

    //getting number of rows from user
    System.out.println("Enter number of rows:");
    Scanner scanner = new Scanner(System.in);
    rows = scanner.nextInt();
    scanner.close();
    return rows;
  }
  public static void printPascalTriangle(int rows){
    IntStream.range(0,rows).forEach( i-> {
      /*for(int j = 0; j < rows-i; j++){
        System.out.print(" ");
      }*
      for(int j = 0; j <= i; j++){
        System.out.print(" "+ncr(i, j));
      }

       */
      IntStream.range(0,rows-i).forEach( j-> System.out.print(" "));
      IntStream.rangeClosed(0,i).forEach( j-> System.out.print(" "+ncr.apply(i, j)));

      System.out.println("");
    });

  }
  static List<Integer> getPascalT(int rows){
    List<Integer> res = IntStream.rangeClosed(0,rows-1).map(j -> ncr.apply(rows-1, j)).boxed().collect(Collectors.toList());
    return res;
  }

/*
  static int fact(int num) {
    return IntStream.rangeClosed(1,num).reduce(1,(x,y)-> x*y);
  }

  static int ncr(int n,int r) {
    return fact(n) / ( fact(n-r) * fact(r) );
  }
*/

}
