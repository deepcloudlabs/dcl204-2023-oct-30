package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class StudyReflection {

	public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		A a = new A(4);
		var fieldData = A.class.getDeclaredField("data");
		fieldData.setAccessible(true);
		fieldData.set(a, 10);
		fieldData.setAccessible(false);
		var props = new Properties();
		props.load(new FileInputStream(new File("resources","lottery.properties")));
		var methodName = props.getProperty("method.name");
		var method = A.class.getDeclaredMethod(methodName);
		var result = method.invoke(a);
		System.out.println(result);
	}

}

class A {
	private int data;

	public A(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public int fun() {
		return data * data * data;
	}

	public int gun() {
		return data * data;
	}
}