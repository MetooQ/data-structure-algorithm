package leetcode;

public class Candy {

  static class Solution {
    public int candy(int[] ratings) {
      int i, sum = 0, current = 1, 
          len = ratings.length,
          cmp;
        
      
      if (len == 1) {
        return 1;
      } // end if

      sum = current = 1;
      for (i = 1; i < len; ++i) {
          cmp = ratings[i] - ratings[i - 1];
          if (cmp > 0) {
            ++current;
          } else if (cmp < 0) {
            --current;
            current = current <= 0 ? 1 : current;
          }
          sum += current;
      } // end for
      
      return sum;
    }
  } // end Solution

}
