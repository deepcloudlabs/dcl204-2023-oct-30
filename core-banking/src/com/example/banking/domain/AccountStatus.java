package com.example.banking.domain;

public enum AccountStatus implements Fun {
	CLOSED() {
		@Override
		public void fun() {
			System.out.println("Have fun with CLOSED!");
		}
	},
	ACTIVE(200) {
		@Override
		synchronized public void fun() {
			System.out.println("Have fun with ACTIVE!");
		}
	},
	BLOCKED(300);

	private transient final int bddkCode;

	private AccountStatus() {
		this.bddkCode = 100;
	}
	
	private AccountStatus(int bddkCode) {
		this.bddkCode = bddkCode;
	}
	

	public int getBddkCode() {
		return bddkCode;
	}

	@Override
	public void fun() {
		System.out.println("Have fun with AccountStatus!");
	}
}

interface Fun {
	void fun();
}