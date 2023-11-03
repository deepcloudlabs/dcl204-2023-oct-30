package com.example.animals.exercises;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
public class Exercise6 {
	public static void main(String[] args) {
		// Group the animals by their number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"), new Centipede());
		Function<Animal,Integer> legs = Animal::getLegs;
		Function<Animal,Class<?>> toClass = Animal::getClass;
		Function<Class<?>,String> toSimpleName = Class::getSimpleName;
		var groups = animals.stream()
				.collect(groupingBy(legs, Collectors.mapping(toClass.andThen(toSimpleName), Collectors.toSet())));
		System.out.println(groups);
	}
}
