package bookexercise.list.chapter03;

import java.util.ArrayList;
import java.util.List;

public class Ex3_33 {
  
  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<Integer>();
    int i = 0;
    
    for (i = 0; i < 10; ++i) {
      queue.enqueue(i);
      System.out.println(queue);
    } // end for
    
  }
  
  static class Queue<T> {
    private List<T> data;
    private int front;
    private int rear;
    public static final int CAPACITY = 10;
    
    
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      int i = front;
      
      sb.append("[");
      
      if (!isEmpty()) {
        sb.append(data.get(i));
        i = (i + 1) % Queue.CAPACITY;
        
        while (i != rear) {
          sb.append("," + data.get(i));
          i = (i + 1) % Queue.CAPACITY;
        } // end while
      } // end if
      
      sb.append("]");
      return sb.toString();
    } // end toString()
    
    public boolean enqueue(T e) {
      boolean isSuccess = true;
      if (!isFull()) {
        if (data.size() < Queue.CAPACITY) {
          data.add(e);
        } // end if
        else {
          data.set(rear, e);
        } // end else
        data.set(rear, e);
        rear = (rear + 1) % Queue.CAPACITY;
      } // end if
      return isSuccess;
    } // end enqueue()
    
    public boolean isFull() {
      return (rear + 1) % Queue.CAPACITY == front;
    } // end full()
    public boolean isEmpty() {
      return rear == front;
    } // end isEmpty()
    
    public T dequeue() {
      T e = null;
      if (!isEmpty()) {
        e = data.get(front);
        front = (front + 1) % Queue.CAPACITY;
      } // end if
      return e;
    } // end dequeue()
    
    public Queue(){
      this.data = new ArrayList<T>(Queue.CAPACITY);
      front = rear = 0;
    } // end Queue
  } // end class Queue

}
