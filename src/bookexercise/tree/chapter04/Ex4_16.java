package bookexercise.tree.chapter04;

public class Ex4_16 {
  public static void main(String[] args) {
    SearchTree<Integer> tree = new SearchTree<Integer>();
    
    for (int i = 0; i < 10; ++i) {
      tree.add(i);
      System.out.println("max:" + tree.findMax());
    } // end for
    System.out.println(tree);
    
    for (int i = 0; i < 10; ++i) {
      tree.lazyDelete(i);
      System.out.println("min:" + tree.findMin());
    } // end for
    System.out.println(tree);
    
    
    
    
  } // end main()
  
  static class SearchTree<T extends Comparable<T>> {
    private Node<T> root;
    
    public SearchTree() {
      this.root = null;
    } // end SearchTree()
    
    public T findMax() {
      return max(root);
    } // end findMax()
    private T max(Node<T> t) {
      if (t == null) {
        return null;
      } // end if
      
      T max = null;
      T right = max(t.right);
      if (right != null) {
        max = right;
      } // end if
      else if (t.isExist) {
        max = t.data;
      } // end if
      else {
        max = max(t.left);
      } // end else
      
      
      return max;
    } // end max()
    
    public T findMin() {
      return min(root);
    } // end findMin()
    private T min(Node<T> t) {
      if (t == null) {
        return null;
      } // end if
      T min = null;
      
      T left = min(t.left);
      if (left != null) {
        min = left;
      } // end if
      else if (t.isExist) {
        min = t.data;
      } // end else-if
      else {
        min = min(t.right);
      } // end else
      
      return min;
    } // end min()
    
    public void lazyDelete(T e) {
      int cmp = 0;
      Node<T> current = root;
      Node<T> p = null;
      
      while (current != null) {
        cmp = e.compareTo(current.data);
        if (cmp < 0) {
          current = current.left;
        } // end if
        else if (cmp > 0) {
          current = current.right;
        } // end else-if
        else {
          current.isExist = false;
          break;
        } // end else
      } // end while
      
      
    } // end lazyDelete()
    
    public void add(T e) {
      Node<T> node = new Node<T>(e, null, null);
      Node<T> current = null;
      Node<T> p = null;
      int cmp = 0;
      
      if (root == null) {
        root = node;
        return;
      } // end if
      
      current = root;
      while (current != null) {
        cmp = e.compareTo(current.data);
        if (cmp < 0) {
          p = current;
          current = p.left;
        } // end if
        else if (cmp > 0) {
          p = current;
          current = p.right;
        } // end else-if
        else {
          if (!current.isExist) {
            current.isExist = true;
          }
          break;
        } // end if
      } // end while
      
      if (current == null) {
        if (cmp < 0) {
          p.left = node;
        } else {
          p.right = node;
        } // end else
      } // end if
      
    } // end add()
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("|------------------------\n");
      appendNode(root, sb, 0);
      sb.append("|------------------------\n");
      return sb.toString();
    } // end toString()
    
    private void appendNode(Node<T> t, StringBuilder sb, int height) {
      if (t != null) {
        appendNode(t.right, sb, height + 1);
        for (int i = 0; i < height; ++i) {
          sb.append(" ");
        } // end for
        sb.append(t.data + " " + t.isExist + "\n");
        appendNode(t.left, sb, height + 1);
      } // end if
    } // end appendNode()
    
    static class Node<T> {
      public T data;
      boolean isExist;
      public Node<T> left;
      public Node<T> right;
      
      public Node() {
        this(null, null, null);
      }
      public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.isExist = true;
      } // end Node
    } // end class Node
  } // end class SearchTree

}
