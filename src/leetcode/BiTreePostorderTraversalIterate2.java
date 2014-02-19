package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BiTreePostorderTraversalIterate2 {
  
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

  static  class Solution {
      public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null, cur = null;
        
        if (root != null) {
          stack.push(root);
          while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
              if (cur.left != null) {
                stack.push(cur.left);
              } // end if
              else if (cur.right != null) {
                stack.push(cur.right);
              } // end else if
              else {
                result.add(cur.val);
                stack.pop();
              } // end else
            } // end if : traverse down
            
            else if (cur.left == prev) {
              if (cur.right != null) {
                stack.push(cur.right);
              } // end if
              else {
                result.add(cur.val);
                stack.pop();
              } // end else
            } // end else if : traverse up from left
            
            else if (cur.right == prev) {
              result.add(cur.val);
              stack.pop();
            } // end if traverse up from right
            
            prev = cur;
          } // end while
        } // end if
        return result;
      } // end postorderTraversal()


    } // end class Solution

}
