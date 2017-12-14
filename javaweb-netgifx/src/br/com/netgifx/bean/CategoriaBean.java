package br.com.netgifx.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.netgifx.dao.GenericDAO;
import br.com.netgifx.entity.Categoria;

@ManagedBean
@SessionScoped
public class CategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final int OPCAO_ALTERAR = 1;
	private static final int OPCAO_EXCLUIR = 2;
	
	private Categoria categoria;
	private GenericDAO<Categoria> categoriaDAO = new GenericDAO<>(Categoria.class);
	private List<Categoria> listaCategorias = new ArrayList<>();

	public CategoriaBean() {
		categoria = new Categoria();
		listaCategorias = categoriaDAO.listar();
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	public String cadastrar() {
		categoriaDAO.adicionar(this.categoria);
		this.categoria = new Categoria();
		this.listaCategorias = categoriaDAO.listar();
		return "cadastro_categoria?faces-redirect=true";
	}
	public String carregar(int opcao, int id) {
		categoria = categoriaDAO.buscar(id);
		if(opcao == getOpcaoAlterar()) {
			return "altera_categoria?faces-redirect=true";
		} else if (opcao == getOpcaoExcluir()) {
			return "exclui_categoria?faces-redirect=true";
		}
		throw new RuntimeException("Opção inexistente!");
	}
	public String alterar() {
		categoriaDAO.atualizar(this.categoria);
		this.categoria = new Categoria();
		this.listaCategorias = categoriaDAO.listar();
		return "cadastro_categoria?faces-redirect=true";
	}
	public String excluir() {
		categoriaDAO.remover(this.categoria);
		this.categoria = new Categoria();
		this.listaCategorias = categoriaDAO.listar();
		return "cadastro_categoria?faces-redirect=true";
	}
	public int getOpcaoAlterar() {
		return OPCAO_ALTERAR;
	}
	public int getOpcaoExcluir() {
		return OPCAO_EXCLUIR;
	}
}
