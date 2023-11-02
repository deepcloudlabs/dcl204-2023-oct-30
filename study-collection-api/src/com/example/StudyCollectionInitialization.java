package com.example;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudyCollectionInitialization {

	public static void main(String[] args) {
		var list = List.of(4, 8, 15, 16, 23, 42);
		var set = Set.of(4, 8, 15, 16, 23, 42);
		var map = Map.of(
			"ankara"		  , 312,
			"istanbul-anadolu", 216,
			"istanbul-avrupa" , 212
		);
		// Error: list.add(42);
		// Error: map.put("izmir", 111);
	}

}
