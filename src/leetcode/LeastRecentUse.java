package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentUse {
  
  public static void main(String[] args) {
    LRUCache s = new LRUCache(2);
    int i;
    
    s.set(2, 1);
    print(s);
    s.set(1, 1);
    print(s);
    s.get(2);
    print(s);
    s.set(4, 1);
    print(s);
    s.get(1);
    print(s);
    s.get(2);

  } // end main()
  
  public static void print(LRUCache cache) {
    LRUCache.Node head = cache.head;
    while (head != null) {
      System.out.printf("%d:%d,", head.key, head.data);
      head = head.next;
    } // end while
    System.out.println();
  } // end print
 
  static class LRUCache {
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
      size = 0;
      this.capacity = capacity;
      head = tail = null;
      map = new HashMap<Integer, Node>();
    } // end LRUCache()

    public int get(int key) {
      Node item = map.get(key);
      if (item != null) {
        moveToHead(item);
        return item.data;
      } // end if
      else {
        return -1;
      } // end else
    } // end get()

    public void set(int key, int value) {
      Node node = map.get(key);
      
      if (node != null) {
        node.data = value;
        moveToHead(node);
      } else {
        node = new Node();
        node.data = value;
        node.key = key;
        map.put(key, node);
        
        if (size != 0) {
          node.next = head;
          head.prev = node;
          head = node;
          if (size == capacity) {
            map.remove(tail.key);
            tail.prev.next = null;
            tail = tail.prev;
          } // end size == capacity: remove tail
          else {
            ++size;
          } // end else 
        } // end if size != 0
        else {
          size = 1;
          head = tail = node;
        } // end else: size == 0
      } // end else
    } // end set()
    

    private void moveToHead(Node item) {
      if (item != head) {
        item.prev.next = item.next;
        if (item != tail) {
          item.next.prev = item.prev;
        } // end if
        else {
          tail = item.prev;
        } // end else
        item.prev = null;
        item.next = head;
        head.prev = item;
        head = item;
      } // end if
    } // end moveToHead()
    
    static class Node{
      public int key;
      public int data;
      public Node prev;
      public Node next;
      
      public Node() {
        this.prev = this.next = null;
        this.data = this.key = 0;
      }
    } // end class Node
  } // end class LRUCache
  
} // end class LeastRecentUse
