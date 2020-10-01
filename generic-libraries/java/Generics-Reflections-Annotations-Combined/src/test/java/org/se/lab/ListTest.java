package org.se.lab;

import org.junit.Test;

public class ListTest {

	@Test
	public void testAdd() {
		IntegerLinkedList list = createIntegerList();

		ListFunctions.print(list);
	}

	@Test
	public void testCopy() {
		IntegerLinkedList source = createIntegerList();
		IntegerLinkedList destination = new IntegerLinkedList();

		ListFunctions.copy(source, destination);

		ListFunctions.print(destination);
	}

	@Test
	public void testAddLong() {
		GenericLinkedList<Long> list = createLongList();

		ListFunctions.print(list);
	}

	@Test
	public void testCopyLong() {
		GenericLinkedList<Long> source = createLongList();
		GenericLinkedList<Number> destination = new GenericLinkedList<>();

		ListFunctions.copy(source, destination);

		GenericLinkedList list = (GenericLinkedList) destination;
		list.add("abc");

		ListFunctions.print(destination);
	}

	private IntegerLinkedList createIntegerList() {
		IntegerLinkedList list = new IntegerLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		return list;
	}

	private GenericLinkedList<Long> createLongList() {
		GenericLinkedList<Long> list = new GenericLinkedList<>();
		list.add(1L);
		list.add(2L);
		list.add(3L);
		list.add(4L);
		return list;
	}

}
