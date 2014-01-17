package bookexercise.list.chapter03;

public class Ex3_11 {
  
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    int i = 0;
    
    for (i = 0; i < 20; i += 2) {
      list.toggle(i);
      System.out.println(list);
    } // end for
    
    for (i = 0; i < 20; i += 2) {
      list.toggle(i);
      System.out.println(list);
    } // end for
  }
  

 
}

class LinkedList<AnyType> {
  private Node<AnyType> header;
  
  public LinkedList() {
    header = new Node<AnyType>();
  } // end LinkedList()
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    Node<AnyType> node = header.next;
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
  
  public boolean toggle(AnyType e) {
    Node<AnyType> current = header.next;
    Node<AnyType> prev = header;
    boolean isExist = false;
    
    while (current != null) {
      if (current.data.equals(e)) {
        isExist = true;
        break;
      } // end if
      else {
        current = current.next;
        prev = prev.next;
      } // end else
    } // end while
    
    if (isExist) {
      prev.next = prev.next.next;
    } // end if
    else {
      current = new Node<AnyType>(e, null);
      prev.next = current;
    } // end else
    
    return isExist;
  } // end toggle()
  
  public int size() {
    Node<AnyType> current = header.next;
    int size = 0;
    
    while (current != null) {
      current = current.next;
      ++size;
    } // end while
    
    return size;
  } // end size()
  
  static class Node<AnyType> {
    public AnyType data;
    public Node<AnyType> next;
    
    public Node() {
      data = null;
      next = null;
    }
    public Node(AnyType data, Node<AnyType> next) {
      this.data = data;
      this.next = next;
    }
  } // end class Node
  
}


