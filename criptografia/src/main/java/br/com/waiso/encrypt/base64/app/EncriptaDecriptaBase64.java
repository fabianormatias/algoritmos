package br.com.waiso.encrypt.base64.app;

import org.apache.commons.codec.binary.Base64;

public class EncriptaDecriptaBase64 {
	
	private static EncriptaDecriptaBase64 instance = new EncriptaDecriptaBase64();

	public static EncriptaDecriptaBase64 getInstance() {
		return instance;
	}
	
	public EncriptaDecriptaBase64(){
	}
	
//	public byte[] encriptarBase64(String textoPuro) {
//		return Base64.encodeBase64(textoPuro.getBytes());
//	}
//	
//	public byte[] desencriptarBase64(byte[] codigo) {
//		return Base64.decodeBase64(codigo);
//	}
	
	public String encriptarBase64(String textoPuro) {
		return new String(Base64.encodeBase64(textoPuro.getBytes()));
	}
	
	public String desencriptarBase64(String codigo) {
		byte[] key = codigo.getBytes();
		return new String(Base64.decodeBase64(key));
	}
	
	public static void main(String[] args) {
		
		String textoPuro = "Fabiano Rodrigues";
		
//		//Criptografar
//		byte[] palavraEncriptada = EncriptaDecriptaBase64.getInstance().encriptarBase64(textoPuro);
//		System.out.println("Palavra criptografada: " + new String(palavraEncriptada));
//		
//		//Descriptografar
//		byte[] palavraDescriptada = EncriptaDecriptaBase64.getInstance().desencriptarBase64(palavraEncriptada);
//		System.out.println("Palavra criptografada: " + new String(palavraDescriptada));
		
		//Criptografar
		String palavraEncriptada = EncriptaDecriptaBase64.getInstance().encriptarBase64(textoPuro);
		System.out.println("Palavra criptografada: " + palavraEncriptada);
		
		//Descriptografar
		String palavraDescriptada = EncriptaDecriptaBase64.getInstance().desencriptarBase64(palavraEncriptada);
		System.out.println("Palavra criptografada: " + palavraDescriptada);
		
		if (textoPuro.equals(palavraDescriptada)) {
			System.out.println("Iguais");
		} else {
			System.out.println("Diferentes");
		}
		
	}

}