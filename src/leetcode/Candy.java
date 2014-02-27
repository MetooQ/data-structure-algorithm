package leetcode;

public class Candy {

  static class Solution {
    public int candy(int[] ratings) {
      int sum = 0, i = 1, len = ratings.length,
          cmp;
      int[] candies = new int[len];

      if (len == 1) {
        return 1;
      }
      
      candies[0] = 1;
      for (i = 1; i < len; ++i) {
        cmp = ratings[i] - ratings[i - 1];
        if (cmp > 0) {
          candies[i] = candies[i - 1] + 1;
        } else {
          candies[i] = 1;
        }
      } // end for
      
      sum = candies[len - 1];
      for (i = len - 2; i >= 0; --i) {
        if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
          candies[i] = candies[i + 1] + 1;
        }
        sum += candies[i];
      } // end for

      return sum;
    }
  } // end Solution

}
