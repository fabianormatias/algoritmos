package br.com.waiso.encrypt.des.app;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
/**
 * Adicionei a Exception do encriptador para forçar o usuário a tratar a mensagem de erro (checked exception)
 * @author fabianomatias
 *
 */
public class EncriptaDecriptaDES3 {

	SecretKey chaveDES;
	KeyGenerator keygenerator;
	Cipher cifraDES;
	byte[] codigo;
	byte[] bytes;

	public EncriptaDecriptaDES3() throws Exception {
		keygenerator = KeyGenerator.getInstance("DES");
		chaveDES = keygenerator.generateKey();
		cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
	}

	public byte[] encriptarDES(String textoPuro) throws Exception {
		cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);
		bytes = textoPuro.getBytes();
		codigo = cifraDES.doFinal(bytes);
		return codigo;
	}

	public String desencriptarDES(byte[] codigo) throws Exception {
		cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
		bytes = cifraDES.doFinal(codigo);
		return new String(bytes);
	}

}