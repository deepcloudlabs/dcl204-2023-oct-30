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
public class Exercise7 {
	public static void main(String[] args) {
		// Count the number of animals in each species 
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"), new Centipede());
		Function<Animal,Class<?>> toClass = Animal::getClass;
		Function<Class<?>,String> toSimpleName = Class::getSimpleName;
		var groups = animals.stream()
				.collect(groupingBy(toClass.andThen(toSimpleName), Collectors.counting()));
		System.out.println(groups);		
	}
}
