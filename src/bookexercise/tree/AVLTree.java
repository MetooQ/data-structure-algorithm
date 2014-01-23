package bookexercise.tree;

import java.util.Stack;

public class AVLTree<T extends Comparable<T>> {
  private Node<T> root;

  public AVLTree() {
  } // end AVLTree()

  public void add(T e) {
    root = avlAdd(root, e);
  }; // end Add

  public void delete(T e) {
    root = deleteItem(root, e);
  } // end delete()

  public boolean isAVLTree() {
    return isAVL(root);
  }

  private boolean isAVL(Node<T> t) {
    if (t == null) {
      return true;
    } // end if
    else {
      int bal = balance(t);
      return bal < 2 && bal > -2 && isAVL(t.left) && isAVL(t.right);
    } // end else
  } // end isAVL()

  /**
   * ��AVLTree��ɾ���ڵ㣬����ڵ�ΪҶ�ڵ㣬ֱ��ɾ��������ڵ���һ���ӽڵ㣬ɾ�������ӽڵ����
   * ����ڵ��������ӽڵ㣬���߼���̽ڵ㣨����������С�ڵ㣩�����ɾ����������С�ڵ�
   * 
   * @param t
   * @param e
   * @return
   */
  private Node<T> deleteItem(Node<T> t, T e) {
    Node<T> p = null;
    Node<T> l = null;
    Node<T> child = null;
    Node<T> temp = null;
    Stack<Node<T>> path = new Stack<Node<T>>(); // �������·�������ڻ��ݼ��ƽ������
    int cmp = 0;
    int balance = 0;

    // ������Ҫɾ���Ľڵ�
    if (t == null) {
      return null;
    } // end if
    cmp = e.compareTo(t.data);
    if (cmp < 0) {
      t.left = deleteItem(t.left, e);
    } // end if
    else if (cmp > 0) {
      t.right = deleteItem(t.right, e);
    } // end if-else
    else {

      // �����Ҫɾ���Ľڵ�û�����������������������
      if (t.right == null) {
        return t = t.left;
      } // end if

      // ����ڵ�t������rû������������������r����t
      else if (t.right.left == null) {
        return t = t.right;
      } // end else-if

      // ����ڵ�t������r�������������������ʱt�ĺ�̽ڵ����t��ɾ������ڵ�
      else {
        l = t.right.left;
        p = t.right;
        path.push(p);
        while (l.left != null) {
          l = l.left;
          p = p.left;
          path.push(p);
        } // end while
        t.data = l.data;
        p.left = l.right;

        while (!path.isEmpty()) {
          p = path.pop();
          balance = balance(p);
          if (balance == -2) {
            balance = balance(p.right);
            if (balance == -1 || balance == 0) {
              leftRotate(p);
            } else if (balance == 1) {
              rightLeftRotate(p);
            } // end else
          } // end if

          p.height = Math.max(height(p.left), height(p.right)) + 1;
        } // end while

      } // end else

    } // end else

    // ɾ��t֮�󣬿��ܵ��¸��ڵ㲻ƽ��
    t.height = Math.max(height(t.left), height(t.right)) + 1;
    balance = balance(t);
    if (balance == 2) {
      balance = balance(t.left);
      if (balance == 1 || balance == 0) {
        t = rightRotate(t);
      } // end if
      else if (balance == -1) {
        t = leftRightRotate(t);
      }
    } // end if
    else if (balance == -2) {
      balance = balance(t.right);
      if (balance == -1 || balance == 0) {
        t = leftRotate(t);
      } // end if
      else if (balance == 1) {
        t = leftRightRotate(t);
      }
    } // end if

    return t;
  } // end delete()

  private int balance(Node<T> t) {
    return height(t.left) - height(t.right);
  } // end balance()

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("|------------------\n");
    format(root, 0, sb);
    sb.append("|------------------\n");
    return sb.toString();
  } // end toString()

  private void format(Node<T> t, int height, StringBuilder out) {
    if (t != null) {
      format(t.right, height + 1, out);
      for (int i = 0; i < height; ++i) {
        out.append("  ");
      } // end for
      out.append(t.data + "           " + t.height + "           " + balance(t)
          + "\n");
      format(t.left, height + 1, out);
    } // end if
  } // end format()

  // ������e���뵽��t�У������ظ��º�ĸ��ڵ�
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

  // ��k3.left��������ת��Ȼ���d3��������ת
  private Node<T> leftRightRotate(Node<T> k3) {
    k3.left = leftRotate(k3.left);
    return rightRotate(k3);
  } // end leftRightRotate()

  // ��k1������ת����k1.right�����
  private Node<T> leftRotate(Node<T> k1) {
    Node<T> k2 = k1.right;
    k1.right = k2.left;
    k2.left = k1;

    k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
    k2.height = Math.max(height(k2.left), height(k2.right)) + 1;

    return k2;
  } // end singleRightRotate()

  // ��k3������ת����k3.left�����
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
    int SIZE = 32;
    int i = 0;

    for (i = 1; i < SIZE; ++i) {
      tree.add(i);
    } // end for

    System.out.println(tree);

    for (i = 1; i < SIZE; ++i) {
      tree.delete(i);
      System.out.println(tree.toString() + tree.isAVLTree());
    } // end for

  }
} // end class AVLTree
