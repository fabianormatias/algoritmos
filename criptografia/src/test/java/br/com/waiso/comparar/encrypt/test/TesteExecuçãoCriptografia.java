package br.com.waiso.comparar.encrypt.test;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

import br.com.waiso.encrypt.aes.app.EncriptaDecriptaAES;
import br.com.waiso.encrypt.des.app.EncriptaDecriptaDES;
import br.com.waiso.encrypt.otp.app.EncriptaDecriptaOTP;
import br.com.waiso.encrypt.rc4.app.EncriptaDecriptaRC4;
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
		System.out.println("Resultado DES: " + TimeUtils.getInstance().timeConvert(tempoTotalDES) + " nanosegundos");
		agruparResultados.add(tempoTotalDES);
		
		//AES
		Long tempoInicialAES = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalAES = TimeUtils.getInstance().time();
		Long tempoTotalAES = TimeUtils.getInstance().timeCalculado(tempoInicialAES, tempoFinalAES);
		System.out.println("Resultado AES: " + TimeUtils.getInstance().timeConvert(tempoTotalAES) + " nanosegundos");
		agruparResultados.add(tempoTotalAES);
		
		//RC4
		Long tempoInicialRC4 = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalRC4 = TimeUtils.getInstance().time();
		Long tempoTotalRC4 = TimeUtils.getInstance().timeCalculado(tempoInicialRC4, tempoFinalRC4);
		System.out.println("Resultado RC4: " + TimeUtils.getInstance().timeConvert(tempoTotalRC4) + " nanosegundos");
		agruparResultados.add(tempoTotalRC4);
		
		//OTP
		Long tempoInicialOTP = TimeUtils.getInstance().time();
		for (String senha : senhas) {
			testeDes(senha);
		}
		Long tempoFinalOTP = TimeUtils.getInstance().time();
		Long tempoTotalOTP = TimeUtils.getInstance().timeCalculado(tempoInicialOTP, tempoFinalOTP);
		System.out.println("Resultado OTP: " + TimeUtils.getInstance().timeConvert(tempoTotalOTP) + " nanosegundos");
		agruparResultados.add(tempoTotalOTP);
		
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

}
