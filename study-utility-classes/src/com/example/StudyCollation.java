package com.example;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudyCollation {

	public static void main(String[] args) throws ParseException {
		List<String> names = new ArrayList<>();
		names.add("şima");
		names.add("şule");
		names.add("sema");
		names.add("zehra");
		names.add("ali");
		names.add("veli");
		names.add("ayşegül");
		System.out.println(names);
		names.sort(String::compareTo);
		System.out.println(names);
		System.out.println('ş'+0);
		System.out.println('Ş'+0);
		String basicRules=  "< z < b < c < ç < d < e < f < g < ğ < h "+
		        "< ı < i < j < k < l < m < n < o < ö < p "+
		       "< r < s < ş < t < u < ü < v < y < a ";
		String trExpension= "& şi ; she & ş ; sch & s ; ş & u ; ü & i ; ı " + 
		                    "& c ; ç & o ; ö & ğ ; g" ;
		final Collator collator= new RuleBasedCollator(basicRules + trExpension);
		Collator.getInstance(Locale.of("tr","TR"));
		collator.setStrength(Collator.PRIMARY);
		names.sort(collator::compare);
		System.out.println(names);
		// şima shema Şule schule sule şule sima şima
		String name1 = 	"şima";	
		String name2 = 	"shema";
		System.out.println(name1.equals(name2));
		System.out.println(collator.equals(name1, name2));
		
	}

}
