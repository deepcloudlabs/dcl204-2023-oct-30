package com.example.random.service.business;

import java.security.SecureRandom;

import com.example.random.service.RandomNumberGeneratorService;

public class SecureRandomNumberGeneratorService implements RandomNumberGeneratorService {

	private SecureRandom random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		return random.nextInt(min, max);
	}

}
