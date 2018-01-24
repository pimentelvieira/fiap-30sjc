package br.com.fiap.ejb3.teste;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.fiap.ejb3.session.CarrinhoCompras;

public class CarrinhoComprasStatefulClient {

	public static void main(String[] args) throws Exception {

		Context context = new InitialContext();
		CarrinhoCompras carrinhoCompras = null;
		int contador = 100;
		
		carrinhoCompras = (CarrinhoCompras) context.lookup("CarrinhoComprasBean/remote");
		for (int j = 0; j < contador; j++) {
			Thread.sleep(1000); //1 segundo = 1000 ms
			carrinhoCompras.adicionarProduto(j);
			System.out.println("Produto " + j + " adicionado.");
		}
		
		System.out.println("Quantidade de produtos adicionados: " + carrinhoCompras.verCarrinho().size());
	}
}