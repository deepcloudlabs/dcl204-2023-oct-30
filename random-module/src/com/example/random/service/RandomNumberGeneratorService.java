package com.example.random.service;

public interface RandomNumberGeneratorService {
	default int generate(int max) {
		return this.generate(1, max);
	}

	int generate(int min, int max);
}
