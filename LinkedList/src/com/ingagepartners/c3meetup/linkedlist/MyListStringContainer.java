package com.ingagepartners.c3meetup.linkedlist;

public class MyListStringContainer {
	private MyLinkedList<String> list = new MyLinkedList<String>();
	
	public String addToFront(String s) {
		return list.addFirst(s);
	}
	
	public String addToBack(String s) {
		return list.addEnd(s);
	}
	
	public int searchWithIterator(String s) {
		int i = 0;
		for(String next : list) {
			if(next.contains(s)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public int searchWithGet(String s) {
		try {
			int i = 0;
			while(!list.get(i).contains(s)) {
				i++;
			}
			return i;
		} catch(IndexOutOfBoundsException e) {
			return -1;
		}
	}
}
