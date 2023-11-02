package com.example;

import java.util.HashSet;
import java.util.Objects;

public class Exercise01 {

	public static void main(String[] args) {
		AA a = new AA(42);
		var collection = new HashSet<>();
		collection.add(a);
		System.out.println(collection.contains(new AA(42)));
	}

}

class AA extends Object implements Comparable<AA>{
	private final int id;

	public AA(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	

	@Override
	public int compareTo(AA other) {
		return this.id - other.id;
	}
	
}