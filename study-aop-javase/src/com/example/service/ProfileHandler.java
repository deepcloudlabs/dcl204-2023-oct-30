package com.example.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfileHandler implements InvocationHandler {
	private final Object target;

	public ProfileHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var methodName = method.getName();
		long start = System.nanoTime();
		var result = method.invoke(target, args);
		long stop = System.nanoTime();
		System.out.println("%s runs %d ns.".formatted(methodName ,(stop-start)));
		return result;
	}

}
