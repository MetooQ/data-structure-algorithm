package leetcode;

public class LinkedListCircle2 {

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
      
      ListNode fast = head;
      ListNode slow = head;
      
      while (true) {
        if (fast.next == null || fast.next.next == null) {
          return false;
        } // end if
        
        fast = fast.next.next;
        slow = slow.next;
        
        if (fast == slow) {
          return true;
        } // end if
      } // end while
    }
  } // end class Solution

}
