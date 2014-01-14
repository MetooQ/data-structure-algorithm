package bookexercise.list.chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author qiudeqing
 * 给定一个表L和另一个表，他们包含已升序排列的整数，操作printLots（L，P）
 * 将打印L中那些有P所指定的位置上的元素，例如P=1,3,4,6那么L中位于第1、
 * 第3、第4和第6位置上的元素被打印出来。写出过程prinLots（L,P）只可使用
 * public型的Collections API容器操作。
 * 该过程的运行时间是多少？
 *
 */

public class Ex3_1 {
	
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		
		List<Integer> p = new ArrayList<Integer>();
		p.add(-1);
		p.add(0);
		p.add(1);
		p.add(2);
//		p.add(3);
//		p.add(4);
		p.add(5);
		p.add(6);
		p.add(7);
		
		printLots(l, p);
		
	}
	
	public static <AnyType> void printLots(List<AnyType> L, List<Integer> P) {
		int indexL = 0;
		int valP = 0;
		Iterator<AnyType> iterL = L.iterator();
		Iterator<Integer> iterP = P.iterator();
		
		
		while (iterL.hasNext() && iterP.hasNext()) {
			valP = iterP.next();
			if (valP < 0) { continue; }
			while(iterL.hasNext() && indexL < valP) {
				iterL.next();
				++indexL;
			} // end while
			if (iterL.hasNext() && indexL == valP) {
				System.out.println(iterL.next());
				++indexL;
			}
		}
		
	} // end printLots()

}
