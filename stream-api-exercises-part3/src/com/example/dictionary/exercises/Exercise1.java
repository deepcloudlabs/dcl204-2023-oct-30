package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Exercise1 {

	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Find the words starting with letters A to M
		var pattern = "^[a-m][a-z]*$";
		words.stream()
		     .parallel() 
		     .map(String::toLowerCase)
		     .filter(word -> word.matches(pattern))
		     .min(Comparator.comparing(String::length))
		     .ifPresent(System.out::println);
	}

}
