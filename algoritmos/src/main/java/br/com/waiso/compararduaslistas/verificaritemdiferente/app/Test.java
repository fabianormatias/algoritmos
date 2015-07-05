package br.com.waiso.compararduaslistas.verificaritemdiferente.app;

import java.util.ArrayList;
import java.util.Collection;

import br.com.waiso.compararduaslistas.verificaritemdiferente.model.Produto;

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
		Collection<Produto> listaNovosProdutos = new ArrayList<Produto>();
		
		//Instanciar produtos da lista 1
		Produto produto1 = new Produto(1, "A");
		Produto produto2 = new Produto(2, "B");
		Produto produto3 = new Produto(3, "C");
		Produto produto4 = new Produto(4, "D");
//		Produto produto5 = new Produto(5, "E");
		
		listaNovosProdutos.add(produto1);
		listaNovosProdutos.add(produto2);
		listaNovosProdutos.add(produto3);
		listaNovosProdutos.add(produto4);
//		listaNovosProdutos.add(produto5);
		
		//Lista 2
		Collection<Produto> listaVelhosProdutos = new ArrayList<Produto>();
		
		//Instanciar produtos da lista 2
		Produto produto6 = new Produto(1, "A");
		Produto produto7 = new Produto(2, "B");
		Produto produto8 = new Produto(4, "D");
		Produto produto9 = new Produto(3, "G");
		
		listaVelhosProdutos.add(produto6);
		listaVelhosProdutos.add(produto7);
		listaVelhosProdutos.add(produto8);
		listaVelhosProdutos.add(produto9);
		
		// Primeiro método
		Integer contador = 0;
		if (listaNovosProdutos.size() == listaVelhosProdutos.size()) {
			for (Produto produtoVelho : listaVelhosProdutos) {
				if (!listaNovosProdutos.contains(produtoVelho)) {
					System.out.println("A LISTA É DIFERENTE");
					contador++;
				}
			}
			if (contador == 0) System.out.println("A LISTA É IGUAL");
		} else {
			System.out.println("A LISTA É DIFERENTE");
		}
	}
}
