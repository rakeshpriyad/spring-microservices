package com.test.code.array.easy;

/**
 * third maximum number in this array. If it does not exist, return the maximum number. The time
 * complexity must be in O(n).
 *
 * <p>Example 1: Input: [3, 2, 1]
 *
 * <p>Output: 1
 *
 * <p>Explanation: The third maximum is 1. Example 2: Input: [1, 2]
 *
 * <p>Output: 2
 *
 * <p>Explanation: The third maximum does not exist, so the maximum (2) is returned instead. Example
 * 3: Input: [2, 2, 3, 1]
 *
 * <p>Output: 1
 *
 * <p>Explanation: Note that the third maximum here means the third maximum distinct number. Both
 * numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] a = {1, 2,3,4,7};
    System.out.println(new ThirdMaximumNumber().thirdMax(a));
  }

  public int thirdMax(int[] nums) {
    int fm,sm, tm;
    fm = nums [0];
    sm = Integer.MIN_VALUE;
    tm = Integer.MIN_VALUE;
    for(int i=1; i<nums.length; i++){
        if(fm < nums [i] ){
          tm = sm;
          sm =fm;
          fm = nums[i];
        }else if (sm < nums[i]){
          tm =sm;
          sm = nums [i];
        }else if ( tm < nums[i]){
          tm = nums [i];
        }
    }
    return tm;
  }
}
