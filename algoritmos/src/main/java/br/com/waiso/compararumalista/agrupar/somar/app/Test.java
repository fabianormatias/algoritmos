package br.com.waiso.compararumalista.agrupar.somar.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.waiso.compararumalista.agrupar.somar.model.Produto;
import br.com.waiso.utils.StringUtils;

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
		Collection<Produto> listaProdutos = new ArrayList<Produto>(); //Pode-se fazer também com HashSet...dizem ser mais performático
		
		//Instanciar produtos da lista 1
		Produto produto1 = new Produto(1, "X", "A", 10.00, 10.00, 10);
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
		
		//Map que irá receber os objetos agrupados
		Map<String, ArrayList<Produto>> agruparProdutos = new HashMap<String, ArrayList<Produto>>();
		
		//Agrupar por nome
		for (Produto produto : listaProdutos) {
			
			//Criar o map para depois adicionar
			if (!agruparProdutos.containsKey(produto.getNome())) {
				agruparProdutos.put(produto.getNome(), new ArrayList<Produto>());
			}
			
			//Adicionar ao map criado
			agruparProdutos.get(produto.getNome()).add(produto);
		}
				
		//Imprimir agrupado e somado os 3 atributos
		for (Map.Entry<String, ArrayList<Produto>> somarProdutos : agruparProdutos.entrySet()) {
			//Imprimir a chave
			System.out.println("Chave: " + somarProdutos.getKey());
			
			ArrayList<Produto> produtosAgrupados = somarProdutos.getValue();
			
			double valor = 0;
			double peso = 0;
			int quantidade = 0;
			int id = 0;
			String tipo = "";
			for (Produto produto : produtosAgrupados) {
				valor += produto.getValor();
				peso += produto.getPeso();
				quantidade += produto.getQuantidade();
				if (id == 0) id = produto.getId();
				if (StringUtils.isBlank(tipo)) tipo = produto.getTipo();
					
			}
//			System.out.println(" Nome: " + somarProdutos.getKey() + " Valor: " + valor + " Peso: " + peso + " Quantidade: " + quantidade);
			System.out.println("Id: " + id + " Nome: " + somarProdutos.getKey() + " Tipo: " + tipo + " Valor: " + valor + " Peso: " + peso + " Quantidade: " + quantidade);
			System.out.println("\n");
		}

		System.out.println("--------------------------------\n");
		
		//Imprimir todos os produtos sem somar, que estão no map
		//Esse for serve pra validar
		for (Map.Entry<String, ArrayList<Produto>> somarProdutos : agruparProdutos.entrySet()) {
			//Imprimir a chave
			System.out.println("Chave: " + somarProdutos.getKey());
			
			ArrayList<Produto> produtosAgrupados = somarProdutos.getValue();
			
			for (Produto produto : produtosAgrupados) {
				System.out.println("Id: " + produto.getId() + " Nome: " + produto.getNome() + " Tipo: " + produto.getTipo() + " Valor: " + produto.getValor() + " Peso: " + produto.getPeso() + " Quantidade: " + produto.getQuantidade());
			}
			System.out.println("\n");
		}
		
	}
}