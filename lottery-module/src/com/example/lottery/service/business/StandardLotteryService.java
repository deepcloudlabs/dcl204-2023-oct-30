package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberGeneratorService;

public class StandardLotteryService implements LotteryService {
	private RandomNumberGeneratorService randomNumberGeneratorService;
	
	public void setRandomNumberGeneratorService(RandomNumberGeneratorService randomNumberGeneratorService) {
		this.randomNumberGeneratorService = randomNumberGeneratorService;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return IntStream.generate(() -> randomNumberGeneratorService.generate(max))
				        .distinct()
				        .limit(size)
				        .sorted()
				        .boxed()
				        .toList();
	}

}
