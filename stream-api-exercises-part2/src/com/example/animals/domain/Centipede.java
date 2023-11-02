package com.example.animals.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Centipede extends Animal {

	public Centipede() {
		super(40);
	}

	@Override
	public void eat() {
		System.out.println("Centipede is eating now...");
	}

}
