package bookexercise.list.chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex3_5 {
	
	public static <AnyType extends Comparable<? super AnyType>> void union(
			List<AnyType> a, List<AnyType> b, 
			List<AnyType> c) {
		
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
			} else if (result < 0) {
				c.add(dataA);
				dataA = itera.hasNext() ? itera.next() : null;
			} // end else if
			else {
				c.add(dataB);
				dataB = iterb.hasNext() ? iterb.next() : null;
			} // end else
		} // end while
		
		if (dataB != null) {
			dataA = dataB;
		} // end if
		while (dataA != null) {
			c.add(dataA);
			dataA = itera.hasNext() ? itera.next() : null;
		} // end while
		
	} // end union()
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		List<Integer> c = new ArrayList<Integer>();
		int i = 0;
		for (i = 0; i < 20; ++i) {
			if (i % 2 == 0) {
				a.add(i);
			} // end if
			else{
				b.add(i);
			} // end else
		} // end for
		
		System.out.println(a);
		System.out.println(b);
		union(a, b, c);
		System.out.println(c);
	}

} // end class Ex3_5
