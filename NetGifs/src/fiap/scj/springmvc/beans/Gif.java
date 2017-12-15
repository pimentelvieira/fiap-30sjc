package fiap.scj.springmvc.beans;

import fiap.scj.springmvc.beans.*;

public class Gif {
	
	public String nomeGif = "nomeG";
	public String desc = "desc";
	public String clsItr = "12";
	public String idioma = "english";
	public String categoria;
//
//	public String nomeGif;
//	public String desc ;
//	public String genero ;
//	public String clsItr ;
//	public String idioma ;
//	public String categoria;
	
	public Gif() {
		
	}

	public Gif(String desc, String clsItr, String idioma,  String nomeGif) {
		super();
		this.nomeGif = nomeGif;
		this.categoria = categoria;
		this.desc = desc;

		this.clsItr = clsItr;
		this.idioma = idioma;
	}
	
	public Gif(String desc,String categoria, String clsItr, String idioma,  String nomeGif) {
		super();
		this.nomeGif = nomeGif;
		this.categoria = categoria;
		this.desc = desc;

		this.clsItr = clsItr;
		this.idioma = idioma;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getClsItr() {
		return clsItr;
	}
	public void setClsItr(String clsItr) {
		this.clsItr = clsItr;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
		public String getCategoria() {
			return categoria;
		}
	
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

	public String getNomeGif() {
		return nomeGif;
	}

	public void setNomeGif(String nomeGif) {
		this.nomeGif = nomeGif;
	}
	
	
	
	
}
