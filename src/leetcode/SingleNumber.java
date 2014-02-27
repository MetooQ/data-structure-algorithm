package leetcode;

public class SingleNumber {
  public static void main(String[] args) {
    int[] data = {1, 1, 2, 2, 3, 3, 4};
    Solution s = new Solution();
    System.out.println(s.singleNumber(data));
  }

  static class Solution {
    public int singleNumber(int[] A) {
      int result = 0;
      int i, len = A.length;
      
      if (len == 1) {
        return A[0];
      }
      
      for (i = 0, len = A.length; i < len; ++i) {
        result ^= A[i];
      }
      
      return result;
    }
  } // end class solution

}
