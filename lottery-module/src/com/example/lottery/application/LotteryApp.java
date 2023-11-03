package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberGeneratorService;
import com.example.random.service.ServiceQuality;

public class LotteryApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		var props = new Properties();
		props.load(new FileInputStream(new File("resources","lottery.properties")));
		var qualityLevel = QualityLevel.valueOf(props.getProperty("random.service"));
		StandardLotteryService lotteryService = new StandardLotteryService();
		RandomNumberGeneratorService randomNumberGeneratorService = null;
		var services = ServiceLoader.load(RandomNumberGeneratorService.class);
		for (var service : services) {
			Class<?> clazz = service.getClass();
			if (clazz.isAnnotationPresent(ServiceQuality.class)){
				var serviceQuality = clazz.getAnnotation(ServiceQuality.class);
				if (serviceQuality.value() == qualityLevel) {
					randomNumberGeneratorService = service;
					break;
				}
			}
		}
		System.out.println(randomNumberGeneratorService.getClass().getName());
		lotteryService.setRandomNumberGeneratorService(randomNumberGeneratorService);
		lotteryService.draw(60, 6, 10)
		              .forEach(System.out::println);
	}

}
