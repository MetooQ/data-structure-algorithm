package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BiTreePostorderTraversal {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
      ArrayList<Integer> result = new ArrayList<Integer>();
      post(root, result);
      return result;
    } // end postorderTraversal()
    
    private void post(TreeNode root, ArrayList<Integer> result) {
      if (root != null) {
        post(root.left, result);
        post(root.right, result);
        result.add(root.val);
      } // end if
    } // end post()

  } // end class Solution
  
  
} // end class BiTreePostorderTraversal
