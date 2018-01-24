package br.com.fiap.ejb3;

import java.io.Serializable;

public class Item implements Serializable {
	
	private static final long serialVersionUID = 7L;
	
	//private transient String nome;
	private String nome;
	private double preco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
