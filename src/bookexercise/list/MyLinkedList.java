package bookexercise.list;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	private static class Node<AnyType> {
		public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
			data = d, prev = p; next = n;
		}
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
	}
	
	public MyLinkedList() {
		clear();
	}
	
	public void clear() {
		beginMarker = new Node<AnyType>(null, null, null);
		endMarker = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount ++;
	}
	
	public int size() {
		return theSize;
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public boolean add(AnyType x) {
		add(size(), x);
		return ture;
	}
	
	public void add(int index, AnyType x) {
		addBefore(getNode(index), x);
	}
	public AnyType get(int index) {
		return getNode(index).data;
	}
	public AnyType set(int index, AnyType newVal) {
		Node<AnyType> p = getNode(index);
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	public AnyType remove(int index) {
		return remove(getNode(index));
	}
	private void addBefore(Node<AnyType> p, AnyType x) {
		Node node = new Node(x, p.prev, p);
		p.prev.next = p.prev = node;
		++theSize;
		++modCount;
	}
	private AnyType remove(Node<AnyType> p) {
		p.prev.next = p.next;
		p.next.prev = p.prev;
		--theSize;
		++modCount;
		return p.data;
	}
	private Node<AnyType> getNode(int index) {
		Node<AnyType> p;
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index < size() / 2) {
			p = beginMarker;
			for (int i = 0, i < index; ++i) {
				p = p.next;
			}
			return p;
		} else {
			p = endMarker;
			for (int i = size() - 1; i > index; --i) {
				p = p.prev;
			}
			return p;
		}
	}
	
	public java.util.Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	}
	public class LinkedListIterator implements java.util.Iterator<AnyType> {
	
		private Node<AnyType> current = beginMarker.next;
		private int excepedModCount = modCount;
		private boolean okToRemove = false;
		
		
		@Override
		public boolean hasNext() {
			return current != endMarker;
		}
		@Override
		public AnyType next() {
			if (modCount != excepedModCount) {
				throw new java.util.ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			AnyType nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		@Override
		public void remove() {
			if (modCount != excepedModCount) {
				throw new java.util.ConcurrentModificationException()	;
				
			}
			if (!okToRemove) {
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
		}
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		return null;
	} // end iterator()


	private int theSize;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;

}
