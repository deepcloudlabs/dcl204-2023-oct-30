package com.example.types.primitives;

public class StudyString {

	public static void main(String[] args) {
		String fullName1 = "kate austen"; // constant pool
		String fullName2 = new String("kate austen"); // heap
		String fullName3 = "kate austen"; // constant pool
		fullName2 = fullName2.intern();
		System.out.println("fullname1==fullname2 ? %s".formatted(fullName1 == fullName2));
		System.out.println("fullname1==fullname3 ? %s".formatted(fullName1 == fullName3));
	}

}
