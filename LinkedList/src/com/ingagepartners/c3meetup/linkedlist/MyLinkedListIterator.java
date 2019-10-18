package com.ingagepartners.c3meetup.linkedlist;
import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedListIterator<T> implements Iterator<T> {
	private Node<T> current;
	
	public MyLinkedListIterator(MyLinkedList<T> list) {
		current = list.head;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if(current == null) {
			throw new NoSuchElementException();
		}
		
		T val = current.getValue();
		current = current.getNext();
		return val;
	}
}
