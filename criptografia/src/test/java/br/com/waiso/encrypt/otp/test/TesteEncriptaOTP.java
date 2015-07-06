package br.com.waiso.encrypt.otp.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.encrypt.otp.app.EncriptaDecriptaOTP;

public class TesteEncriptaOTP {

	@Test
	public void test()  {
		
		String palavra = "Fabiano Rodrigues";
		
		EncriptaDecriptaOTP otp = new EncriptaDecriptaOTP();
		String chave = otp.genKey(palavra.length());
		
		//Criptografar
		String palavraCriptografada = otp.criptografa(palavra, chave);
		System.out.println("Texto Criptografado: " + palavraCriptografada);
		
		//Descriptografar
		String palavraDescriptografada = otp.decriptografa(palavraCriptografada, chave);
		System.out.println("Palavra Descriptografada: " + palavraDescriptografada);
		
		Assert.assertEquals(palavra, palavraDescriptografada);
	}

}
