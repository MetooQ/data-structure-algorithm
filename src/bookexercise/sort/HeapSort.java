package bookexercise.sort;

public class HeapSort {
  
  public static void main(String[] args) {
    Integer[] data = new Integer[10];
    int i;
    
    for (i = 9; i >= 0; --i) {
      data[i] = i;
    } // end for
    
    sort(data);
    
    for (i = 0; i <= 9; ++i) {
      System.out.printf("%d ", data[i]);
    } // end for
    
  } // main()

  public static int leftChild(int i) {
    return i * 2 + 1;
  } // end leftChild()
  
  public static <T extends Comparable<? super T>>
  void permDown(T[] a, int i, int size) {
    T temp = a[i];
    int child = 0;
    
    for (; (child = leftChild(i)) < size; i = child) {
      if (child + 1 < size && a[child].compareTo(a[child + 1]) < 0) {
        ++child;
      } // end if
      a[i] = a[child];
    } // end for
    a[i] = temp;
  } // end permDown()
  
  public static <T extends Comparable<? super T>>
  void sort(T[] data) {
    int i;
    int len = data.length;
    T temp;
    
    for (i = len / 2; i >= 0; --i) {
      permDown(data, i, len);
    } // end for: build max heap
    
    for (i = len - 1; i >= 0; --i) {
      temp = data[i];
      data[i] = data[0];
      data[0] = temp;
      permDown(data, 0, i);
    } // end for
  } // end sort()
  
} // end class HeapSort
