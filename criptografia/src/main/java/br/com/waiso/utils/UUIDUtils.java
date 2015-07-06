package br.com.waiso.utils;

import java.util.UUID;

public class UUIDUtils {

	private static UUIDUtils instance = new UUIDUtils();

	public UUIDUtils() {
	}

	public static UUIDUtils getInstance() {
		return instance;
	}

	public String generateUUID() {
		return UUID.randomUUID().getLeastSignificantBits() + "";
	}

}
