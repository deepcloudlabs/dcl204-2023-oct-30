package com.example.domain;

public class Vehicle {
	private final double capacity;
	private double currentLoad;

	public Vehicle(double capacity) {
		this.capacity = capacity;
	}

	// information hiding
	// Constructor -> maxCapacity
	// getter
	// loadBox(weight), unloadBox(weight)
	// toString
	public double getCurrentLoad() {
		return currentLoad;
	}

	public boolean load(double weight) {
		// validation rule
		if (weight <= 0)
			return false;
		// business rule
		if (this.currentLoad + weight > this.capacity)
			return false;
		// business logic
		this.currentLoad += weight;
		return true;
	}

	public boolean unload(double weight) {
		// validation rule
		if (weight <= 0)
			return false;
		// business rule
		if (weight > this.currentLoad)
			return false;
		// business logic
		this.currentLoad -= weight;
		return true;
	}

}
