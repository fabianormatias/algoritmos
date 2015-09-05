package br.com.waiso.enums;

public enum FaixaEtaria {

	BEBE(0, 2), CRIANCA(3, 12), ADOLESCENTE(13, 17), ADULTO(18, 59), IDOSO(60, 150);

	private int idadeInicial;
	private int idadeFinal;

	FaixaEtaria(int idadeInicial, int idadeFinal) {
		this.idadeInicial = idadeInicial;
		this.idadeFinal = idadeFinal;
	}

	public boolean isIdadeCompativel(int idade) {
		if (idade >= idadeInicial && idade <= idadeFinal) {
			System.out.println(this.name() + " Idade compat\u00edvel.");
			return true;
		} else {
			System.out.println(this.name() + " Idade n\u00e3o compat\u00edvel.");
			return false;
		}
	}
}