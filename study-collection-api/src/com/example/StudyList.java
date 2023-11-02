package com.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudyList {

	public static void main(String[] args) {
		// Ordered -> Sortable, Allows duplicates
//		List<Integer> numbers = new ArrayList<>(); 
		List<Integer> numbers = new LinkedList<>(); 
		numbers.add(42);
		numbers.add(4);
		numbers.add(15);
		numbers.add(23);
		numbers.add(42);
		numbers.add(2,16);
		numbers.add(8);
		numbers.add(42);
		System.out.println(numbers);
		System.out.println(numbers.get(4));
		numbers.remove(5);
		System.out.println(numbers);
		numbers.sort(new NumericOrderAsc());
		System.out.println(numbers);
		numbers.sort(new NumericOrderDesc());
		System.out.println(numbers);
		for (var number : numbers) { // loop: for-each
			System.out.println(number);
		}
		System.out.println(numbers.contains(15));
	}

}

class A implements Comparable<A>{

	@Override
	public int compareTo(A other) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class NumericOrderAsc implements Comparator<Integer>{

	@Override
	public int compare(Integer left, Integer right) {
		return left-right;
		// return left<=right ? -1 : +1;
	}
	
}
class NumericOrderDesc implements Comparator<Integer> {
	
	@Override
	public int compare(Integer left, Integer right) {
		return right - left;
		// return left<=right ? +1 : -1;
	}
	
}
