package com.test.code.array.easy;

public class FindTheMax {
    public static void main(String[] args) throws Exception {
        int m =findMax( new int[] {3,1,9,2,5});
        System.out.println(m);
    }

    public  static int findMax(int arr[]) throws  Exception{
       // int max = Integer.MIN_VALUE;
        if (arr != null && arr.length >0) {
           int  max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if ( arr[i] > max){
                    max = arr[i];
                }
            }
            return max;
        }else {
            throw new Exception(" invalid array");
        }
    }
}
