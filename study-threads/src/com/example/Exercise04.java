package com.example;

@SuppressWarnings("unused")
public class Exercise04 {

	public static void main(String[] args) {
		var t1 = Thread.ofPlatform(); // Platform Thread -> Kernel Thread
		var t2 = Thread.ofVirtual(); // Virtual Thread -> Kernel Thread

	}

}
