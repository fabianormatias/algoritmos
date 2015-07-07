package br.com.waiso.encrypt.sha512.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.encrypt.sha512.app.EncriptaDecriptaSHA512;

public class TesteEncriptaSHA512 {

	@Test
	public void test()  {
		
		String palavra = "Fabiano Rodrigues";
		
		//Criptografar
		String palavraEncriptada = EncriptaDecriptaSHA512.getInstance().encriptarSHA512(palavra);
		System.out.println("Palavra criptografada: " + new String(palavraEncriptada));
		
		String palavraEncriptadaNovamente = EncriptaDecriptaSHA512.getInstance().encriptarSHA512(palavra);
		System.out.println("Palavra criptografada: " + new String(palavraEncriptadaNovamente));
		
		Assert.assertEquals(palavraEncriptada, palavraEncriptadaNovamente);
	}

}
