package leetcode;

import java.util.Set;

public class WordBreak {

  static class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
      if (s == null || dict == null) {
        return false;
      } // end if
      int N = s.length() + 1;
      boolean[] flags = new boolean[N];
      flags[0] = true;
      int i, j;
      
      for (i = 1; i < N; ++i) {
        for (j = 0; j < i; ++j) {
          if (flags[j] && dict.contains(s.substring(j, i))) {
            flags[i] = true;
            break;
          } // end if
        } // end for
      } // end for
      return flags[N - 1];
    }
  } // end class Solution

}
