package bookexercise.tree;

public class SearchTree<T extends Comparable<T>> {
  private Node<T> root;
  private int size;

  public SearchTree() {
    root = null;
    size = 0;
  } // end SearchTree()

  public boolean isEmpty() {
    return root == null;
  } // end isEmpty()

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("|---------------------\n");
    attachNode(root, sb, 0);
    sb.append("|---------------------");
    return sb.toString();
  } // end toString()

  private void attachNode(Node<T> t, StringBuilder sb, int height) {
    if (t != null) {
      attachNode(t.right, sb, height + 1);
      for (int i = 0; i < height; ++i) {
        sb.append(" ");
      } // end for
      sb.append(t.data + "\n");
      attachNode(t.left, sb, height + 1);
    } // end if
  } // end attachNode()

  public boolean delete(T e) {
    boolean isSuccess = false;
    int cmp = 0;
    boolean isLeftChild = false;
    Node<T> current = null;
    Node<T> p = null;
    Node<T> child = null;

    if (root == null) {
      return false;
    }

    cmp = e.compareTo(root.data);
    if (cmp == 0) {
      root = deleteNode(root);
      isSuccess = true;
    }else if (cmp < 0) {
      current = root.left;
      isLeftChild = true;
      p = root;
    } else {
      current = root.right;
      isLeftChild = false;
      p = root;
    }
    
    while (current != null) {
      cmp = e.compareTo(current.data);
      if (cmp == 0) {
        
        current = deleteNode(current);
        isSuccess = true;
        if (isLeftChild) {
          p.left = current;
          break;
        } else {
          p.right = current;
        }
        
      } // end if (cmp == 0)
      else if (cmp < 0) {
        isLeftChild = true;
        p = current;
        current = current.left;
      } // end else if(cmp < 0)
      else {
        isLeftChild = false;
        p = current;
        current = current.right;
      } // end else
    } // end while

    return isSuccess;
  } // end delete()

  // 删除二叉查找树中指定的节点，返回其替代节点：1.如果节点右子树为空，用左子树代替它
  // 2.如果右子树r的左子树为空，用r替代它，3。如果右子树r的左子树不为空用node中序遍历的后继节点替代它
  public Node<T> deleteNode(Node<T> node) {
    Node<T> p = null;
    Node<T> l = null;

    if (node.right == null) {
      node = node.left;
    } // end if
    else if (node.right.left == null) {
      node.right.left = node.left;
      node = node.right;
    } // end if
    else {
      p = node.right;
      l = p.left;
      while (l.left != null) {
        l = l.left;
        p = p.left;
      } // end while
      p.left = l.right;
      l.right = node.right;
      l.left = node.left;
      node = l;
    } // end else

    return node;
  } // end deleteNode()

  public boolean add(T e) {
    boolean isSuccess = false;
    Node<T> current = root;
    Node<T> node = new Node<T>(e, null, null);
    int cmp = 0;

    if (root != null) {
      while (current != null) {
        cmp = e.compareTo(current.data);
        if (cmp < 0) {

          if (current.left == null) {
            current.left = node;
            isSuccess = true;
            ++size;
            break;
          } else {
            current = current.left;
          } // end if-else

        } // end if
        else if (cmp > 0) {

          if (current.right == null) {
            current.right = node;
            isSuccess = true;
            ++size;
            break;
          } // end if
          else {
            current = current.right;
          } // end if-else

        } // end else-if
        else {
          break;
        } // end else

      } // end while
    } // end if
    else {
      root = node;
      isSuccess = true;
    } // end if

    return isSuccess;
  } // end add()

  static class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node() {
    }

    public Node(T data, Node<T> left, Node<T> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    } // end Node()
  } // end class Node

  public static void main(String[] args) {
    SearchTree<Integer> tree = new SearchTree<Integer>();
    int[] data = { 3, 1, 4, 6, 9, 2, 5, 7 };

    for (int i = 0, len = data.length; i < len; ++i) {
      tree.add(data[i]);
    } // end for

    System.out.println(tree);
    tree.delete(3);
    System.out.println(tree);
  }
} // end class SearchTree
