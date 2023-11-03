package com.example.banking.application;

public class StudyTryWithResources {

	public static void main(String[] args) {
		var resource1 = new PreciousResource(1);
		var resource2 = new PreciousResource(2);
		var resource3 = new PreciousResource(3);
		
		try {
			// using resources
		} finally {
			try {
				resource1.close();
			} catch (Exception e) {
				System.err.println("Error has occured while closing the resource1: %s".formatted(e.getMessage()));
			} finally {
				try {
					resource2.close();
				} catch (Exception e) {
					System.err.println("Error has occured while closing the resource2: %s".formatted(e.getMessage()));
				} finally {
					try {
						resource3.close();
					} catch (Exception e) {
						System.err
								.println("Error has occured while closing the resource3: %s".formatted(e.getMessage()));
					}
				}
			}
		}
	}

}

class PreciousResource implements AutoCloseable {
	private final int resourceId;

	public PreciousResource(int resourceId) {
		this.resourceId = resourceId;
	}

	@Override
	public void close() throws Exception {
		System.err.println("Closing the resource %d".formatted(resourceId));
		throw new RuntimeException("Oooops %d".formatted(resourceId));
	}

}
