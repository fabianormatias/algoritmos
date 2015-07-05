package br.com.waiso.compararduaslistas.verificaritemdiferente.paraalterar.app;

import java.util.ArrayList;
import java.util.Collection;

import br.com.waiso.compararduaslistas.verificaritemdiferente.paraalterar.model.Produto;

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
		Produto produto1 = new Produto(1, "A", "A");
		Produto produto2 = new Produto(2, "B", "B");
		Produto produto3 = new Produto(3, "C", "C");
		Produto produto4 = new Produto(4, "D", "E");
		Produto produto5 = new Produto(6, "E", "G");
//		Produto produto5 = new Produto(6, "F", "F");
		
		listaNovosProdutos.add(produto1);
		listaNovosProdutos.add(produto2);
		listaNovosProdutos.add(produto3);
		listaNovosProdutos.add(produto4);
		listaNovosProdutos.add(produto5);
		
		//Lista 2
		Collection<Produto> listaVelhosProdutos = new ArrayList<Produto>();
		
		//Instanciar produtos da lista 2
		Produto produto6 = new Produto(1, "A", "A");
		Produto produto7 = new Produto(2, "B", "B");
		Produto produto8 = new Produto(3, "C", "C");
		Produto produto9 = new Produto(4, "D", "D");
		Produto produto10 = new Produto(7, "G", "G");
		
		listaVelhosProdutos.add(produto6);
		listaVelhosProdutos.add(produto7);
		listaVelhosProdutos.add(produto8);
		listaVelhosProdutos.add(produto9);
		listaVelhosProdutos.add(produto10);
		
		//Primeiro método
		for (Produto produtoVelho : listaVelhosProdutos) {
			if (!listaNovosProdutos.contains(produtoVelho)) {
				for (Produto produtoNovo : listaNovosProdutos) {
					if (produtoNovo.getId().equals(produtoVelho.getId())) {
						listaNovosProdutos.remove(produtoVelho);
						System.out.println("ID IGUAL, ATUALIZAR: " + produtoVelho.getNome());
					}
				}
			} else {
				listaNovosProdutos.remove(produtoVelho);
				System.out.println("NÃO PRECISA FAZER NADA: " + produtoVelho.getNome());
			}
		}
		
		for (Produto produtoNovo : listaNovosProdutos) {
			System.out.println("ATUAR:" + produtoNovo.getNome());
		}
		
		//Inserir os objetos novos
//		for (Produto produtoNovo : listaNovosProdutos) {
//			if (!listaVelhosProdutos.contains(produtoNovo)) {
//				System.out.println("INSERIR: " + produtoNovo.getNome());
//			}
//		}
	}
}
