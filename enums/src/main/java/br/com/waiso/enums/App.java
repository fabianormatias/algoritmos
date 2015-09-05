package br.com.waiso.enums;

public class App {

	enum Estacao {
		INVERNO, PRIMAVERA, VERAO, OUTONO;
	};

	public static void main(String[] args) {
		Estacao e = Estacao.INVERNO;
		System.out.println(e.ordinal() + " " + e.name() + "\n"); // 0 INVERNO
		
		for (Estacao estacao : Estacao.values()) {
			System.out.println("Posição: " + estacao.ordinal() + " Estação: " + estacao.name());
//			System.out.println("Estação: " + estacao.toString()+ "\n");
		}
	}
}