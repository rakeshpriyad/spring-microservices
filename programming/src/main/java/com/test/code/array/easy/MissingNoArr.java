package com.test.code.array.easy;

public class MissingNoArr {

    public static int getMissingNo(int arr[], int n){
        int x1 =arr[0];
        int x2=1;
        for( int i=1; i< n; i++){
            x1 = x1 ^ arr[i];
        }
        for( int i=2; i< n+1; i++){
            x2 = x2 ^ i;
        }
        return (x1 ^ x2);
    }

    /**
     * X1= A1^A2^A4
     * X2=A1^A2^A3^A4
     * X1^X2 =(A1^A2^A4) ^ (A1^A2^A3^A4)
     * = ((A1^A1) ^(A2^A2)^(A3)^(A4^A4)
     * =0^0^A3^0
     * =A3
     * because A1^A1 is 0
     * @param args
     */
    public static void main(String[] args) {
        int a[] = { 1, 2, 4, 5, 6 };
        int miss = getMissingNo(a, 5);
        System.out.println(miss);
    }
}
