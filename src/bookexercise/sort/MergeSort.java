package bookexercise.sort;

public class MergeSort {
  

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
    mergeSort(data, temp, 0, data.length - 1);
  } // end sort()
  
  private static <T extends Comparable<? super T>>
  void mergeSort(T[] data, T[] temp, int start, int end) {
    if (start < end) {
      int center = (start + end) / 2;
      mergeSort(data, temp, start, center);
      mergeSort(data, temp, center + 1, end);
      merge(data, temp, start, center + 1, end);
    } // end if
  } // end mergeSort()
  
  private static <T extends Comparable<? super T>>
  void merge(T[] data, T[] temp, int leftStart, int rightStart, int rightEnd) {
    int leftEnd = rightStart - 1;
    int i = leftStart;
    int start = leftStart;
    
    while (leftStart <= leftEnd && rightStart <= rightEnd) {
      if (data[leftStart].compareTo(data[rightStart]) < 0) {
        temp[i++] = data[leftStart++];
      } // end if
      else {
        temp[i++] = data[rightStart++];
      } // end else
    } // end while
    
    while (leftStart <= leftEnd) {
      temp[i++] = data[leftStart++];
    } // end while
    while (rightStart <= rightEnd) {
      temp[i++] = data[rightStart++];
    } // end while
    
    while (start <= rightEnd) {
      data[start] = temp[start];
      ++start;
    } // end while
  } // end merge()
  
} // end class MergeSort
