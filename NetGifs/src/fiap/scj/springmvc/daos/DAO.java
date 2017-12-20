package fiap.scj.springmvc.daos;

import java.util.List;

public interface DAO<T> {

	public void adicionar(T entity);
	public void atualizar(T entity);
	public void remover(T entity);
	public List<T> listar();
	public T buscar(int id);
}
