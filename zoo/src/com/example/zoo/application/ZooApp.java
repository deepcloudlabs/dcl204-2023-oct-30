package com.example.zoo.application;

import java.util.List;

import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;
import com.example.zoo.domain.Spider;

public class ZooApp {

	public static void main(String[] args) {
		var zooAnimals = List.of(
				new Spider(),
				new Cat("Garfield"),
				new Fish("Nemo"),
				new Spider(),
				new Cat(),
				new Fish("Free Willy")
		);
		for (var animal : zooAnimals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet pet) {
				// Pet pet = (Pet) animal;
				pet.play();
			}
		}

	}

}
