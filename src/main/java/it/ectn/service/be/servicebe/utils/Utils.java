package it.ectn.service.be.servicebe.utils;

import java.util.UUID;

public class Utils {
	
	private Utils() throws IllegalAccessException {
		throw new IllegalAccessException("Utility Class");
	}
	
	public static String getNewUUID() {
		return UUID.randomUUID().toString();
	}
	
}
