package bookexercise.list.chapter03;

import bookexercise.list.chapter03.Ex3_37.LinkedList.Node;



public class Ex3_37 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int i = 0;
    
    for (i = 0; i < 10; ++i) {
      list.push(i);
    } // end for
    System.out.println(list);

    Node<Integer> node = list.get(3);
    list.insertBefore(node, 100);
    System.out.println(list);
    
    
    node = list.get(3);
    list.deleteNode(node);
    System.out.println(list);
  }

    
    static class LinkedList<T> {
      private Node<T> header;
      private Node<T> tail;
      
      public LinkedList() {
        tail = new Node<T>(null, null);
        header = new Node<T>(null, tail);
      } // end LinkedList()
      
      @Override
      public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = header.next;
        
        sb.append("[");
        if (current != tail) {
          sb.append(current.data);
          current = current.next;
        } // end if
        
        while (current != tail) {
          sb.append("," + current.data);
          current = current.next;
        } // end while
        
        sb.append("]");
        return sb.toString();
      } // end toString()
      
      public void push(T e) {
        Node<T> node = new Node<T>(e, header.next);
        header.next = node;
      } // end push()
      
      public Node<T> get(int index) {
        Node<T> current = header.next;
        while (index > 0) {
          --index;
          current = current.next;
        } // end while
        return current;
      } // end get
      
      public void insertBefore(Node<T> node, T e) {
        Node<T> next = new Node<T>(node.data, node.next);
        node.next = next;
        node.data = e;
      } // end insertBefore
      
      public T deleteNode(Node<T> node) {
        T value = node.data;
        node.data = node.next.data;
        node.next = node.next.next;
        return value;
      } // end deleteNode()
      
      static class Node<T> {
        public T data;
        public Node<T> next;
        
        public Node(){}
        public Node(T data, Node<T> next) {
          this.data = data;
          this.next = next;
        } // end Node()
      } // end class Node
    } // end class LinkedList

}
