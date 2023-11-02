package com.example;

public class StudyArray {

	public static void main(String[] args) {
		int []numbers = {4,8,15,16,23,42};
		for (var number : numbers) { // loop: for-each, since Java SE 5
			System.out.println(number);
		}		
		for (var i=0;i<numbers.length;++i) {
			var number = numbers[i];
			System.out.println(number);
		}
	}

}
