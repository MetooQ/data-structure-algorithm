package bookexercise.sort;

public class QuickSort {
  public static final int CUTOFF = 10; // 数组小于10个元素，采用插入排序。更快。
  
  public static void main(String[] args) {
    Integer[] data = new Integer[50];
    int i;
    
    
    for (i = 0; i < 50; ++i) {
      data[i] = 50 - i;
    } // end for
    
    QuickSort.sort(data);
    for (i = 0; i < 50; ++i) {
      System.out.printf("%d ", data[i]);
    }
  } // end main()

  public static <T extends Comparable<? super T>>
  void sort(T[] data) {
    quicksort(data, 0, data.length - 1);
  } // end sort()
  
  public static <T extends Comparable<? super T>>
  void quicksort(T[] data, int left, int right) {
    int i, j;
    T mid;
    
    if (left + QuickSort.CUTOFF < right) {
      mid = mediun(data, left, right);
      i = left;
      j = right - 1;
      while (true) {
        while (data[++i].compareTo(mid) < 0) {}
        while (data[--j].compareTo(mid) > 0) {}
        if (i < j) {
          swap(data, i, j);
        } // end if
        else {
          break;
        } // end else
      } // end while
      
      swap(data, i, right - 1);
      quicksort(data, left, i - 1);
      quicksort(data, i + 1, right);
    } // end if
    else {
      insertSort(data, left, right);
    } // end else
  } // end quicksort()
  
  /**
   * 对left， center， right排序保证循环出口，交换中值与right - 1方便后续交换
   * @param data
   * @param left
   * @param right
   * @return left, center, right的中值
   */
  public static <T extends Comparable<? super T>>
  T mediun(T[] data, int left, int right) {
    int center = (left + right) / 2;
    if (data[left].compareTo(data[center]) > 0) {
      swap(data, left, center);
    }
    if (data[left].compareTo(data[right]) > 0) {
      swap(data, left, right);
    }
    if (data[center].compareTo(data[right]) > 0) {
      swap(data, center, right);
    }
    swap(data, center, right - 1);
    return data[right - 1];
  } // end medium()
  
  public static <T>
  void swap(T[] data, int i, int j) {
    T temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  } // end swap()
  
  public static <T extends Comparable<? super T>>
  void insertSort(T[] data, int left, int right) {
    int i, j;
    T temp;
    for (i = left + 1; i <= right; ++i) {
      temp = data[i];
      for (j = i; j > 0 && temp.compareTo(data[j - 1]) < 0; --j) {
        data[j] = data[j - 1];
      } // end for
      data[j] = temp;
    } // end for
  } // end insertSort()
  
  
} // end class QuickSort
