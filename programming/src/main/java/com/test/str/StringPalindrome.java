package com.test.str;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abaa"));
    }

    public static boolean isPalindrome(String s){
       List<Character> characterStream = s.chars().mapToObj(x -> (char)x).collect(Collectors.toList());
       //characterStream.stream().forEach();
      int n = characterStream.size()-1;
      for( int i=0, j=n; i<n/2; i++,j--){
          if (characterStream.get(i) != characterStream.get(j)){
              return false;
          }
      }
       return true;
    }
}
