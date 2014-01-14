package bookexercise.list;

public class SingleLinkedList<AnyType> {
	private Node<AnyType> startMarker;
	private int size;
	
	public SingleLinkedList() {
		clear();
	}
	
	public void clear() {
		size = 0;
		startMarker = new Node<AnyType>(null, null);
	} // end clear()
	
	public void add(AnyType data, int index) {
		int current = 0;
		Node<AnyType> p = startMarker;
		Node<AnyType> newNode = new Node<AnyType>(data, null);
		if (index >= size) {
			index = size;
		} // end if
		if (index < 0) {
			index = 0;
		}
		while (current < index && p != null) {
			++current;
			p = p.next;
		} // end while
		
		if (p != null) {
			newNode.next = p.next;
			p.next = newNode;
		} // end if
		++size;
		
	} // end add()
	
	public void swapAdjance(int index) {
		int c = 0;
		Node<AnyType> prev = startMarker;
		Node<AnyType> current = prev.next;
		if (size < 2 || index < 0 || index > size - 2) {
			throw new IllegalArgumentException();
		} // end if
		
		while(c < index && current != null) {
			prev = current;
			current = current.next;
			++c;
		} // end while
		
		if (c == index) {
			prev.next = current.next;
			current.next = current.next.next;
			prev.next.next = current;
		} // end if
		
	} // end swapAdjacne()
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<AnyType> temp = startMarker.next;
		
		if (temp != null) {
			sb.append(temp.data);
			temp = temp.next;
		}
		while (temp != null) {
			sb.append("," + temp.data);
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> next;
		
		public Node(AnyType d, Node<AnyType> n) {
			data = d;
			next = n;
		}
	} // end class Node
	
	public boolean contains(AnyType d) {
		Node<AnyType> current = startMarker.next;
		while (current != null) {
			if (current.data.equals(d)) {
				return true;
			} // end if
			current = current.next;
		} // end while
		return false;
	} // end contains()
	
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.add(1, 0);
		list.add(2, 0);
		list.add(3, 0);
		list.add(4, 0);
		list.add(5, 0);
		list.add(6, 0);
		System.out.println(list);
		
		list.swapAdjance(3);
		System.out.println(list);
		list.swapAdjance(3);
		System.out.println(list);
		
		System.out.println(list.contains(3));
		System.out.println(list.contains(22));
	}

} // end class SingleLinkedList
