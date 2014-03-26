package bookexercise.sort;

public class QuickSort2 {
  public static final int CUTOFF = 10; // 数组小于10个元素，采用插入排序。更快。
  public static final int SIZE = 50;
  
  public static void main(String[] args) {
    Integer[] data = new Integer[SIZE];
    int i;
    
    
    for (i = 0; i < SIZE; ++i) {
      data[i] = SIZE - i;
    } // end for
    
    QuickSort2.sort(data);
    for (i = 0; i < SIZE; ++i) {
      System.out.printf("%d ", data[i]);
    }
  } // end main()
  
  public static <T extends Comparable<? super T>>
  void sort(T[] data) {
    if (data != null && data.length != 0) {
      quicksort(data, 0, data.length - 1);
    }
  } // end sort()
  
  private static <T extends Comparable<? super T>>
  void quicksort(T[] data, int left, int right) {
    if (left < right) {
      T mid = medium(data, left, right);
      int i = left;
      int j = right - 1;
      
      while (i < j) {
        while (data[++i].compareTo(mid) < 0) {}
        while (data[--j].compareTo(mid) > 0) {}
        
        if (i < j) {
          swap(data, i, j);
        } // end if

      } // end while
      
      swap(data, i, right - 1);
      quicksort(data, left, i - 1);
      quicksort(data, i + 1, right);
    } // end if
  } // end quicksort()
  
  private static <T extends Comparable<? super T>>
  T medium(T[] data, int left, int right) {
    int middle = (left + right) / 2;
    if (data[left].compareTo(data[middle]) > 0) {
      swap(data, left, middle);
    } // end if
    if (data[left].compareTo(data[right]) > 0) {
      swap(data, left, right);
    } // end if
    if (data[middle].compareTo(data[right]) > 0) {
      swap(data, middle, right);
    } // end if
    
    swap(data, middle, right - 1);
    return data[right - 1];
  } // end medium()
  
  private static <T>
  void swap(T[] data, int i, int j) {
    T temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  } // end swap()

  
} // end class QuickSort
