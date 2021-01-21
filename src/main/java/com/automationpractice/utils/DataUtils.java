package com.automationpractice.utils;

import com.github.javafaker.Faker;

public class DataUtils {

	public static String getFirstName() {
		return new Faker().address().firstName();
	}

	public static String getLastName() {
		return new Faker().address().lastName();
	}
	
	

	public static String getUniquePassword() {
		String password = new Faker().lorem().characters(8, 10);
		String specialChars = "@!#$%*Aa";
		password = password.replace(password.charAt(new Faker().random().nextInt(password.length())),
				specialChars.charAt(new Faker().random().nextInt(specialChars.length())));

		return password;
	}

}
