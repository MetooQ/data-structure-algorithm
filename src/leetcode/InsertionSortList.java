package leetcode;

public class InsertionSortList {
  public static void main(String[] args) {
    ListNode list = new ListNode(0);
    ListNode temp;
    int i;
    
//    for (i = 1; i <= 10; ++i) {
//      temp = new ListNode(i);
//      temp.next = list;
//      list = temp;
//    }
//    
    print(list);
    
    Solution s = new Solution();
    list = s.insertionSortList(list);
    print(list);

    list = s.insertionSortList(list);
    print(list);
  } // end main()
  
  public static void print(ListNode head) {
    while (head != null) {
      System.out.print(head.val + ",");
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
    public ListNode insertionSortList(ListNode head) {
     
     if (head == null) {
       return null;
     } // end if
     
     ListNode result = head;
     ListNode temp, current, pre;
     
     head = head.next;
     result.next = null;
     while (head != null) {
       temp = head;
       head = head.next;
       if (temp.val < result.val) {
         temp.next = result;
         result = temp;
       } // end if
       else {
         current = result.next;
         pre = result;
         while (current != null && temp.val > current.val) {
           current = current.next;
           pre = pre.next;
         } // end while
         if (current == null) {
           pre.next = temp;
           temp.next = null;
         } // end if
         else {
           temp.next = current;
           pre.next = temp;
         } // end else
       } // end else
     } // end while
     
     return result;
    } // end insertionSortList()
  } // end class Solution

}
