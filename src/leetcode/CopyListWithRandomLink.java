package leetcode;

public class CopyListWithRandomLink {
  public static final int SIZE = 5;

  public static void main(String[] args) {
    RandomListNode[] data = new RandomListNode[SIZE];
    int i;
    
    for (i = 0; i < SIZE; ++i) {
      data[i] = new RandomListNode(i);
    } // end for
    for (i = 0; i < SIZE - 1; ++i) {
      data[i].next = data[i + 1];
    }
    data[SIZE - 1].next = null;
    for (i = SIZE - 1; i > 0; --i) {
      data[i].random = data[i - 1];
    }
    data[0].random = null;
    
    
    Solution s = new Solution();
    
    print(s.copyRandomList(data[0]));
    
  } // end main()

  public static void print(RandomListNode list) {
    while (list != null) {
      System.out.printf("(%d %d)", list.label, 
          list.random == null ? -1 : list.random.label);
      list = list.next;
    }
  } // end print()
  
  static class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
      this.label = x;
    }
  };

  static class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
      if (head == null) {
        return null;
      } // end if
      
      RandomListNode walker = head, temp, copy;
      while (walker != null) {
        temp = new RandomListNode(walker.label);
        temp.next = walker.next;
        
        walker.next = temp;
        walker = walker.next.next;
      } // end while
      
      walker = head;
      while (walker != null) {
        if (walker.random != null) {
          walker.next.random = walker.random.next;
        } // end if
        walker = walker.next.next;
      } // end while
      
      copy = head.next;
      walker = head;
      while (walker != null) {
        temp = walker.next;
        walker.next = temp.next;
        if (temp.next != null) {
          temp.next = temp.next.next;
        } // end if
        walker = walker.next;
      } // end while

      return copy;
      
    } // end copyRandomList()
  } // end class solution

}
