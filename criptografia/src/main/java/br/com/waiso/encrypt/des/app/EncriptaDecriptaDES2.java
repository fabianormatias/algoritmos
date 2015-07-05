package br.com.waiso.encrypt.des.app;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
/**
 * Adicionei a Exception do encriptador para forçar o usuário a tratar a mensagem de erro (checked exception)
 * @author fabianomatias
 *
 */
public class EncriptaDecriptaDES2 {

	SecretKey chaveDES;
	KeyGenerator keygenerator;
	Cipher cifraDES;
	byte[] codigo;
	byte[] bytes;

	public EncriptaDecriptaDES2() throws EncriptaDecriptaException {
		try {
			keygenerator = KeyGenerator.getInstance("DES");
			chaveDES = keygenerator.generateKey();
			cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw new EncriptaDecriptaException(e.getMessage(), e.getCause());
		}
	}

	public byte[] encriptarDES(String textoPuro) throws EncriptaDecriptaException {
		try {
			cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);
			bytes = textoPuro.getBytes();
			codigo = cifraDES.doFinal(bytes);
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			throw new EncriptaDecriptaException(e.getMessage(), e.getCause());
		}
		return codigo;
	}

	public String desencriptarDES(byte[] codigo) throws EncriptaDecriptaException {
		try {
			cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
			bytes = cifraDES.doFinal(codigo);
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			throw new EncriptaDecriptaException(e.getMessage(), e.getCause());
		}
		return new String(bytes);
	}

}