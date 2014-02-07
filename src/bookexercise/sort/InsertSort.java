package bookexercise.sort;

public class InsertSort {

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
  void sort(T[] data)
  {
    T temp = null;
    int i, j, len;
    
    for (i = 1, len = data.length; i < len; ++i) {
      temp = data[i];
      for (j = i; j > 0 && temp.compareTo(data[j - 1]) < 0; --j) {
        data[j] = data[j - 1];
      } // end for
      data[j] = temp;
    } // end for
  } // end sort()
  
  

} // end class Insertsort

