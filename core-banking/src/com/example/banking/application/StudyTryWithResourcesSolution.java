package com.example.banking.application;

public class StudyTryWithResourcesSolution {

	public static void main(String[] args) {
		try(
				var resource1 = new PreciousResource(1);
				var resource3 = new PreciousResource(3);				
				var resource2 = new PreciousResource(2);
				) {
			// using resources
		}catch (Exception e) {
			System.err.println(e.getMessage());
			for (var t : e.getSuppressed()) {
				System.err.println(t.getMessage());
			}
		}
	}

}