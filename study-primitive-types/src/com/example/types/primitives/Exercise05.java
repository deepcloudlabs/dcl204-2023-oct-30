package com.example.types.primitives;

public class Exercise05 {

	public static void main(String[] args) {
		double x = 0 / 0.;
		System.out.println("x=%16.16f".formatted(x));
		x = x + 1;
		System.out.println("x=%16.16f".formatted(x));
		System.out.println(x == Double.NaN);
		System.out.println(x == x);
		System.out.println(Double.isNaN(x));
		x = 1.0 / -0.;
		System.out.println("x=%16.16f".formatted(x));

	}

}
