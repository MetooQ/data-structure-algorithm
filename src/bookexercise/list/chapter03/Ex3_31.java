package bookexercise.list.chapter03;

public class Ex3_31 {
  
  static class Stack<T> {
    private Node<T> header;
    
    public Stack(){
      header = null;
    } // end Stack()
    
    public T pop() {
      Node<T> node = header;
      header = header.next;
      return node.data;
    } // end pop()
    
    public void push(T e) {
      Node<T> node = new Node<T>(e, null);
      node.next = header;
      header = node;
    } // end push()
    
    @Override
    public String toString(){
      StringBuilder sb = new StringBuilder();
      Node<T> current = header;
      
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
    
    static class Node<T> {
      public T data;
      public Node<T> next;
      
      public Node() {}
      public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
      } // end Node()
    } // end Node
  } // end class Stack

}
 