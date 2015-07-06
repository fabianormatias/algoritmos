package br.com.waiso.encrypt.des.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.encrypt.des.app.EncriptaDecriptaDES2;
import br.com.waiso.encrypt.des.app.EncriptaDecriptaException;

public class TesteEncriptaDES2 {

	@Test
	public void test()  {
		String palavra = "Fabiano Rodrigues";
		
		EncriptaDecriptaDES2 encriptar;
		try {
			encriptar = new EncriptaDecriptaDES2();

			//Criptografar
			byte[] palavraCriptografada = encriptar.encriptarDES(palavra);
			System.out.println("Palavra Criptografada: " + palavraCriptografada);
			
			//Descriptografar
			String palavraDescriptografada = encriptar.desencriptarDES(palavraCriptografada);
			System.out.println("Palavra Descriptografada: " + palavraDescriptografada);
			
			Assert.assertEquals(palavra, palavraDescriptografada);
		} catch (EncriptaDecriptaException e) {
			System.out.println("Erro na incriptação: " + e.getMessage());
		}
	}

}