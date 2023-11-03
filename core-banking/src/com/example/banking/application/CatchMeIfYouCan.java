package com.example.banking.application;

@SuppressWarnings("finally")
public class CatchMeIfYouCan {
    // (a) 42  (b) 108 (c) 75 (d) Compile Error
	public static int fun() {
		try {
			return 42;
		} finally {
			return 108;
		}
	}

	public static void main(String[] args) {
		System.out.println(fun());

	}

}
