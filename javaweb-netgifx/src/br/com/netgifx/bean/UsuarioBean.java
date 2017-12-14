package br.com.netgifx.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.netgifx.dao.GenericDAO;
import br.com.netgifx.entity.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private GenericDAO<Usuario> usuarioDAO = new GenericDAO<>(Usuario.class);
	private List<Usuario> listaUsuarios = new ArrayList<>();
	
	public UsuarioBean() {
		usuario = new Usuario();
		listaUsuarios = usuarioDAO.listar();
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public String cadastrar() {
		usuarioDAO.adicionar(this.usuario);
		this.usuario = new Usuario();
		this.listaUsuarios = usuarioDAO.listar();
		return "cadastro_usuario?faces-redirect=true";
	}
	public String carregar(int id) {
		usuario = usuarioDAO.buscar(id);
		return "exclui_usuario?faces-redirect=true";
	}
	public String excluir() {
		usuarioDAO.remover(this.usuario);
		this.usuario = new Usuario();
		this.listaUsuarios = usuarioDAO.listar();
		return "cadastro_usuario?faces-redirect=true";
	}
}
