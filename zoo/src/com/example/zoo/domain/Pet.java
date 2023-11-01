package com.example.zoo.domain;

public abstract interface Pet {
	public abstract String getName();

	abstract void setName(String name);

	void play();
}
