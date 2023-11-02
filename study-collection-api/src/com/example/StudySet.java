package com.example;

import java.util.Set;
import java.util.TreeSet;

public class StudySet {

	public static void main(String[] args) {
		// UnOrdered, Unique
		Set<Integer> numbers = new TreeSet<>(new NumericOrderDesc()); 
		numbers.add(42);
		numbers.add(4);
		numbers.add(15);
		numbers.add(23);
		numbers.add(42);
		// Error: numbers.add(2,16);
		numbers.add(8);
		numbers.add(42);
		System.out.println(numbers);
		// System.out.println(numbers.get(4));
		numbers.remove(Integer.valueOf(5));
		for (var number : numbers) { // loop: for-each, since Java SE 5
			System.out.println(number);
		}
		System.out.println(numbers.contains(15));
		// iterator pattern
		for (var iter=numbers.iterator();iter.hasNext();) {
			var number = iter.next();
			System.out.println(number);			
		}

	}

}