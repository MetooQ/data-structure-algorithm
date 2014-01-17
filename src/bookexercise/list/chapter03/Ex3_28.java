package bookexercise.list.chapter03;

public class Ex3_28 {
  
  public static void main(String[] args) {
    Deque<Integer> deque = new Deque<Integer>();
    int i = 0;
    
    for (i = 0; i < 10; ++i) {
      if (i % 2 == 0) {
        deque.push(i);
      } // end if
      else {
        deque.inject(i);
      } // end else
      System.out.println(deque);
    } // end for
    
    System.out.println(deque.reverseString());

  } // end main()
  
  static class Deque<T> {
    private Node<T> startMarker;
    private Node<T> endMarker;
    private int size;
    
    public String reverseString() {
      StringBuilder sb = new StringBuilder();
      Node<T> current = endMarker.prev;
      
      sb.append("[");
      if (current != startMarker) {
        sb.append(current.data);
        current = current.prev;
      } // end if
      
      while (current != startMarker) {
        sb.append("," + current.data);
        current = current.prev;
      } // end while
      
      sb.append("]");
      return sb.toString();
    } // end reverseString()
    
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
    
    public Deque() {
      size = 0;
      startMarker = new Node<T>();
      endMarker = new Node<T>(null, startMarker, null);
      startMarker.next = endMarker;
    } // end Deque()
    
    public void push(T e) {
      Node<T> node = new Node<T>(e, null, null);
      node.next = startMarker.next;
      node.next.prev = node;
      node.prev = startMarker;
      startMarker.next = node;
      ++size;
    } // end push()
    
    public T pop() {
      Node<T> node;
      node = startMarker.next;
      startMarker.next = node.next;
      node.next.prev = startMarker;
      --size;
      return node.data;
    } // end pop()
    
    public void inject(T e) {
      Node<T> node = new Node<T>(e, null, null);
      node.prev = endMarker.prev;
      node.next = endMarker;
      node.prev.next = node;
      endMarker.prev = node;
      ++size;
    } // end inject()
    
    public T eject() {
      Node<T> node = endMarker.prev;
      node.prev.next = endMarker;
      endMarker.prev = node.prev;
      --size;
      return node.data;
    } // end eject()
    
    
    public boolean isEmpty() {
      return size == 0;
    } // end isEmpty()
    
    
    static class Node<T> {
      public T data;
      public Node<T> prev;
      public Node<T> next;
      
      public Node(){}
      public Node(T d, Node<T> prev, Node<T> next) {
        this.data = d;
        this.prev = prev;
        this.next = next;
      } // end Node()
    } // end class Node
  } // end class Deque

} 
