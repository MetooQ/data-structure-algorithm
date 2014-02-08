package bookexercise.sort;

public class ShellSort {

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
    int len = data.length;
    int gap;
    int i;
    int j;
    T temp;
    
    for (gap = len / 2; gap >= 1; gap /= 2) {
      
      for (i = gap; i < len; ++i) {
        temp = data[i];
        for (j = i; j > gap && temp.compareTo(data[j - 1]) < 0; j -= gap) {
          data[j] = data[j - gap];
        } // end for
        data[j] = temp;
      } // end for
      
    } // end for
    
  } // end sort()
  
} // end class ShellSort
