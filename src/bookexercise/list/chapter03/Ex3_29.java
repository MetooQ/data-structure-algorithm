package bookexercise.list.chapter03;

public class Ex3_29 {
  
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int i = 0;
    
    for (i = 0; i < 10; ++i) {
      list.push(i);
      System.out.println(list);
    } // end for
    
    list.reverse();
    System.out.println(list);
  }
  
  static class LinkedList<T> {
    private Node<T> header;
    
    public void reverse() {
      Node<T> current = header.next;
      Node<T> rest = null;
      header.next = null;
      
      while (current != null) {
        rest = current.next;
        current.next = header.next;
        header.next = current;
        current = rest;
      } // end while
      
    } // end reverse()
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node<T> current = header.next;
      
      sb.append("[");
      if (current != null) {
        sb.append(current.data);
        current = current.next;
      } // end if
      
      while (current != null) {
        sb.append("," + current.data);
        current = current.next;
      } // end while
      
      sb.append("]");
      return sb.toString();
    } // end toString()
    
    public void push(T e) {
      Node<T> node = new Node<T>(e, null);
      node.next = header.next;
      header.next = node;
    } // end push()
    
    public LinkedList(){
      header = new Node<T>();
    } // end LinkedList()
    
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
