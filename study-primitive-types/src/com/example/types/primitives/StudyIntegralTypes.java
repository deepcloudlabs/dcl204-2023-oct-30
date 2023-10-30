package com.example.types.primitives;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		// integral types: byte, short, int, long
		// signed
		byte b = 42; // 1-Byte, [-128..127]
		b = 127;
		System.out.println("b=%d".formatted(b)); // 127
		b++; // b = (byte) (b + 1)
		System.out.println("b=%d".formatted(b)); // -128
		b=-128;
		b--;
		System.out.println("b=%d".formatted(b)); // 127
        byte u=125,v=3,w;
        w = (byte) (u + v);
        System.out.println("w=%d".formatted(w)); // -128
        short s = 42; // 2-Byte, [-32768..32767]
        s = Short.MAX_VALUE;
        System.out.println("s=%d".formatted(s)); // 32767
        s++;
        System.out.println("s=%d".formatted(s)); // -32768
        int i = 42; // 4-Byte, [-2147483648..2147483647]
        i = Integer.MAX_VALUE;
        System.out.println("i=%d".formatted(i)); // 2147483647
        i++;
        System.out.println("i=%d".formatted(i)); // -2147483648
        long l = 42; // 8-Byte, [-9223372036854775808..9223372036854775807]
        l = Long.MAX_VALUE;
        System.out.println("l=%d".formatted(l)); // 9223372036854775807
        l++;
        System.out.println("l=%d".formatted(l)); // -9223372036854775808
        // Immutable Class
        BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println("bi=%d".formatted(bi)); 
        bi = bi.add(BigInteger.ONE);
        System.out.println("bi=%d".formatted(bi)); 
	}

}
