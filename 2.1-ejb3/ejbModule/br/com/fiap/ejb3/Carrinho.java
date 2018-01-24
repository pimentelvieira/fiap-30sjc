package br.com.fiap.ejb3;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Carrinho {

	void cadastrarItem(Item item);
	List<Item> obterMedicamentos();
	int obterQuantidadeItens();
	void removerCadastro(int matricula);
}
