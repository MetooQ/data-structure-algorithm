package bookexercise.sort;

public class HeapSort {
  
  public static void main(String[] args) {
    Integer[] data = new Integer[10];
    int i;
    
    for (i = 9; i >= 0; --i) {
      data[i] = i;
    } // end for
    
    asort(data);
    
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
      if (temp.compareTo(a[child]) < 0) {
        a[i] = a[child];
      } // end if
      else {
        break;
      } // end else
      
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
  
  
  
  
  
  
  
  
  
  public static int aLeftChild(int i) {
    return 2 * i + 1;
  }
  public static <T extends Comparable<? super T>>
  void aPermDown(T[] data, int i, int size) {
    int child;
    T temp = data[i];
    
    for (; (child = aLeftChild(i)) < size; i = child) {
      if (child + 1 < size && data[child + 1].compareTo(temp) > 0) {
        ++child;
      } // end if
      if (data[child].compareTo(temp) > 0) {
        data[i] = data[child];
      } // end if
      else {
        break;
      } // end else
    } // end for
    data[i] = temp;
  } // end permDown()
  
  public static <T extends Comparable<? super T>>
  void asort(T[] data) {
    int i, len;
    T temp;
    
    len = data.length;
    for (i = len / 2; i >= 0; --i) {
      aPermDown(data, i, len);
    } // end for
    for (i = len - 1; i > 0; --i) {
      temp = data[i];
      data[i] = data[0];
      data[0] = temp;
      aPermDown(data, 0, i);
    } // end for
    
  } // end asort()
  
  
  
  
  
  
} // end class HeapSort
