package com.ingagepartners.c3meetup.linkedlist;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ingagepartners.c3meetup.linkedlist.MyLinkedList;

class MyLinkedListTest {
	private MyLinkedList<Integer> fixture;
	
	@BeforeEach
	void setUp() {
		fixture = new MyLinkedList<Integer>();
	}
	
	@Test
	void shouldAddFirstSuccessfully() {
		assertEquals(2, fixture.addFirst(2));
		assertEquals(1, fixture.addFirst(1));
		assertEquals(0, fixture.addFirst(0));
		assertEquals(0, fixture.get(0));
		assertEquals(1, fixture.get(1));
		assertEquals(2, fixture.get(2));
	}

	@Test
	void shouldAddFirstWhenListIsEmpty() {
		fixture.addFirst(0);
		assertEquals(0, fixture.get(0));
	}

	@Test
	void shouldAddEndSuccessfully() {
		assertEquals(0, fixture.addEnd(0));
		assertEquals(1, fixture.addEnd(1));
		assertEquals(2, fixture.addEnd(2));
		assertEquals(0, fixture.get(0));
		assertEquals(1, fixture.get(1));
		assertEquals(2, fixture.get(2));
	}

	@Test
	void shouldAddEndWhenListIsEmpty() {
		fixture.addEnd(0);
		assertEquals(0, fixture.get(0));
	}

	@Test
	void shouldGetSuccessfully() {
		fixture.addEnd(1);
		fixture.addFirst(0);
		fixture.addEnd(2);
		assertEquals(0, fixture.get(0));
		assertEquals(1, fixture.get(1));
		assertEquals(2, fixture.get(2));
	}

	@Test
	void shouldThrowExceptionIfGettingFromEmptyList() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			fixture.get(0);
		});
	}
	
	@Test
	void shouldThrowExceptionIfGettingNegativeIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			fixture.get(-1);
		});
	}
	
	@Test
	void shouldThrowExceptionIfGettingPastEndOfList() {
		fixture.addEnd(0);
		fixture.addEnd(1);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			fixture.get(2);
		});
	}
	
	@Test
	void testIterator() {
		fixture.addEnd(0);
		fixture.addEnd(1);
		Iterator<Integer> it = fixture.iterator();
		assertNotNull(it);
		assertTrue(it.hasNext());
	}

	@Test
	void testIteratorEmptyList() {
		Iterator<Integer> it = fixture.iterator();
		assertNotNull(it);
		assertFalse(it.hasNext());
	}

}
