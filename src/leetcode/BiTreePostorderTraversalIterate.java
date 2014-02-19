package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BiTreePostorderTraversalIterate {
  
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
        Stack<TreeNode> output = new Stack<TreeNode>();
        TreeNode item = null;
        
        if (root != null) {
          stack.push(root);
          while (!stack.isEmpty()) {
            item = stack.pop();
            output.push(item);
            if (item.left != null) {
              stack.push(item.left);
            } // end if
            if (item.right != null ){
              stack.push(item.right);
            } // end if
          } // end while
          while (!output.isEmpty()) {
            result.add(output.pop().val);
          } // end while
        } // end if
        
        return result;
      } // end postorderTraversal()


    } // end class Solution

}
