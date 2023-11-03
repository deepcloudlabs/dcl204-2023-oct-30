package com.example.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CachingHandler implements InvocationHandler {
	private static final Map<String,Map<Integer,Object>> cache = new ConcurrentHashMap<>();
	private final Object target;
	
	public CachingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var methodName = method.getName();
		var methodCache = cache.get(methodName);
		if (Objects.isNull(methodCache)) {
			methodCache = new ConcurrentHashMap<Integer,Object>();
			cache.put(methodName, methodCache);
		}
		var key = Objects.hash(args);
		var value = methodCache.get(key);
		if (Objects.isNull(value)) {
			value = method.invoke(target, args);
			methodCache.put(key, value);
		}
		return value;
	}

}
