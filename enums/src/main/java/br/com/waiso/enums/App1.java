package br.com.waiso.enums;

public class App1 {

	public static void main(String[] args) {
		// Seu peso na terra
		double peso = 73.0;

		// Massa na terra
		double massa = peso / Planeta.TERRA.gravidadeSuperficie();
		for (Planeta planeta : Planeta.values()) {
			System.out.println("Seu peso em " + planeta.name() + " \u00e9 " + planeta.pesoSuperficie(massa));
		}
	}
}