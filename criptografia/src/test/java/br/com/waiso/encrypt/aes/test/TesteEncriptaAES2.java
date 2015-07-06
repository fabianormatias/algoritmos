package br.com.waiso.encrypt.aes.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.encrypt.aes.app.EncriptaDecriptaAES;

public class TesteEncriptaAES2 {

	@Test
	public void test()  {
		String palavra = "Fabiano Rodrigues";
		
		EncriptaDecriptaAES encriptar = new EncriptaDecriptaAES();
		
		//Criptografar
		byte[] textoencriptado = null;
		try {
			textoencriptado = encriptar.encrypt(palavra);
			System.out.print("Palavra Criptografada: ");
			for (int i = 0; i < textoencriptado.length; i++) {
				System.out.print(new Integer(textoencriptado[i]) + " ");
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		//Descriptografar
		String palavraDescriptografada = "";
		try {
			palavraDescriptografada = encriptar.decrypt(textoencriptado);
			System.out.println("\nPalavra Descriptografada: " + palavraDescriptografada);
		} catch (Exception e) {
			System.out.println("Erro na incriptação: " + e.getMessage());
		}
		
		Assert.assertEquals(palavra, palavraDescriptografada);
	}

}
