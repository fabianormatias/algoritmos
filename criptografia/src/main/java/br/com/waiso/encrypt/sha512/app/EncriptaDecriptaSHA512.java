package br.com.waiso.encrypt.sha512.app;

import org.apache.commons.codec.digest.DigestUtils;

public class EncriptaDecriptaSHA512 {
	
	private String salt = "uuid-7981383252074976350";
	
	private static EncriptaDecriptaSHA512 instance = new EncriptaDecriptaSHA512();

	public static EncriptaDecriptaSHA512 getInstance() {
		return instance;
	}
	
	public EncriptaDecriptaSHA512(){
	}
	
	public String encriptarSHA512(String textoPuro) {
		byte[] hash = DigestUtils.sha512((textoPuro + salt).getBytes());
		String hexadecimal = DigestUtils.sha512Hex(hash);
		return hexadecimal;
	}
	
}
