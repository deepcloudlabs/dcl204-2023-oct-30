package com.example;

import java.util.HashMap;
import java.util.Map;

public class StudyMap {

	public static void main(String[] args) {
		// HashMap, LinkedHashMap, TreeMap, IdentityMap, EnumMap, ConcurrentHashMap, ... 
		Map<String, Integer> areaCodes = new HashMap<>(1_000_000,0.5f);
		areaCodes.put("ankara", 312);
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("istanbul-avrupa", 212);
		System.out.println(areaCodes.get("istanbul-anadolu"));
		for (var city : areaCodes.keySet()) {
			System.out.println("%-16s: %d".formatted(city, areaCodes.get(city)));
		}
		for (var code : areaCodes.values()) {
			System.out.println(code);	
		}
		for (var entry : areaCodes.entrySet()) {
			System.out.println("%-16s: %d".formatted(entry.getKey(), entry.getValue()));
		}
	}

}
