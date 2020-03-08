package com.test.str;

import java.util.List;
import java.util.stream.Collectors;

public class StringPalindromeRecursion {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
    }

    public static boolean isPalindrome(String s){
        if (s.length() ==0 || s.length() ==1){
            return  true;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)){
            System.out.println(s.substring(1, s.length()-1));
            //pass b i.e. remove 1 char from beg and from end
            return isPalindrome(s.substring(1, s.length()-1));
        }
        return false;
    }
}
