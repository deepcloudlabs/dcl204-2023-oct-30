package com.example.types.primitives;

import java.math.BigDecimal;

public class StudyFloatingPointTypes {

	public static void main(String[] args) {
		// IEEE-754
		float f = 3.141516171819F; // 4-byte
		double d = 3.141516171819D; // 8-byte: 2^64
		f = 1_000_000_000.0F;
		System.err.println("f=%16.16f".formatted(f));
		f = f + 50;
		System.err.println("f=%16.16f".formatted(f));
		d = 2.0 - 1.10;
		System.err.println("d=%16.16f".formatted(d));
		d = 4.35 * 100;
		System.err.println("d=%16.16f".formatted(d));
		double x = (0.1 + 0.2) + 0.3;
		double y = 0.1 + (0.2 + 0.3);
		boolean isEqual = x == y;
		System.err.println(isEqual);
		BigDecimal bd = BigDecimal.valueOf(2.0);
		bd = bd.subtract(BigDecimal.valueOf(1.1));
		System.out.println("bd:%s".formatted(bd.toString()));
		bd = BigDecimal.valueOf(4.35);
		bd = bd.multiply(BigDecimal.valueOf(100));
		System.out.println("bd:%s".formatted(bd.toString()));
		
	}

}
