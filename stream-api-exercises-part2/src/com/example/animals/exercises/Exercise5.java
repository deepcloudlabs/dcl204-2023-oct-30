package com.example.animals.exercises;

import java.util.Arrays;
import java.util.List;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("unused")
public class Exercise5 {
	public static void main(String[] args) {
		int i=42; // 4-Byte
		Integer j = 42; // Object Header (12B) + 4B = 16Byte
		// Find the total number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		var stats = animals.stream().mapToInt(Animal::getLegs).summaryStatistics();
		animals.stream().map(Animal::getLegs).reduce(0,Integer::sum);
		System.out.println(stats);
	}
}

class A {}
