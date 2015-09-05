package br.com.waiso.enums;

public enum Planeta {

	MERCURIO(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), TERRA(5.976e+24, 6.37814e6), MARTE(6.421e+23, 3.3972e6);

	private final double massa; // em kilos
	private final double raio; // em metros

	Planeta(double massa, double raio) { // nao pode ser public
		this.massa = massa;
		this.raio = raio;
	}

	// constante universal gravitacional
	public static final double G = 6.67300E-11;

	public double gravidadeSuperficie() {
		return G * massa / (raio * raio);
	}

	public double pesoSuperficie(double massa) {
		return massa * gravidadeSuperficie();
	}
}