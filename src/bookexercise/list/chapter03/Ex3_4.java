package bookexercise.list.chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Ex3_4 {
	


	public static <AnyType extends Comparable<? super AnyType>>
		void intersection(List<AnyType> a, List<AnyType> b,
				List<AnyType> c){
		
		Iterator<AnyType> itera = a.iterator();
		Iterator<AnyType> iterb = b.iterator();
		
		AnyType dataA = null;
		AnyType dataB = null;
		int result = 0;
		
		if (itera.hasNext() && iterb.hasNext()) {
			dataA = itera.next();
			dataB = iterb.next();
		} // end if
		
		while (dataA != null && dataB != null) {
			result = dataA.compareTo(dataB);
			if (result == 0) {
				c.add(dataA);
				dataA = itera.hasNext() ? itera.next() : null;
				dataB = iterb.hasNext() ? iterb.next() : null;
			} // end if
			else if (result < 0) {
				dataA = itera.hasNext() ? itera.next() : null;
			} // end else
			else {
				dataB = iterb.hasNext() ? iterb.next() : null;
			} // end else
		} // end while
		
	} // end intersection()
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		List<Integer> c = new ArrayList<Integer>();
		int i = 0;
		for (i = 0; i < 30; ++i) {
			if (i % 2 == 0) {
				a.add(i);
			} // end if
			if (i % 3 == 0){
				b.add(i);
			} // end else
		} // end for
		
		System.out.println(a);
		System.out.println(b);
		intersection(a, b, c);
		System.out.println(c);
	}
	

}
