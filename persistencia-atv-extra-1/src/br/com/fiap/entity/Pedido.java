package br.com.fiap.entity;

import java.util.Date;

public class Pedido {

	private int idCliente;
	private int id;
	private Date data;
	private String descricao;
	private double valor;
	
	public Pedido(int idCliente, Date data, String descricao, double valor) {
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Pedido(int id, int idCliente, Date data, String descricao, double valor) {
		this.id = id;
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
