package com.example.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class VehicleTest {

	@ParameterizedTest
	@CsvFileSource(resources = "loads_success.csv")
	@DisplayName("loading weight under the capacity should return true")
	void loadWeightsUnderCapacityShouldReturnTrue(double capacity,double weight,double currentLoad) {
		Vehicle vehicle = new Vehicle(capacity);
		boolean result = vehicle.load(weight);
		assertAll(
				() -> assertTrue(result),
				() -> assertEquals(currentLoad,vehicle.getCurrentLoad())
		);
	}

	@DisplayName("loading weight over the capacity should return false")
	@ParameterizedTest
	@CsvFileSource(resources = "loads_failure.csv")
	void loadWeightsOverCapacityShouldReturnFalse(double capacity,double weight) {
		Vehicle vehicle = new Vehicle(capacity);
		boolean result = vehicle.load(weight);
		assertAll(
				() -> assertFalse(result),
				() -> assertEquals(0,vehicle.getCurrentLoad())
		);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "unloads_success.csv")
	@DisplayName("unloading weight under/all current load should return true")
	void unloadWeightsShouldReturnTrue(double capacity,double loadWeight,double unloadWeight,double currentLoad) {
		Vehicle vehicle = new Vehicle(capacity);
		boolean loadResult = vehicle.load(loadWeight);
		boolean unloadResult = vehicle.unload(unloadWeight);
		assertAll(
				() -> assertTrue(loadResult),
				() -> assertTrue(unloadResult),
				() -> assertEquals(currentLoad,vehicle.getCurrentLoad())
		);
	}
}
