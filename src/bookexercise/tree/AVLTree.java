package bookexercise.tree;

public class AVLTree<T extends Comparable<T>> {
  private Node<T> root;
  
  public AVLTree() {} // end AVLTree()
  
  public void add(T e) {
    root = avlAdd(root, e);
  }; // end Add
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    format(root, 0, sb);
    return sb.toString();
  } // end toString()
  
  private void format(Node<T> t, int height, StringBuilder out) {
    if (t != null) {
      format(t.right, height + 1, out);
      for (int i = 0; i < height; ++i) {
        out.append("  ");
      } // end for
      out.append(t.data + "\n");
      format(t.left, height + 1, out);
    } // end if
  } // end format()
  
  // 将数据e插入到树t中，并返回更新后的根节点
  private Node<T> avlAdd(Node<T> t, T e) {
    if (t == null) {
      return new Node<T>(e, null, null);
    } // end if
    
    int result = e.compareTo(t.data);
    if (result < 0) {
      t.left = avlAdd(t.left, e);
      if (height(t.left) - height(t.right) == 2) {
        if (e.compareTo(t.left.data) < 0) {
          t = rightRotate(t);
        } // end if (left-left insert: rightRotate t)
        else {
          t = leftRightRotate(t);
        } // end else (left-right insert, leftRightRotate t)
      } // end if
    } // end if 
    else if (result > 0) {
      t.right = avlAdd(t.right, e);
      if (height(t.right) - height(t.left) == 2) {
        if (e.compareTo(t.right.data) < 0) {
          t = rightLeftRotate(t);
        } // end if (right-left insert, rightLeftRotate)
        else {
          t = leftRotate(t);
        } // end else (right-right insert, leftRotate)
      } // end if
    } // end else
    
    t.height = Math.max(height(t.left), height(t.right)) + 1;
    return t;
  } // end add()
  
  private Node<T> rightLeftRotate(Node<T> k1) {
    k1.right = rightRotate(k1.right);
    return leftRotate(k1);
  } // end rightLeftRotate()
  
  // 对k3.left进行左旋转，然后对d3进行右旋转
  private Node<T> leftRightRotate(Node<T> k3) {
    k3.left = leftRotate(k3.left);
    return rightRotate(k3);
  } // end leftRightRotate()
  
  // 将k1向左旋转，用k1.right替代它
  private Node<T> leftRotate(Node<T> k1) {
    Node<T> k2 = k1.right;
    k1.right = k2.left;
    k2.left = k1;
    
    k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
    
    return k2;
  } // end singleRightRotate()
  
  // 将k3向右旋转：用k3.left替代它
  private Node<T> rightRotate(Node<T> k3) {
    Node<T> k2 = k3.left;
    
    k3.left = k3.right;
    k3.right = k3;
    
    k3.height = Math.max(height(k3.left), height(k3.right)) + 1;
    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
    
    return k2;
  } // end singleLeftRotate()
  
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
    public Node(T data, Node<T> left, Node<T> right) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.height = 0;
    } // end Node
  } // end class Node
  
  
  public static void main(String[] args) {
    AVLTree<Integer> tree = new AVLTree<Integer>();
    int i = 0;
    
    for (i = 1; i < 8; ++i) {
      tree.add(i);
    } // end for
    
    System.out.println(tree);
  }
} // end class AVLTree
