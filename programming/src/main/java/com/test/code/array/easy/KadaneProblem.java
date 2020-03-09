package com.test.code.array.easy;

import java.util.Scanner;

public class KadaneProblem {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //int n = sc.nextInt();
        int arr[] = {1, 2, 3, -2, 5};
        //int sum = arr[0];
        int max_so_far = getMaxSubArraySum(arr);
        System.out.println("max sub array "+ max_so_far);
    }

    private static int getMaxSubArraySum(int[] arr) {
        int max_so_far = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum < 0) {
                sum = 0;
            }
            if (max_so_far < sum) {
                max_so_far = sum;
            }
        }
        return max_so_far;
    }
}
