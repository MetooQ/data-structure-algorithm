package bookexercise.sort;

public class MergeSort2 {
  

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

  public static <T extends Comparable<? super T>>
  void sort(T[] data) {
    T[] temp = (T[])new Comparable[data.length];
    mergesort(data, temp, 0, data.length - 1);
  } // end sort()
  
  public static <T extends Comparable<? super T>>
  void mergesort(T[] data, T[] temper, int left, int right) {
    if (left < right) {
      int center = (left + right) / 2;
      mergesort(data, temper, left, center);
      mergesort(data, temper, center + 1, right);
      merge(data, temper, left, center + 1, right);
    } // end if
  } // end mergesort()
  
  public static <T extends Comparable>
  void merge(T[] data, T[] temp, int leftBegin, int rightBegin, int rightEnd) {
    int i = leftBegin;
    int left = leftBegin;
    int leftEnd = rightBegin - 1;
    int right = rightBegin;
    
    while (left <= leftEnd && right <= rightEnd) {
      if (data[left].compareTo(data[right]) < 0) {
        temp[i++] = data[left++];
      } else {
        temp[i++] = data[right++];
      } // end else
    } // end if
    
    while (left <= leftEnd) {
      temp[i++] = data[left++];
    }
    while (right <= rightEnd) {
      temp[i++] = data[right++];
    }
    
    for (i = leftBegin; i <= rightEnd; ++i){
      data[i] = temp[i];
    }
    
  } // end merge()
  
} // end class MergeSort
