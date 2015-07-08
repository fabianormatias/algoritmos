package br.com.waiso.encrypt.sha512.app;

import org.apache.commons.codec.digest.DigestUtils;

public class EncriptaDecriptaSHA512 {
	
	private String salt = "uuid-7981383252074976350";
	private StringBuilder sb;
	private byte[] hash;
	private String hexadecimal;
	
	private static EncriptaDecriptaSHA512 instance = new EncriptaDecriptaSHA512();

	public static EncriptaDecriptaSHA512 getInstance() {
		return instance;
	}
	
	public EncriptaDecriptaSHA512(){
	}
	
	public String encriptarSHA512(String textoPuro) {
		sb = new StringBuilder(textoPuro);
		hash = DigestUtils.sha512((sb.append(salt).toString()).getBytes());
		hexadecimal = DigestUtils.sha512Hex(hash);
		return hexadecimal;
	}
	
}
