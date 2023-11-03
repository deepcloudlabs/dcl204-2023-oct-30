package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Exercise01 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Thread t1 = new Thread(() -> {
			System.out.println("Hello Mars!");
		});
		Thread t2 = new Thread(() -> {
			System.out.println("Hello Moon!");
		});
		var task = new Task();
		Thread t3 = new Thread(task);
		var futureTask = new FutureTask<>(new CallableTask());
		Thread t4 = new Thread(futureTask);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println("Result from runnable task is %d".formatted(task.getResult()));
		System.out.println("Result from callable task is %d".formatted(futureTask.get()));
		System.out.println("Done.");
	}
}

class Task implements Runnable {
	private int result;

	@Override
	public void run() {
		System.out.println("Hello World!");
		result = 42;
	}

	public int getResult() {
		return result;
	}

}

class CallableTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("Hello Sun!");
		return 42;
	}}