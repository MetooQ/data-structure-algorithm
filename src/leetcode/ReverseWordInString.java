package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ReverseWordInString {
  public static void main(String[] args) {
    Solution s = new Solution();
    String a = "a b c";
    String ra = "c b a";

    System.out.println(a + " reverse: " + s.reverseWords(a));

    System.out.println("null reverse: " + s.reverseWords(null));

  }

  static class Solution {
    public String reverseWords(String s) {

      if (s == null || s.length() == 0) {
        return s;
      } // end if

      Scanner input = new Scanner(s);
      Deque<String> stack = new LinkedList<String>();
      StringBuilder sb = new StringBuilder();

      while (input.hasNext()) {
        stack.push(input.next());
      } // end while

      if (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      while (!stack.isEmpty()) {
        sb.append(" ").append(stack.pop());
      } // end while

      return sb.toString();
    }
  } // end class Solution

}
