package com.example;

public class StudyStringBuilder {
	public static void main(String[] args) {
		var start = System.currentTimeMillis();
//		var s = new StringBuffer("");
		var s = new StringBuilder("");
		for (int i = 0; i < 100_000_000; ++i) {
			s.append(i);	
		}
		var stop = System.currentTimeMillis();
		System.out.println("size: %d @ %d ms.".formatted(s.length(),(stop-start)));
	}
}
