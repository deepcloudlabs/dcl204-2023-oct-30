package com.example.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
				() -> assertTrue(currentLoad,vehicle.getCurrentLoad())
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
				() -> assertTrue(0,vehicle.getCurrentLoad())
		);
	}
	
}
