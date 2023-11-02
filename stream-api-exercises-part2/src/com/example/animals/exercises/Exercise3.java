package com.example.animals.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Centipede;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	public static void main(String[] args) {
		// Find the animal with the highest number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Centipede(),new Fish("Jaws"));
		var animal =
		animals.stream()
		       .max(Comparator.comparingInt(Animal::getLegs))
		       .get()
		       .getClass()
		       .getSimpleName();
		System.out.println(animal);
	}
}
