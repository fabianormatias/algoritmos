package br.com.waiso.encrypt.des.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.encrypt.des.app.EncriptaDecriptaDES;

public class TesteEncriptaDES {

	@Test
	public void test()  {
		String palavra = "Fabiano Rodrigues";
		
		EncriptaDecriptaDES encriptar = new EncriptaDecriptaDES();
		
		//Criptografar
		byte[] palavraCriptografada = encriptar.encriptarDES(palavra);
		System.out.println("Palavra Criptografada: " + palavraCriptografada);
		
		//Descriptografar
		String palavraDescriptografada = encriptar.desencriptarDES(palavraCriptografada);
		System.out.println("Palavra Descriptografada: " + palavraDescriptografada);
		
		Assert.assertEquals(palavra, palavraDescriptografada);
	}

}
