package fiap.scj.springmvc.beans;

import java.util.ArrayList;

public class Teste {

	public String login;
	public String senha;
	public boolean permissao = true;
	
	private ArrayList<Gif> favoritos = new ArrayList<Gif>(){{
		add(new Gif("desc",  "clsItr", "idioma", "g1"));
		add(new Gif("desc2",  "clsItr", "idioma", "g2"));
		add(new Gif("desc3",  "clsItr", "idioma",  "g3"));
		add(new Gif("desc2",  "clsItr", "idioma",  "g4"));
		add(new Gif("desc3",  "clsItr", "idioma",  "g5"));
		add(new Gif("desc",  "clsItr", "idioma", "g6"));
		add(new Gif("desc2",  "clsItr", "idioma", "g7"));
		add(new Gif("desc3",  "clsItr", "idioma",  "g8"));
		add(new Gif("desc2",  "clsItr", "idioma",  "g9"));
		add(new Gif("desc3",  "clsItr", "idioma",  "g10"));
	}};
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public ArrayList<Gif> getGifs() {
		return favoritos;
	}
	public void setGifs(ArrayList<Gif> gifs) {
		this.favoritos = gifs;
	}
	public boolean isPermissao() {
		return permissao;
	}
	public void setPermissao(boolean permissao) {
		this.permissao = permissao;
	}
}
