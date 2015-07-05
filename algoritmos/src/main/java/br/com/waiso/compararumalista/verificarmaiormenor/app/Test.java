package br.com.waiso.compararumalista.verificarmaiormenor.app;

import java.util.ArrayList;
import java.util.Collection;

import br.com.waiso.compararumalista.agrupar.somar.model.Produto;

/**
 * 
 * @author fabianomatias
 * @email fabianormatias@gmail.com
 * @since 25/05/2015
 *
 */
public class Test {

	public static void main(String[] args) {
		//Lista 1
		Collection<Produto> listaProdutos = new ArrayList<Produto>();
		
		//Instanciar produtos da lista 1
		Produto produto1 = new Produto(1, "X", "A", 10.00, 10.00, 90);
		Produto produto2 = new Produto(2, "B", "B", 20.00, 20.00, 20);
		Produto produto3 = new Produto(3, "C", "C", 30.00, 30.00, 30);
		Produto produto4 = new Produto(4, "D", "D", 40.00, 40.00, 40);
		Produto produto5 = new Produto(5, "X", "E", 50.00, 50.00, 50);
		Produto produto6 = new Produto(6, "B", "F", 60.00, 60.00, 60);
		
		listaProdutos.add(produto1);
		listaProdutos.add(produto2);
		listaProdutos.add(produto3);
		listaProdutos.add(produto4);
		listaProdutos.add(produto5);
		listaProdutos.add(produto6);
		
		Integer menorQuantidade = null;
		Integer maiorQuantidade = null;
		
		for (Produto produto : listaProdutos) {
			if (menorQuantidade == null || menorQuantidade > produto.getQuantidade()) {
				menorQuantidade = produto.getQuantidade();
			}
			if (maiorQuantidade == null || maiorQuantidade < produto.getQuantidade()) {
				maiorQuantidade = produto.getQuantidade();
			}
		}
		
		System.out.println("Menor quantidade: " + menorQuantidade);
		System.out.println("Maior quantidade: " + maiorQuantidade);
		
	}
}