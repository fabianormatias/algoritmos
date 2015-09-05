package br.com.waiso.enums;

public class App1 {

	public static void main(String[] args) {
		// Seu peso na terra
		double peso = 67.0;

		// Massa na terra
		double massa = peso / Planeta.TERRA.gravidadeSuperficie();
		for (Planeta p : Planeta.values()) {
			System.out.println("Seu peso em " + p.name() + " \u00e9 " + p.pesoSuperficie(massa));
		}
	}
}