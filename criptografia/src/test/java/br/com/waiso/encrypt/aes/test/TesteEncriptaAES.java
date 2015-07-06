package br.com.waiso.encrypt.aes.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.waiso.encrypt.aes.app.EncriptaDecriptaAES;

public class TesteEncriptaAES {

	@Test
	public void test()  {
		String palavra = "Fabiano Rodrigues";
		String chaveencriptacao = "0123456789abcdef";
		
		EncriptaDecriptaAES encriptar = new EncriptaDecriptaAES();
		
		//Criptografar
		byte[] textoencriptado = null;
		try {
			textoencriptado = encriptar.encrypt(palavra, chaveencriptacao);
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
			palavraDescriptografada = encriptar.decrypt(textoencriptado, chaveencriptacao);
			System.out.println("Palavra Descriptografada: " + palavraDescriptografada);
		} catch (Exception e) {
			System.out.println("Erro na incriptação: " + e.getMessage());
		}
		
		Assert.assertEquals(palavra, palavraDescriptografada);
	}

}
