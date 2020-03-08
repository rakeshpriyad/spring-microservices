package com.test.str;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringRotationalPalindrome {

    public static void main(String[] args) {

       // System.out.println(isPalindrome("aba"));
        char arr [] ="aaadaaaada".toCharArray();
        rotate(arr);
        isPalindrome(arr);
        isRotationalPalindrome("aaadaaaada");
        Stream.of(arr).forEach(System.out::print);
    }
    public static void isRotationalPalindrome(String inputString){
        char arr [] =inputString.toCharArray();
        for ( int i =0; i<arr.length-1; i++){
            rotate(arr);
            if(isPalindrome(arr)){
                System.out.println("inputString(i.e "+inputString+") is rotation of the palindrome: "+String.valueOf(arr));
            }
        }
    }

    public static void rotate(char arr[]){
        char c =arr[0];
        int i =0;
        for ( i =0; i<arr.length-1; i++){
            arr[i] =arr[i+1];
        }
        arr[i] =c;
    }

    public static boolean isPalindrome(char [] ar){
        for(int i=0,j=ar.length-1; i<(ar.length/2); i++,j--){
            if(ar[i]!=ar[j])
                return false;
        }
        return true;
    }
}
