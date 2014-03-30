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
    if (data != null && data.length != 0) {
      T[] temp = (T[])new Comparable[data.length];
      mergesort(data, temp, 0, data.length - 1);
    } // end if
  } // end sort()
  
  public static <T extends Comparable<? super T>>
  void mergesort(T[] data, T[] temp, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergesort(data, temp, left, mid);
      mergesort(data, temp, mid + 1, right);
      merge(data, temp, left, mid + 1, right);
    } // end if
  } // end mergesort()
  
  public static <T extends Comparable<? super T>>
  void merge(T[] data, T[] temp, int leftBegin, int rightBegin, int rightEnd) {
    int left = leftBegin;
    int leftEnd = rightBegin - 1;
    int right = rightBegin;
    int i = leftBegin;
    int count = 0;
    
    while (left <= leftEnd && right <= rightEnd) {
      if (data[left].compareTo(data[right]) < 0) {
        temp[i++] = data[left++];
      } // end if
      else {
        temp[i++] = data[right++];
      } // end else
    } // end while
    
    while (left <= leftEnd) {
      temp[i++] = data[left++];
    } // end while
    while (right <= rightEnd) {
      temp[i++] =data[right++];
    } // end while
    
    left = leftBegin;
    while (left <= rightEnd) {
      data[left] = temp[left];
      ++left;
    } // end while
    
  } // end merge()
  
} // end class MergeSort
