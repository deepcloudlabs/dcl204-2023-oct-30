package com.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Exercise02 {

	public static int fun() {
		try {TimeUnit.SECONDS.sleep(5);}catch(Exception e) {}
		return 42;
	}
	public static CompletableFuture<Integer> gun() {
		return CompletableFuture.supplyAsync(()->{
			try {TimeUnit.SECONDS.sleep(3);}catch(Exception e) {}
			return 42;			
		});
	}
	
	public static void main(String[] args) {
		System.out.println("Before the for loop...");
		for (int i=0;i<10;++i) {
			gun().thenAcceptAsync(result -> System.out.println("[%s] result is %d".formatted(Thread.currentThread().getName(),result)));
		}
		System.out.println("After the for loop...");
		for (int i=0;i<10;++i) {
			try {TimeUnit.SECONDS.sleep(1);}catch(Exception e) {}
			System.out.println("[%s] main is working hard...".formatted(Thread.currentThread().getName()));
		}	
	}

}
