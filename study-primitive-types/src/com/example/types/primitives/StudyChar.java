package com.example.types.primitives;

public class StudyChar {

	public static void main(String[] args) {
		char x = 'a'; // 2-byte, unsigned int, unicode
		System.out.println(x);
		System.out.println((char)(x+1));
		x = '\u20ba';
		System.out.println(x+0);		

	}

}
