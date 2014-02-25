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
    quicksort(data, 0, data.length - 1);
  } // end sort()
  
  public static <T extends Comparable<? super T>>
  void quicksort(T[] data, int left, int right) {
    int i, j;
    T mid;
    
    if (left + CUTOFF < right) {
      mid = medium(data, left, right);
      i = left;
      j = right - 1;
      
      while (true){
        while (data[++i].compareTo(mid) < 0) {}
        while (data[--j].compareTo(mid) > 0) {}
        if (i < j) {
          swap(data, i, j);
        } else {
          break;
        }
      } // end while
      
      swap(data, i, right - 1);
      quicksort(data, left, i - 1);
      quicksort(data, left + 1, right);
      
    } // quicksort
    else {
      insertsort(data, left, right);
    } // insert sort
  } // end quicksort()
  
  public static <T extends Comparable<? super T>>
  T medium(T[] data, int left, int right) {
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
  
  public static <T> void swap(T[] data, int i, int j) {
    T temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }
  
  public static <T extends Comparable<? super T>>
  void insertsort(T[] data, int left, int right) {
    int i, j;
    T temp;
    
    for (i = left + 1; i <= right; ++i) {
      temp = data[i];
      for (j = i; j > left && temp.compareTo(data[j - 1]) < 0; --j) {
        data[j] = data[j - 1];
      } // end for
      data[j] = temp;
    } // end for
  } // end insertsort()
  
} // end class QuickSort
