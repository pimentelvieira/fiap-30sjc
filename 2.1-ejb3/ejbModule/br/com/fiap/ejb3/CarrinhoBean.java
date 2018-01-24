package br.com.fiap.ejb3;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class CarrinhoBean implements Carrinho {
	private List<Item> itens = new ArrayList();

	public CarrinhoBean() {
	}

	public void cadastrarItem(Item item) {
		itens.add(item);
		System.out.println("Item cadastrado com sucesso: " + item.getNome());
	}

	public List<Item> obterMedicamentos() {
		return this.itens;
	}

	public int obterQuantidadeItens() {
		return this.itens.size();
	}

	public void removerCadastro(int matricula) {
		// remove usuario do banco de dados
	}
}