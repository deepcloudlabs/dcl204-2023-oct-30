package com.example.lottery.application;

import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.RandomNumberGeneratorService;

public class LotteryApp {

	public static void main(String[] args) {
		StandardLotteryService lotteryService = new StandardLotteryService();
		RandomNumberGeneratorService randomNumberGeneratorService = null;
		var services = ServiceLoader.load(RandomNumberGeneratorService.class);
		randomNumberGeneratorService = services.findFirst().get();
		System.out.println(randomNumberGeneratorService.getClass().getName());
		lotteryService.setRandomNumberGeneratorService(randomNumberGeneratorService);
		lotteryService.draw(60, 6, 10)
		              .forEach(System.out::println);
	}

}
