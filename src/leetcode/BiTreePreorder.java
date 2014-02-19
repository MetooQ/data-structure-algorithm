package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BiTreePreorder {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode prev = null, cur;

      if (root != null) {
        stack.push(root);
        while (!stack.isEmpty()) {
          cur = stack.pop();
          result.add(cur.val);
          if (cur.right != null) {
            stack.push(cur.right);
          } // end if
          if (cur.left != null) {
            stack.push(cur.left);
          } // end if
        } // end while
      } // end if

      return result;
    }
  } // end class Solution

}
