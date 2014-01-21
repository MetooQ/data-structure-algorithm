package bookexercise.tree;

public class AVLTree<T implements Comparable> {
  private Node<T> root;
  
  public AVLTree() {} // end AVLTree()
  
  public void add(T e) {
    root = avlAdd(root, e);
  }; // end Add
  
  // 将数据e插入到树t中，并返回更新后的根节点
  private Node<T> avlAdd(Node<T> t, T e) {
    if (t == null) {
      return new Node<T>(e, null, null);
    } // end if
    
    int result = t.data.
  } // end add()
  

  public static <E> void print(E[] list){}
  public static <E> void print(E[] list) {}
  public static <E> void print(E[] list) {}

  static class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;
    public int height;
    
    public Node() {
      this(null, null, null);
    }
    public Node(T data, Node<T> left, Node<T> right) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.height = 0;
    } // end Node
  } // end class Node
} // end class AVLTree
