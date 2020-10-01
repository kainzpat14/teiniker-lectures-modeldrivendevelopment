package org.se.lab;

public class ListFunctions {
	public static void copy(IntegerLinkedList source, IntegerLinkedList destination) {
		for (int i = 0; i < source.size(); i++) {
			destination.add(source.get(i));
		}
	}

	public static void print(IntegerLinkedList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	// T = Number
	// extends -> Integer, Long, Double
	// super -> Number, Object
	public static <T> void copy(GenericLinkedList<? extends T> source, GenericLinkedList<? super T> destination) {
		for (int i = 0; i < source.size(); i++) {
			destination.add(source.get(i));
		}
	}

	public static <T> void print(GenericLinkedList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
