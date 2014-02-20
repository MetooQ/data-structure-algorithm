package leetcode;

// http://oj.leetcode.com/problems/reorder-list/

public class ReorderList {
  
  public static void main(String[] args) {
    ListNode node = new ListNode(5);
    ListNode temp = new ListNode(4);
    temp.next = node;
    node = temp;
    temp = new ListNode(3);
    temp.next = node;
    node = temp;
    temp = new ListNode(2);
    temp.next = node;
    node = temp;
    temp = new ListNode(1);
    temp.next = node;
    node = temp;
    temp = new ListNode(0);
    temp.next = node;
    node = temp;
    
    print(node);
    Solution s = new Solution();
    s.reorderList(node);
    print(node);
  }
  
  static void print(ListNode list) {
    while (list != null) {
      System.out.printf("%d, ",  list.val);
      list = list.next;
    }
    System.out.println();
  } 

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  
  

  // 0 1   2 3   4 5   6 7
  static class Solution {
    public void reorderList(ListNode head) {
      if (head == null || head.next == null) { return; }
      
      ListNode walker = head.next.next;
      ListNode marker = head;
      ListNode mid = null;
      ListNode temp = null;
      
      // get last half: marker.next
      while (walker != null) {
        marker = marker.next;
        walker = walker.next;
        if (walker != null) {
          walker = walker.next;
        } // end if
      } // end while
      
      walker = marker.next;
      marker.next = null;
      
      // reverse last half
      while (walker != null) {
        temp = walker;
        walker = walker.next;
        temp.next = mid;
        mid = temp;
      } // end while
      
      walker = head.next;
      marker = head.next = mid;
      mid = mid.next;
      
      // get together
      while (walker != null && mid != null) {
        temp = walker;
        walker = walker.next;
        marker.next = temp;
        marker = temp;
        
        temp = mid;
        mid = mid.next;
        marker.next = temp;
        marker = temp;
      } // end while
      
      if (walker != null) {
        marker.next = walker;
      }

    }
  } // end class Solution

}
