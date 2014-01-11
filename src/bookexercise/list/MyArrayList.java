package bookexercise.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private AnyType[] theItems;
	
	public MyArrayList() {
		clear();
	} // end MyArrayList()

	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	} // end clear()
	
	public int size ()	 {
		return theSize;
	} // end size()
	public boolean isEmpty() {
		return size() == 0;
	} // end isEmpty()
	public void trimToSize() {
		ensureCapacity(size());
	} // end trimToSize()
	
	public AnyType get(int index) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		} // end if
		return theItems[index];
	} // end get()
	
	public AnyType set(int index, AnyType newVal) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		} // end if
		AnyType old = theItems[index];
		theItems[index] = newVal;
		return old;
	} // end set()
	
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		} // end if
		AnyType[] old = theItems;
		theItems = (AnyType[]) new Object[newCapacity];
		for (int i = 0, len = size(); i < len; ++i) {
			theItems[i] = old[i];
		} // end for
	} // end ensureCapacity()
	
	public boolean add(AnyType x) {
		add(size(), x);
		return true;
	} // end add()
	
	public void add(int index, AnyType x) {
		if (theItems.length == size()) {
			ensureCapacity(size() * 2 + 1);
		} // end if
		for (int i = theSize; i > index; --i) {
			theItems[i] = theItems[i - 1];
		} // end for
		theItems[index] = x;
		++theSize;
	} // end add()
	
	public AnyType remove(int index) {
		AnyType removedItem = theItems[index];
		for (int i = index, len = size() - 1; i < len; ++i) {
			theItems[i] = theItems[i + 1];
		} // enf fro
		--theSize;
		return removedItem;
	} // end remove()
	
	@Override
	public Iterator<AnyType> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<AnyType> {
		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public AnyType next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} // end if
			return theItems[current++];
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(--current);
		}
		
		
	} // end class ArrayListIterator

} // end class MyArrayList
































