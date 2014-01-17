package bookexercise.list.chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex3_9 {
  
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    List<Integer> items = new ArrayList<Integer>();
    int i = 0;
    for (i = 0; i < 20; ++i) {
      items.add(i);
    } // end for
    list.addAll(items);
    System.out.println(list);
    
    list.removeAll(items);
    System.out.println(list);
  } // end main()

  static class LinkedList<T> {
    private Node<T> header;
    
    public LinkedList(){
      header = new Node<T>();
    } // end LinkedList()
    
    public void removeAll(Iterable<? extends T> items) {
      Node<T> current = null;
      Node<T> prev = null;
      Iterator<? extends T> iter = items.iterator();
      T data = null;
      
      while (iter.hasNext()) {
        data = iter.next();
        
        current = header.next;
        prev = header;
        
        while (current != null && !data.equals(current.data)) {
          current = current.next;
          prev = prev.next;
        } // end while
        if (data.equals(current.data)) {
          prev.next = prev.next.next;
        } // end if
        
        
      } // end while
      
    } // end removeAll()
    
    public void addAll(Iterable<? extends T> items) {
      Node<T> current = header;
      Iterator<? extends T> iter = items.iterator();
      Node<T> node;
      
    while (current.next != null) {
      current = current.next;
    } // end while
    while (iter.hasNext()) {
      node = new Node<T>(iter.next(), null);
      current.next = node;
      current = current.next;
    } // end while
    } // end addAll()
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      
      Node<T> node = header.next;
      sb.append("[");
      
      if (node != null) {
        sb.append(node.data);
        node = node.next;
      } // end if
      
      while (node != null) {
        sb.append("," + node.data);
        node = node.next;
      } // end while
      
      sb.append("]");
      
      return sb.toString();
    } // end toString()
    
    static class Node<T> {
      public T data;
      public Node<T> next;
      
      public Node(){}
      public Node(T d, Node<T> next){
        this.data = d;
        this.next = next;
      }
    } // end class Node
  } // end class LinkedList
}


