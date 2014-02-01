package bookexercise.tree.chapter04;

public class Ex4_19 {
  
  static class AVLTree<T extends Comparable<T>> {
    private Node<T> root;
    
    public AVLTree() {
      root = null;
    } // end AVLTree()
    
    public void add(T e) {
      int cmp = 0;
      Node<T> node = new Node<T>(e);
      Node<T> current = null;
      Node<T> p = null;
      int balance = 0;
      
      if (root == null) {
        root = node;
        return;
      } // end if
      
      while (current != null) {
        cmp = e.compareTo(current.data);
        p = current;
        if (cmp < 0) {
          current = current.left;
        } // end if
        else if (cmp > 0) {
          current = current.right;
        } // end if
      } // end while
      
      
    } // end add()
    
    private Node<T> rightLeftRotate(Node<T> k1) {
      Node<T> k3 = k1.right;
      Node<T> k2 = k3.left;
      
      k1.right = k2.left;
      k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
      
      k3.left = k2.right;
      k3.height = Math.max(height(k3.left), height(k3.right)) + 1;
      
      k2.left = k1;
      k2.right = k3;
      k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
      
      return k2;
    } // end rightLeftRotate()
    
    private Node<T> leftRightRotate(Node<T> k3) {
      Node<T> k1 = k3.left;
      Node<T> k2 = k1.right;
      
      k1.right = k2.left;
      k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
      
      k3.left = k2.right;
      k3.height = Math.max(height(k3.left), height(k3.right)) + 1;
      
      k2.left = k1;
      k2.right = k3;
      k3.height = Math.max(height(k3.left), height(k3.right)) + 1;
      
      return k2;
    } // end leftRightRotate()
    
    private Node<T> rightRotate(Node<T> k3) {
      Node<T> k2 = k3.left;
      
      k3.left = k2.right;
      k3.height = Math.max(height(k3.left), height(k3.right)) + 1;
      
      k2.right = k3;
      k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
      
      return k2;
    } // end rightRotate()
    
    private Node<T> leftRotate(Node<T> k1) {
      Node<T> k2 = k1.right;
      
      k1.right = k2.left;
      k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
      
      k2.left = k1;
      k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
      
      return k2;
    } // end leftRotate()
    
    private int balance(Node<T> t) {
      return height(t.left) - height(t.right);
    } // end balance()
    
    private int height(Node<T> t) {
      return t == null ? -1 : t.height;
    } // end height()
    
    static class Node<T> {
      public T data;
      public Node<T> left;
      public Node<T> right;
      public int height;
      
      public Node() {
        this(null, null, null);
      }
      public Node(T data) {
        this(data, null, null);
      }
      public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = 0;
      } // end Node()
    } // end class Node
  } // end class AVLTree

}
