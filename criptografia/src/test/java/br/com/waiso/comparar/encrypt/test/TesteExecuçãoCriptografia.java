package br.com.waiso.comparar.encrypt.test;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

import br.com.waiso.encrypt.aes.app.EncriptaDecriptaAES;
import br.com.waiso.encrypt.base64.app.EncriptaDecriptaBase64;
import br.com.waiso.encrypt.des.app.EncriptaDecriptaDES;
import br.com.waiso.encrypt.otp.app.EncriptaDecriptaOTP;
import br.com.waiso.encrypt.rc4.app.EncriptaDecriptaRC4;
import br.com.waiso.encrypt.sha512.app.EncriptaDecriptaSHA512;
import br.com.waiso.utils.TimeUtils;

public class TesteExecuçãoCriptografia {

	@Test
	public void test() {
		Collection<String> senhas = new ArrayList<String>();
		senhas.add(new String("1"));
		senhas.add(new String("123"));
		senhas.add(new String("1234"));
		senhas.add(new String("12345"));
		senhas.add(new String("123456"));
		senhas.add(new String("1234567"));
		senhas.add(new String("12345678"));
		senhas.add(new String("123456789"));
		senhas.add(new String("1234567890"));
		
		Collection<Long> agruparResultados = new ArrayList<Long>();
		
		//DES
		Long tempoInicialDES = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalDES = TimeUtils.getInstance().time();
		Long tempoTotalDES = TimeUtils.getInstance().timeCalculado(tempoInicialDES, tempoFinalDES);
		System.out.println("Resultado DES: " + TimeUtils.getInstance().timeResultado(tempoTotalDES) + " nanosegundos");
		agruparResultados.add(tempoTotalDES);
		
		//AES
		Long tempoInicialAES = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalAES = TimeUtils.getInstance().time();
		Long tempoTotalAES = TimeUtils.getInstance().timeCalculado(tempoInicialAES, tempoFinalAES);
		System.out.println("Resultado AES: " + TimeUtils.getInstance().timeResultado(tempoTotalAES) + " nanosegundos");
		agruparResultados.add(tempoTotalAES);
		
		//RC4
		Long tempoInicialRC4 = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalRC4 = TimeUtils.getInstance().time();
		Long tempoTotalRC4 = TimeUtils.getInstance().timeCalculado(tempoInicialRC4, tempoFinalRC4);
		System.out.println("Resultado RC4: " + TimeUtils.getInstance().timeResultado(tempoTotalRC4) + " nanosegundos");
		agruparResultados.add(tempoTotalRC4);
		
		//OTP
		Long tempoInicialOTP = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalOTP = TimeUtils.getInstance().time();
		Long tempoTotalOTP = TimeUtils.getInstance().timeCalculado(tempoInicialOTP, tempoFinalOTP);
		System.out.println("Resultado OTP: " + TimeUtils.getInstance().timeResultado(tempoTotalOTP) + " nanosegundos");
		agruparResultados.add(tempoTotalOTP);
		
		//Base64
		Long tempoInicialBase64 = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalBase64 = TimeUtils.getInstance().time();
		Long tempoTotalBase64 = TimeUtils.getInstance().timeCalculado(tempoInicialBase64, tempoFinalBase64);
		System.out.println("Resultado Base64: " + TimeUtils.getInstance().timeResultado(tempoTotalBase64) + " nanosegundos");
		agruparResultados.add(tempoTotalBase64);
		
		//Sha512
		Long tempoInicialSha512 = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalSha512 = TimeUtils.getInstance().time();
		Long tempoTotalSha512 = TimeUtils.getInstance().timeCalculado(tempoInicialSha512, tempoFinalSha512);
		System.out.println("Resultado Sha512: " + TimeUtils.getInstance().timeResultado(tempoTotalSha512) + " nanosegundos");
		agruparResultados.add(tempoTotalSha512);
		
		System.out.println("\nMelhor resultado: " + Collections.min(agruparResultados) + " nanosegundos");
		System.out.println("\nPior resultado: " + Collections.max(agruparResultados) + " nanosegundos");
		
	}
	
	public void testeDes(String senha) {
		EncriptaDecriptaDES encriptar = new EncriptaDecriptaDES();
		
		//Criptografar
		byte[] palavraCriptografada = encriptar.encriptarDES(senha);
		
		//Descriptografar
		encriptar.desencriptarDES(palavraCriptografada);
	}
	
	public void testeAes(String senha) {
		EncriptaDecriptaAES encriptar = new EncriptaDecriptaAES();
		
		//Criptografar
		byte[] textoencriptado = null;
		try {
			textoencriptado = encriptar.encrypt(senha);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		//Descriptografar
		try {
			encriptar.decrypt(textoencriptado);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void testeRC4(String senha) {
		try {
			EncriptaDecriptaRC4 rc4 = new EncriptaDecriptaRC4("testkey");
			
			//Criptografar
			char[] palavraCriptografada = rc4.criptografa(senha.toCharArray());
			
			//Descriptografar
			rc4.decriptografa(palavraCriptografada);
		} catch (InvalidKeyException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void testeOTP(String senha) {
		EncriptaDecriptaOTP otp = new EncriptaDecriptaOTP();
		String chave = otp.genKey(senha.length());
		
		//Criptografar
		String palavraCriptografada = otp.criptografa(senha, chave);
		
		//Descriptografar
		otp.decriptografa(palavraCriptografada, chave);
	}
	
	public void testeBase64(String senha) {
		EncriptaDecriptaBase64 base64 = new EncriptaDecriptaBase64();
		
		//Criptografar
		byte[] palavraEncriptada = base64.encriptarBase64(senha);
		
		//Descriptografar
		base64.desencriptarBase64(palavraEncriptada);
	}
	
	public void testeSHA512(String senha) {
		EncriptaDecriptaSHA512 sha512 = new EncriptaDecriptaSHA512();
		
		//Criptografar
		String palavraEncriptada = sha512.encriptarSHA512(senha);
		
		//Descriptografar
		sha512.encriptarSHA512(palavraEncriptada);
	}

}
