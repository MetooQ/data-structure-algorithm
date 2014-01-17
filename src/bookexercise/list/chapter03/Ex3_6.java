package bookexercise.list.chapter03;

import java.util.ArrayList;
import java.util.List;

public class Ex3_6 {
	
	public static void josephus(List<Integer> data, int n, int m) {
		int current = 1;
		while (n > 0) {
			current = current + m;
			current = current > n ? current % n  : current;
			System.out.printf("%d ", data.get(current));
			data.remove(current);
			--n;
			if (n == 1) {
			  break;
			} // end if
			current = current > n ? current % n + 1 : current;
		}
		System.out.printf("%d ", data.get(1));
	} // end  josephus()
	
	public static void main(String[] args) {
    List<Integer> data = new ArrayList<Integer>();
    int c = 0;
    
    
    for (c = 0; c <= 5; ++c) {
      data.add(c);
    } // end for
    
    josephus(data, 5, 1);
    System.out.println("");
    
    data.clear();
    for (c = 0; c <= 5; ++c) {
      data.add(c);
    } // end for
    josephus(data, 5, 0);
  }

}
