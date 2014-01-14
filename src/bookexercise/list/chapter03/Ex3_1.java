package bookexercise.list.chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author qiudeqing
 * ����һ����L����һ�������ǰ������������е�����������printLots��L��P��
 * ����ӡL����Щ��P��ָ����λ���ϵ�Ԫ�أ�����P=1,3,4,6��ôL��λ�ڵ�1��
 * ��3����4�͵�6λ���ϵ�Ԫ�ر���ӡ������д������prinLots��L,P��ֻ��ʹ��
 * public�͵�Collections API����������
 * �ù��̵�����ʱ���Ƕ��٣�
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
