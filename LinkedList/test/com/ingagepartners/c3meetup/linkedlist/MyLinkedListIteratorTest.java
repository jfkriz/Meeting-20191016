package com.ingagepartners.c3meetup.linkedlist;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ingagepartners.c3meetup.linkedlist.MyLinkedList;

class MyLinkedListIteratorTest {
	private MyLinkedList<Integer> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new MyLinkedList<Integer>();
	}

	@Test
	void hasNextShouldBeTrueForSingleItemList() {
		list.addEnd(0);
		assertTrue(list.iterator().hasNext());
	}

	@Test
	void hasNextShouldBeFalseForEmptyList() {
		assertFalse(list.iterator().hasNext());
	}
	
	@Test
	void nextShouldReturnValueForSingleItemList() {
		list.addEnd(0);
		assertEquals(0, list.iterator().next());
	}

	@Test
	void nextShouldThrowExceptionForEmptyList() {
		assertThrows(NoSuchElementException.class, () -> {
			list.iterator().next();
		});
	}
	
	@Test
	void shouldIterateProperly() {
		list.addEnd(0);
		list.addEnd(1);
		list.addEnd(2);
		
		Iterator<Integer> it = list.iterator();
		assertTrue(it.hasNext());
		assertEquals(0, it.next());
		assertTrue(it.hasNext());
		assertEquals(1, it.next());
		assertTrue(it.hasNext());
		assertEquals(2, it.next());
		assertFalse(it.hasNext());
	}
}
