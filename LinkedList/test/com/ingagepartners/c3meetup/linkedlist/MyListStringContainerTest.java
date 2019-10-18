package com.ingagepartners.c3meetup.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyListStringContainerTest {
	MyListStringContainer fixture;

	@BeforeEach
	void setUp() throws Exception {
		fixture = new MyListStringContainer();
	}

	@Test
	void testAddToFront() {
		assertEquals("a", fixture.addToFront("a"));
		assertEquals("b", fixture.addToFront("b"));
	}

	@Test
	void testAddToBack() {
		assertEquals("a", fixture.addToBack("a"));
		assertEquals("b", fixture.addToBack("b"));
	}

	@Test
	void testSearchWithIterator() {
		fixture.addToFront("abc");
		fixture.addToFront("def");
		fixture.addToFront("ghi");
		fixture.addToFront("jkl");
		fixture.addToFront("mno");
		fixture.addToFront("pqr");
		fixture.addToFront("stu");
		fixture.addToFront("vwx");
		fixture.addToFront("yz");

		assertEquals(4, fixture.searchWithIterator("n"));
	}

	@Test
	void testSearchWithGet() {
		fixture.addToFront("abc");
		fixture.addToFront("def");
		fixture.addToFront("ghi");
		fixture.addToFront("jkl");
		fixture.addToFront("mno");
		fixture.addToFront("pqr");
		fixture.addToFront("stu");
		fixture.addToFront("vwx");
		fixture.addToFront("yz");

		assertEquals(4, fixture.searchWithGet("n"));
	}

	@Test
	void compareSearches() {
		int upperLimit = 20000;
		int expectedIndex = (int) (upperLimit * .75);

		String search = null;
		for (int i = 0; i < upperLimit; i++) {
			if (i == expectedIndex) {
				search = fixture.addToBack(UUID.randomUUID().toString());
			} else {
				fixture.addToBack(UUID.randomUUID().toString());
			}
		}

		long start = System.currentTimeMillis();
		assertEquals(expectedIndex, fixture.searchWithGet(search));
		System.out.printf("searchWithGet took %d ms to find entry #%d out of %d total in the list\n",
				System.currentTimeMillis() - start, expectedIndex, upperLimit);
		
		start = System.currentTimeMillis();
		assertEquals(expectedIndex, fixture.searchWithIterator(search));
		System.out.printf("searchWithIterator took %d ms to find entry #%d out of %d total in the list\n",
				System.currentTimeMillis() - start, expectedIndex, upperLimit);
	}

}
