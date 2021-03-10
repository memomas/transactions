package com.memomas.springboot.backend.apirest.utils;

import java.security.SecureRandom;

public class UtilMethods {
	private static volatile SecureRandom numberGenerator = null;
	private static final long MSB = 0x8000000000000000L;

	public static String generateUUID() {
		SecureRandom ng = numberGenerator;
		if (ng == null) {
			numberGenerator = ng = new SecureRandom();
		}
		return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
	} 
}
