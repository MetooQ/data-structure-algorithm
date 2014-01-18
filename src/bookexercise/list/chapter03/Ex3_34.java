package bookexercise.list.chapter03;

public class Ex3_34 {
  
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int i = 0;
    
    for (i = 0; i < 10; ++i) {
      list.push(i);
    }
    
    list.makeCircle(4);
    
    System.out.println(list + " hasCircle: " + list.hasCircle());
  }
  
  static class LinkedList<T> {
    private Node<T> header;
    private Node<T> tail;
    
    public LinkedList() {
      tail = new Node<T>();
      header = new Node<T>(null, tail);
    } // end LinkedList()
    
    public boolean hasCircle() {
      boolean isCircle = false;
      Node<T> p = header.next; // two step
      Node<T> q = header.next; // one step
      
      if (p != null && p.next != null && q != null) {
        p = p.next.next;
        q = q.next;
      } // end if
      
      while (p != null && p.next != null && q != null && p != q) {
        p = p.next.next;
        q = q.next;
      } // end while
      
      if (p == q && p != null) {
        isCircle = true;
      } // end if
      
      return isCircle;
    } // end while
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node<T> current = header.next;
      
      sb.append("[");
      if (current != tail) {
        sb.append(current.data);
        current = current.next;
      } // end tail
      
      while (current != tail) {
        sb.append("," + current.data);
        current = current.next;
      } // end while
      
      sb.append("]");
      
      if (tail.next != null) {
        sb.append("circle start: " + tail.next.data);
      } // end if
      
      return sb.toString();
    } // end toString()
    
    public void makeCircle(int n) {
      Node<T> node = header;
      
      while (n >= 1) {
        node = node.next;
        --n;
      } // end while
      
      tail.next = node;
    } // end makeCircle()
    
    public void push(T e) {
      Node<T> node = new Node<T>(e, null);
      node.next = header.next;
      header.next = node;
    } // end push()
    
    static class Node<T> {
      public T data;
      public Node<T> next;
      
      public Node() {}
      public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
      } // end Node()
    } // end class Node
  } // end class LinkedList

}
