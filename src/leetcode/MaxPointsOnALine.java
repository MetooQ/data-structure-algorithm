package leetcode;

/**
 * http://oj.leetcode.com/problems/max-points-on-a-line/
 * 
 * @author Administrator
 * 
 */

public class MaxPointsOnALine {
  public static void main(String[] args) {
    Point[] p = {new Point(0, 0), new Point(0, 0)};
    Solution s = new Solution();
    System.out.println(s.maxPoints(p));
  }

  static class Solution {
    public int maxPoints(Point[] points) {
      int result = 0;
      int i, len, currentLength = 0, vx2, vy2;
      int j, k;
      Point a, b, c;
      
      for (i = 0, len = points.length; i < len; ++i) {
        a = points[i];
        currentLength = 1;
        if (currentLength > result) {
          result = currentLength;
        }
        for (j = i + 1; j < len; ++j) {
          b = points[j];
          vx2 = b.x - a.x;
          vy2 = b.y - a.y;
          currentLength = 2;
          if (currentLength > result) {
            result = currentLength;
          }
          for (k = j + 1; k < len; ++k) {
            c = points[k];
            if ((c.x - a.x) * vy2 == (c.y - a.y) * vx2) {
              ++currentLength;
              if (currentLength > result) {
                result = currentLength;
              }
            } // end if
          } // end for k < len
        } // end for j < len
      } // end for i < len
      return result;
    } // end maxPoints()
  } // end class Solution

  static class Point {
    int x;
    int y;

    Point() {
      x = 0;
      y = 0;
    }

    Point(int a, int b) {
      x = a;
      y = b;
    }
  }
}


