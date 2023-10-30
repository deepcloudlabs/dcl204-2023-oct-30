package com.example.types.primitives;

public class Exercise01 {

	public static void main(String[] args) {
		int x = 42; // decimal
		System.out.println("x=%d".formatted(x));
		int y= 042; // octal
		System.out.println("y=%d".formatted(y));
		int u = 0x42; // hexadecimal
		System.out.println("u=%d".formatted(u));
		int v= 0b1100_1010; // binary
		System.out.println("v=%x".formatted(v));

	}

}
