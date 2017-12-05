package br.com.fiap.dao;

import java.util.List;

public interface DAO<T> {

	public void adicionar(T entity);
	public List<T> listar();
	public void atualizar(T entity);
	public void remover(T entity);
	public T buscar(int id);
}
