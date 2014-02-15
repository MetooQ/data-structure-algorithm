package leetcode;

public class ReversePolishNotation {
  public static void main(String[] args) {
    Solution s = new Solution();
    String[] input = { "2", "1", "+", "3", "*" };
    System.out.println(s.evalRPN(input));
  }

  static class Solution {
    public int evalRPN(String[] tokens) {
      int i, len, result = 0;
      Stack<Integer> stack = new Stack<Integer>();
      Integer data = null;
      String token = null;
      Integer left, right;

      for (i = 0, len = tokens.length; i < len; ++i) {
        token = tokens[i];
        data = parseInt(token);
        if (data != null) {
          stack.push(data);
        }  // end if 
        else {
          right = stack.pop();
          left = stack.pop();
          if (token.equals("+")) {
            stack.push(left + right);
          } // end if
          else if (token.equals("-")) {
            stack.push(left - right);
          } // end if
          else if (token.equals("*")) {
            stack.push(left * right);
          } // end if
          else if (token.equals("/")) {
            stack.push(left / right);
          } // end else
        } // end else
      } // end for

      return stack.pop();
    }

    public Integer parseInt(String in) {
      try {
        return Integer.parseInt(in, 10);
      } catch (NumberFormatException e) {
        return null;
      }
    }

    static class Stack<T> {
      Node<T> header;

      public Stack() {
        header = new Node<T>();
      }

      public boolean isEmpty() {
        return header.next == null;
      } // end isEmpty()

      public void push(T d) {
        Node<T> node = new Node<T>();
        node.data = d;
        node.next = header.next;
        header.next = node;
      } // end push()

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
          sb.append(", " + node.data);
          node = node.next;
        } // end while
        sb.append("]");
        return sb.toString();
      } // end toString()

      public T pop() {
        T d = header.next.data;
        header.next = header.next.next;
        return d;
      } // end pop()

      static class Node<T> {
        T data;
        Node<T> next;

        public Node() {
          data = null;
          next = null;
        }
      }
    } // end class Stack
  } // end class Solution

}
