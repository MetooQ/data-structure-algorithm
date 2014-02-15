package leetcode;

import java.util.HashMap;
import java.util.Map;

// http://oj.leetcode.com/problems/two-sum/

public class twoSum {
  
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] data = {2, 7, 11, 15};
    int[] result = s.twoSum(data, 9);
    System.out.println("index1:" + result[0] + " index2: " + result[1]);
  }

}

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int i, len;
    
    for (i = 0, len = numbers.length; i < len; ++i) {
      map.put(numbers[i], i);
    } // end for
    
    int remain;
    Integer index2;
    for (i = 0; i < len; ++i) {
      remain = target - numbers[i];
      if ((index2 = map.get(remain)) != null && index2 != i) {
        result[0] = i + 1;
        result[1] = map.get(remain) + 1;
        break;
      } // end if
    } // end for 
    
    return result;
  }
} // end class Solution









