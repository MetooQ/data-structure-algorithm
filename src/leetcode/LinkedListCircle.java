package leetcode;

public class LinkedListCircle {

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  static class Solution {
    public boolean hasCycle(ListNode head) {
      if (head == null) { return false; }
      ListNode walker1 = head;
      ListNode walker2 = head.next;
      
      while (walker2 != null && walker1 != walker2) {
        walker1 = walker1.next;
        
        walker2 = walker2.next;
        if (walker2 != null) {
          walker2 = walker2.next;
        }
      } // end while

      if (walker2 != null && walker1 == walker2) {
        return true;
      } else {
        return false;
      } // end else
    }
  } // end class Solution

}
