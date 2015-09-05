package br.com.waiso.enums;

public class App2 {

	public static void main(String[] args) {
		FaixaEtaria.ADOLESCENTE.isIdadeCompativel(12);
		for (FaixaEtaria f : FaixaEtaria.values()) {
			f.isIdadeCompativel(32);
		}
	}
}