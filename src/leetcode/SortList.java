package leetcode;

public class SortList {
  public static void main(String[] args) {
    ListNode list = new ListNode(1);
    ListNode temp = null;
    int i;
    
    for (i = 2; i <= 10; ++i) {
      temp = new ListNode(i);
      temp.next = list;
      list = temp;
    } // end for
    
    print(list);
    
    Solution s = new Solution();
    list = s.sortList(list);
    
    print(list);
    
  } // end main()
  
  public static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + ", ");
      head = head.next;
    }
  } // end print()

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  static class Solution {
    public ListNode sortList(ListNode head) {
      int len = length(head);
      if (len <= 1) {
        return head;
      } // end if
      
      ListNode left = head;
      ListNode right = null;
      for (len /= 2; len >= 2; --len) {
        left = left.next;
      } // end for
      right = left.next;
      left.next = null;
      left = head;
      
      left = sortList(left);
      right = sortList(right);
      return merge(left, right);

    } // end sortList()

    public int length(ListNode head) {
      int len = 0;
      while (head != null) {
        ++len;
        head = head.next;
      } // end while
      return len;
    } // end length()

    public ListNode merge(ListNode a, ListNode b) {
      ListNode result = null;
      ListNode current = null;
      if (a.val < b.val) {
        result = a;
        a = a.next;
      } // end if
      else {
        result = b;
        b = b.next;
      } // end else
      current = result;

      while (a != null && b != null) {
        if (a.val < b.val) {
          current.next = a;
          a = a.next;
        } // end while
        else {
          current.next = b;
          b = b.next;
        } // end else
        current = current.next;
      } // end while

      if (b != null) {
        a = b;
      } // end if
      while (a != null) {
        current.next = a;
        a = a.next;
        current = current.next;
      } // end while
      return result;
    } // end merge()
  } // end class Solution

}
