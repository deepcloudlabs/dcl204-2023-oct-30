package com.example;

import java.util.List;

public class Exercise01 {

	public static void main(String[] args) {
		var numbers = List.of(4, 8, 15, 16, 23, 42);
		var total = 0;
		for (var number : numbers) {
			if (number%2 == 0) {
				var cubed = number * number * number;
				total += cubed;
			}
		}
		System.out.println("total is %d".formatted(total));
	}

}
