package br.com.waiso.filas;

import java.util.Scanner;

/**
 * Continuar o algoritmo
 *
 */
public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner recebe = new Scanner(System.in);
		int opcao = 0;
		String modelo;
		LavaRapido lavaRapido = new LavaRapido();

		// Menu
		System.out.println("Digite: \n1-Adicionar Carro na Fila." + "\n2-Atender Carro." + "\n3-FIM");
		opcao = recebe.nextInt();

		if (opcao == 1) {
			System.out.println("Digite o modelo do carro:");
			modelo = recebe.next();
			Carro carro = new Carro(modelo);
			lavaRapido.adicionarCarro(carro);
		}
		if (opcao == 2) {
			lavaRapido.atenderCarro();
		}
		if (opcao == 3) {
			System.exit(0);
		}
	}
}