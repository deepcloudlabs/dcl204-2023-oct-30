package com.example.application;

import java.lang.reflect.Proxy;

import com.example.service.CachingHandler;
import com.example.service.LotteryService;
import com.example.service.ProfileHandler;
import com.example.service.StandardLotteryService;

public class LotteryApp {

	public static void main(String[] args) {
		var lotteryService = new StandardLotteryService();
		var clazz = lotteryService.getClass();
		var lotteryServiceProxy = (LotteryService) Proxy.newProxyInstance(
				     clazz.getClassLoader(), 
				     clazz.getInterfaces(), 
				     new CachingHandler(lotteryService)
		);
		lotteryServiceProxy = (LotteryService) Proxy.newProxyInstance(
				clazz.getClassLoader(), 
				clazz.getInterfaces(), 
				new ProfileHandler(lotteryServiceProxy)
		);
		//lotteryService.setProxy(lotteryServiceProxy);
		lotteryServiceProxy.draw(60, 6, 3)
		                   .forEach(System.out::println);
		lotteryServiceProxy.draw(60, 6, 3)
		                   .forEach(System.out::println);
		lotteryServiceProxy.draw(60, 6, 4)
						   .forEach(System.out::println);
		

	}

}
