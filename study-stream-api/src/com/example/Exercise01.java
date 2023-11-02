package com.example;

import java.util.List;

public class Exercise01 {

	public static void main(String[] args) {
		var numbers = List.of(4, 8, 15, 16, 23, 42);
		// imperative programming -> oop
		var total = 0;
		for (var number : numbers) { // external loop
			if (number%2 == 0) {
				var cubed = number * number * number;
				total += cubed;
			}
		}
		System.out.println("total is %d".formatted(total));
		// declarative programming -> fp
		total = numbers.stream()  // internal loop
				       .parallel()
				       .filter(u -> u%2 == 0)
				       .map(v -> v*v*v)
				       .reduce(0, Integer::sum);
		System.out.println("total is %d".formatted(total));
				                
	}

}
