package bookexercise.tree.chapter04;

import java.util.Iterator;

public class Ex4_11 {

  public static void main(String[] args) {
    SearchTree<Integer> tree = new SearchTree<Integer>();
    for (int i = 0; i < 10; ++i) {
      tree.add(i);
    }
    System.out.println(tree);

    Iterator<Integer> iterator = tree.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  static class SearchTree<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> root;

    public SearchTree() {
    } // end SearchTree()

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("|-----------------------\n");
      appendNode(root, sb, 0);
      sb.append("|-----------------------\n");
      return sb.toString();
    } // end toString()

    private void appendNode(Node<T> t, StringBuilder sb, int height) {
      if (t != null) {
        appendNode(t.right, sb, height + 1);
        for (int i = 0; i < height; ++i) {
          sb.append(" ");
        } // end for
        sb.append(t.data + "\n");
        appendNode(t.left, sb, height + 1);
      } // end if
    } // end appendNode()

    public void add(T e) {
      Node<T> node = new Node<T>(e, null, null, null);
      Node<T> current = null;
      int cmp = 0;

      if (isEmpty()) {
        root = node;
      } // end if
      else {
        current = root;
        while (current != null) {
          cmp = e.compareTo(current.data);
          node.parent = current;
          if (cmp < 0) {
            current = current.left;
          } // end if
          else if (cmp > 0) {
            current = current.right;
          } // end if
          else {
            break;
          } // end else
        } // end while
        if (current == null) {
          if (cmp < 0) {
            node.parent.left = node;
          } // end if
          else {
            node.parent.right = node;
          }
        } // if
      } // end else
    } // end add()

    public boolean isEmpty() {
      return root == null;
    } // end isEmpty()

    private class TreeIterator implements Iterator<T> {
      Node<T> current;

      public TreeIterator() {
        current = SearchTree.this.root;
        while (current.left != null) {
          current = current.left;
        }
      } // end TreeIterator()

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        T data = current.data;
        current = current.right;
        while (current != null && current.left != null) {
          current = current.left;
        }

        return data;
      }

      @Override
      public void remove() {
        // TODO Auto-generated method stub

      }
    } // end class TreeIterator

    static class Node<T> {
      public T data;
      public Node<T> parent;
      public Node<T> left;
      public Node<T> right;

      public Node() {
        this(null, null, null, null);
      }

      public Node(T data, Node<T> parent, Node<T> left, Node<T> right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
      } // end Node()
    } // end Node

    @Override
    public Iterator<T> iterator() {
      return new TreeIterator();
    }
  } // end class SearchTree

}
