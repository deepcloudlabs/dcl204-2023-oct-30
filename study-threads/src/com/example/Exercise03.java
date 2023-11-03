package com.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Exercise03 {

	public static void main(String[] args) throws InterruptedException {
		var start = System.currentTimeMillis();
		var task = new CounterTask();
		var t1 = new Thread(task);
		var t2 = new Thread(task);
		var t3 = new Thread(task);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		var stop = System.currentTimeMillis();
		System.out.println("counter: %d @ %d ms.".formatted(task.getCounter(),(stop-start)));
	}

}

class CounterTask implements Runnable { // Thread Safe
	//private int counter; // heap
	private AtomicInteger counter= new AtomicInteger();
	@Override
	public void run() {
		for (var i = 0; i < 10_000_000; ++i) {
			//synchronized (this) 
			{
				counter.incrementAndGet(); // critical section				
			}
		}

	}

	public int getCounter() {
		return counter.get();
	}

}
