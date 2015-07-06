package br.com.waiso.encrypt.md5.app;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.waiso.encrypt.base64.app.EncriptaDecriptaBase64;

public class EncriptaDecriptaMD5 {
	
	private static EncriptaDecriptaMD5 instance = new EncriptaDecriptaMD5();

	public static EncriptaDecriptaMD5 getInstance() {
		return instance;
	}
	
	public EncriptaDecriptaMD5(){
	}
	
	public byte[] encriptarMD5(String textoPuro) {
		return DigestUtils.md5(textoPuro.getBytes());
	}
	
	public byte[] desencriptarMD5(byte[] codigo) {
		return DigestUtils.md5(codigo);
	}
	
	public static void main(String[] args) {
		
		String textoPuro = "Fabiano Rodrigues";
		
		//Criptografar
		byte[] palavraEncriptada = EncriptaDecriptaBase64.getInstance().encriptarBase64(textoPuro);
		System.out.println("Palavra criptografada: " + new String(palavraEncriptada));
		
		//Descriptografar
		byte[] palavraDescriptada = EncriptaDecriptaBase64.getInstance().desencriptarBase64(palavraEncriptada);
		System.out.println("Palavra criptografada: " + new String(palavraDescriptada));
		
	}

}
