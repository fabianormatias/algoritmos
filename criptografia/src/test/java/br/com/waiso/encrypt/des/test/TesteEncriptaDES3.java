package br.com.waiso.encrypt.des.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.encrypt.des.app.EncriptaDecriptaDES3;

public class TesteEncriptaDES3 {

	@Test
	public void test()  {
		String palavra = "Fabiano Rodrigues";
		
		EncriptaDecriptaDES3 encriptar;
		try {
			encriptar = new EncriptaDecriptaDES3();

			//Criptografar
			byte[] palavraCriptografada = encriptar.encriptarDES(palavra);
			System.out.println("Palavra Criptografada: " + palavraCriptografada);
			
			//Descriptografar
			String palavraDescriptografada = encriptar.desencriptarDES(palavraCriptografada);
			System.out.println("Palavra Descriptografada: " + palavraDescriptografada);
			
			Assert.assertEquals(palavra, palavraDescriptografada);
		} catch (Exception e) {
			System.out.println("Erro na incriptação: " + e.getMessage());
		}
	}

}
