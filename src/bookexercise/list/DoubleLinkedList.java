package bookexercise.list;

public class DoubleLinkedList<AnyType> {
	private Node<AnyType> startMarker;
	private Node<AnyType> endMarker;
	private int size;
	
	public DoubleLinkedList() {
		clear();
	} // end DoubleLinkedList()
	
	public void clear() {
		endMarker = new Node<AnyType>(null, null, null);
		startMarker = new Node<AnyType>(null, null, endMarker);
		endMarker.prev = startMarker;
		size = 0;
	} // end clear()
	
	public void add(AnyType d) {
		Node<AnyType> newNode = new Node<AnyType>(d, null, null);
		startMarker.next.prev = newNode;
		newNode.next = startMarker.next;
		newNode.prev = startMarker;
		startMarker.next = newNode;
		++size;
	} // end add()
	
	public void swapAdjance(int index) {
		if (index < 0 || index > size - 2 || size < 2) {
			throw new IllegalArgumentException();
		} // end if
		Node<AnyType> current = startMarker;
		Node<AnyType> next = null;
		int c = -1;
		while (c < index) {
			current = current.next;
			++c;
		} // end while
		next = current.next;
		
		current.next = next.next;
		next.next.prev = current;
		
		next.prev = current.prev;
		current.prev.next = next;
		
		current.prev = next;
		next.next = current;
		
	} // end swapAdjance()
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<AnyType> current = startMarker.next;
		sb.append("[");
		if (current != endMarker) {
			sb.append(current.data);
			current = current.next;
		} // end if
		while (current != endMarker) {
			sb.append("," + current.data);
			current = current.next;
		} // end while
		sb.append("]");
		return sb.toString();
	} // end toString()
	
	public boolean contains(AnyType d) {
		Node<AnyType> current = startMarker.next;
		while (current != endMarker) {
			if (current.data.equals(d)) {
				return true;
			} // end if
			current = current.next;
		} // end while
		return false;
	} // end contains()
	
	static class Node<AnyType> {
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		
		public Node(AnyType d, Node<AnyType> prev, Node<AnyType> next) {
			this.data = d;
			this.prev = prev;
			this.next = next;
		}
	} // end class Node

	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		
		list.swapAdjance(3);
		System.out.println(list);
		
		System.out.println(list.contains(3));
		System.out.println(list.contains(33));
	}
}
