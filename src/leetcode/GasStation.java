package leetcode;

public class GasStation {

  static class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int sum = 0,
          total = 0,
          index = -1,
          len = gas.length,
          i;
      
      for (i = 0; i < len; ++i) {
        sum += gas[i] - cost[i];
        total += gas[i] - cost[i];
        if (sum < 0) {
          sum = 0;
          index = i;
        }
      } // end for
      
      return total >= 0 ? index + 1 : -1;
    }
  } // end class Solution

}
