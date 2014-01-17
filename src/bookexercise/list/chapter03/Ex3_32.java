package bookexercise.list.chapter03;

public class Ex3_32 {
  
  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<Integer>();
    int i = 0;
    
    for (i = 0; i < 10; ++i) {
      queue.enqueue(i);
      System.out.println(queue);
    } // end for
  }
  
  static class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    
    public T dequeue() {
      Node<T> node = front;
      
      front = front.next;
      if (front == null) {
        front = rear = null;
      } // end if
      
      return node.data;
    } // end dequeue()
    
    public void enqueue(T e) {
      Node<T> node = new Node<T>(e, null);
      
      if (rear != null) {
        rear.next = node;
        rear = node;
      } // end if
      else {
        front = rear = node;
      } // end else
    } // end enqueue()
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node<T> current = front;
      
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
    
    public Queue() {
      front = null;
      rear = null;
    } // end Queue()
    
    static class Node<T> {
      public T data;
      public Node<T> next;
      
      public Node() {}
      public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
      } // end Node()
    } // end class Node
  } // end class Queue

}
