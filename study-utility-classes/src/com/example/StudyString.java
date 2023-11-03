package com.example;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class StudyString {
	public static void main(String[] args) {
		String city = "izmir";
		var tr = Locale.of("tr", "TR"); 
        System.out.println(city.toUpperCase(tr));
        
        ZonedDateTime birthDate = ZonedDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
        		                                 .withLocale(Locale.FRENCH);
        System.out.println(dtf.format(birthDate));
        
        double money = 12_345.678;
        DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.JAPAN);
        System.out.println(df.format(money));
	}
}
