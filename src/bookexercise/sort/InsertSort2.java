package bookexercise.sort;

public class InsertSort2 {

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
    if (data == null || data.length == 0) {
      return;
    } // end if
    
    int i, j, len;
    T temp;
    
    for (i = 1, len = data.length; i < len; ++i) {
      temp = data[i];
      for (j = i; i > 0 && data[j - 1].compareTo(temp) > 0; --j) {
        data[j] = data[j - 1];
      } // end for
      data[j] = temp;
    } // end for
  } // end sort()



} // end class Insertsort

