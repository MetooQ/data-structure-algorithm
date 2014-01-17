package bookexercise.list.chapter03;

public class Ex3_30 {
  
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int i = 0;
    
    for (i = 0; i < 10; ++i) {
      list.push(i);
      System.out.println(list);
    } // end for
    
    for (i = 0; i < 10; ++i) {
      list.search(i);
      System.out.println(list);
    } // end for
    
  } // end main()
  
  static class LinkedList<T> {
    private Node<T> startMarker;
    private Node<T> endMarker;
    private int size;
    
    public LinkedList() {
      startMarker = new Node<T>();
      endMarker = new Node<T>(null, startMarker, null);
      startMarker.next = endMarker;
      size = 0;
    } // end LinkedList()
    
    public boolean search(T e) {
      Node<T> current = startMarker.next;
      boolean isExist = false;
      
      while (current != endMarker) {
        if (current.data.equals(e)) {
          isExist = true;
          break;
        } // end if
        else {
          current = current.next;
        } // end else
      } // end while
      
      if (isExist) {
        current.prev.next = current.next;
        current.next.prev = current.prev;
        
        current.next = startMarker.next;
        current.prev = startMarker;
        startMarker.next.prev = current;
        startMarker.next = current;
      } // end if
      
      return isExist;
    } // end search()
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node<T> current = startMarker.next;
      
      sb.append("[");
      if (current != endMarker) {
        sb.append(current.data);
        current = current.next;
      } // end if
      
      while (current != endMarker) {
        sb.append("," + current.data);
        current = current.next;
      } // end while
      
      sb.append("]");
      return sb.toString();
    } // end toString()
    
    public void push(T e) {
      Node<T> node = new Node<T>(e, null, null);
      node.next = startMarker.next;
      node.prev = startMarker;
      startMarker.next.prev = node;
      startMarker.next = node;
      ++size;
    } // end push()
    
    static  class Node<T> {
      public T data;
      public Node<T> prev;
      public Node<T> next;
      
      public Node(){}
      public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
      } // end Node()
    } // end class Node
  } // end class LinkedList

}
