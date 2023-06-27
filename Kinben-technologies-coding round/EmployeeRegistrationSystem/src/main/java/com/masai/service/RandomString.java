package com.masai.service;

import java.util.Random;

public class RandomString {
	
	public static String getRandomStringNumber() {
		Random random = new Random();
		int number = random.nextInt(999999);
		
		return String.format("%06d", number);
	}

}
