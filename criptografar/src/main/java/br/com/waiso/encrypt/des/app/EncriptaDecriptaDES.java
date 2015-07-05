package br.com.waiso.encrypt.des.app;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class EncriptaDecriptaDES {

	SecretKey chaveDES;
	KeyGenerator keygenerator;
	Cipher cifraDES;
	byte[] codigo;
	byte[] bytes;

	public EncriptaDecriptaDES() {
		try {
			keygenerator = KeyGenerator.getInstance("DES");
			chaveDES = keygenerator.generateKey();
			cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public byte[] encriptarDES(String textoPuro) {
		try {
			cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);
			bytes = textoPuro.getBytes();
			codigo = cifraDES.doFinal(bytes);
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return codigo;
	}

	public String desencriptarDES(byte[] codigo) {
		try {
			cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
			bytes = cifraDES.doFinal(codigo);
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return new String(bytes);
	}

}