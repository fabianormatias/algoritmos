package br.com.waiso.encrypt.rc4.test;

import java.security.InvalidKeyException;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.encrypt.rc4.app.EncriptaDecriptaRC4;

public class TesteEncriptaRC4 {

	@Test
	public void test()  {
		
		String palavra = "Fabiano Rodrigues";
		
		char[] palavraCriptografada;
		char[] palavraDescriptografada = null;
		try {
			EncriptaDecriptaRC4 rc4 = new EncriptaDecriptaRC4("testkey");
			
			//Criptografar
			palavraCriptografada = rc4.criptografa(palavra.toCharArray());
			System.out.println("Texto Criptografado: " + new String(palavraCriptografada));
			
			//Descriptografar
			palavraDescriptografada = rc4.decriptografa(palavraCriptografada);
			System.out.println("Palavra Descriptografada: " + new String(palavraDescriptografada));
		} catch (InvalidKeyException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		Assert.assertEquals(palavra, new String(palavraDescriptografada));
	}

}
