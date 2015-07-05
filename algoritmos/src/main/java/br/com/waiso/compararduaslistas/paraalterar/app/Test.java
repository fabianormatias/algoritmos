package br.com.waiso.compararduaslistas.paraalterar.app;

import java.util.ArrayList;
import java.util.Collection;

import br.com.waiso.compararduaslistas.paraalterar.model.Produto;

/**
 * 
 * @author fabianomatias
 * @email fabianormatias@gmail.com
 * @since 25/05/2015
 *
 */
public class Test {

	@org.junit.Test
	public void test(String[] args) {
		//Lista 1
		Collection<Produto> listNovosProdutos = new ArrayList<Produto>();
		
		//Instanciar produtos da lista 1
		Produto produto1 = new Produto(1, "A");
		Produto produto2 = new Produto(2, "B");
		Produto produto3 = new Produto(3, "C");
		Produto produto4 = new Produto(4, "D");
		Produto produto5 = new Produto(5, "E");
		
		listNovosProdutos.add(produto1);
		listNovosProdutos.add(produto2);
		listNovosProdutos.add(produto3);
		listNovosProdutos.add(produto4);
		listNovosProdutos.add(produto5);
		
		//Lista 2
		Collection<Produto> listVelhosProdutos = new ArrayList<Produto>();
		
		//Instanciar produtos da lista 2
		Produto produto6 = new Produto(1, "A");
		Produto produto7 = new Produto(2, "B");
		Produto produto8 = new Produto(4, "D");
		Produto produto9 = new Produto(8, "H");
		
		listVelhosProdutos.add(produto6);
		listVelhosProdutos.add(produto7);
		listVelhosProdutos.add(produto8);
		listVelhosProdutos.add(produto9);
		
		// Primeiro método
		
		//Excluir ou atualizar objetos antigos na tabela
		for (Produto produtoVelho : listVelhosProdutos)	{
			if (listNovosProdutos.contains(produtoVelho)) {
				System.out.println("ATUALIZA : " + produtoVelho.getNome());
			} else {
				System.out.println("REMOVE: " + produtoVelho.getNome());
			}
			listNovosProdutos.remove(produtoVelho);
		}
		
		System.out.println("------------------------------");
		
//		//Inserir os objetos novos
		for (Produto produtoNovo : listNovosProdutos) {
			if (!listVelhosProdutos.contains(produtoNovo)) {
				System.out.println("INSERIR: " + produtoNovo.getNome());
			}
		}
		
		// Segundo método
		
		//Excluir objetos antigos na tabela
//		for (Produto produtoVelho : listVelhosProdutos)	{
//			if (!listNovosProdutos.contains(produtoVelho)) {
//				System.out.println("EXCLUIR: " + produtoVelho.getNome());
//			}
//		}
		
//		System.out.println("------------------------------");
		
		//Alterar ou inserir os objetos novos
//		for (Produto produtoNovo : listNovosProdutos) {
//			if (listVelhosProdutos.contains(produtoNovo)) {
//				System.out.println("ATUALIZAR: " + produtoNovo.getNome());
//			} else {
//				System.out.println("INSERIR: " + produtoNovo.getNome());
//			}
//		}
		
	}
}