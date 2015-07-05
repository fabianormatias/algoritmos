package br.com.waiso.compararumalista.verificaritemrepetido.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.com.waiso.compararumalista.verificaritemrepetido.model.Produto;

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
		Produto produto1 = new Produto(1, "X", "A");
		Produto produto2 = new Produto(2, "B", "B");
		Produto produto3 = new Produto(3, "C", "B");
		Produto produto4 = new Produto(4, "D", "A");
		Produto produto5 = new Produto(1, "A", "A");
		Produto produto6 = new Produto(1, "B", "B");
		
		listaNovosProdutos.add(produto1);
		listaNovosProdutos.add(produto2);
		listaNovosProdutos.add(produto3);
		listaNovosProdutos.add(produto4);
		listaNovosProdutos.add(produto5);
		listaNovosProdutos.add(produto6);
		
		// Primeiro método
		Set<String> key = new HashSet<String>();
		StringBuilder sb;
		
		//Concatenar itens e incluir na lista
		for (Produto produto : listaNovosProdutos) {
			sb = new StringBuilder();
			sb.append(produto.getNome());
			sb.append(produto.getTipo());
			if (key.contains(sb.toString())) {
				System.out.println("ITEM JÁ EXISTE " + sb.toString());
			}
			key.add(sb.toString());
		}
		
	}
}