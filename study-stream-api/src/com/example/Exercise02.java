package com.example;

import java.util.List;

public class Exercise02 {

	public static void main(String[] args) {
		// Functional Programming
		// 1. Higher-Order Function: filter/map/reduce
		// 2. Pure Function: Lambda Expression, Method Reference
		List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);		
		var total = numbers.stream()  
				           .filter( t -> t%2 == 0 )
				           .map(t -> t*t*t)
				           .reduce(1, Fun::enBuyuk);
		System.out.println("total is %d".formatted(total));
				                
	}

}

interface Fun{
	public static int topla(int u,int v) {
		System.out.println("u=%d,v=%d".formatted(u,v));
		return u+v;
	}
	public static int carp(int u,int v) {
		System.out.println("u=%d,v=%d".formatted(u,v));
		return u*v;
	}
	public static int enBuyuk(int u,int v) {
		System.out.println("u=%d,v=%d".formatted(u,v));
		return u>v ? u : v;
	}
}