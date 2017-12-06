package br.com.fiap.dao;

import java.util.List;

public interface DAO<T> {

	public void adicionar(T entity);
	public List<T> listar();
	public T buscar(int id);
}
