package com.example.domain;

import java.math.BigDecimal;

public class Vehicle {
	private final BigDecimal capacity;
	private BigDecimal currentLoad;

	public Vehicle(double capacity) {
		this.capacity = BigDecimal.valueOf(capacity);
		this.currentLoad = BigDecimal.ZERO;
	}

	// information hiding
	// Constructor -> maxCapacity
	// getter
	// loadBox(weight), unloadBox(weight)
	// toString
	public double getCurrentLoad() {
		return currentLoad.doubleValue();
	}

	public boolean load(double weight) {
		// validation rule
		if (weight <= 0)
			return false;
		// business rule
		if (this.currentLoad.doubleValue() + weight > this.capacity.doubleValue())
			return false;
		// business logic
		this.currentLoad = this.currentLoad.add(BigDecimal.valueOf(weight));
		return true;
	}

	public boolean unload(double weight) {
		// validation rule
		if (weight <= 0)
			return false;
		// business rule
		if (weight > this.currentLoad.doubleValue())
			return false;
		// business logic
		this.currentLoad = this.currentLoad.subtract(BigDecimal.valueOf(weight));
		return true;
	}

}
