package com.ingagepartners.c3meetup.linkedlist;
import java.util.Iterator;


public class MyLinkedList<T> implements Iterable<T> {
	Node<T> head;
	private Node<T> tail;
	
	public T addFirst(T item) {
		if(head == null) {
			initialize(item);
		} else {
			head = new Node<T>(item, head);
		}
		
		return head.getValue();
	}
	
	public T addEnd(T item) {
		if (head == null) {
			initialize(item);
		} else if (head == tail) {
			tail = new Node<T>(item);
			head.setNext(tail);
		} else {
			tail.setNext(new Node<T>(item));
			tail = tail.getNext();
		}
		
		return tail.getValue();
	}

	public T get(int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException(String.format("Index %d is invalid - cannot be less than 0", index));
		}
		
		if(head == null) {
			throw new IndexOutOfBoundsException(String.format("Index %d is invalid - list is currently empty", index));
		}
		
		Node<T> n = head;
		for(int i = 0; i < index; i++) {
			if(n.hasNext()) {
				n = n.getNext();
			} else {
				throw new IndexOutOfBoundsException(String.format("Index %d is invalid - list only contains %d items", index, i + 1));
			}
		}
		return n.getValue();
	}

	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator<T>(this);
	}
	
	private void initialize(T value) {
		head = new Node<T>(value);
		tail = head;
	}
}
