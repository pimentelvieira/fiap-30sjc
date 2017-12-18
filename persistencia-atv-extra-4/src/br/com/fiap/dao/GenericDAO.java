package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.util.JPAUtil;

public class GenericDAO<T> implements DAO<T> {

	private final Class<T> classe;
	protected EntityManager em;
	
	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}
	public void adicionar(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}
	public List<T> listar() {
		em = JPAUtil.getEntityManager();
		return em.createQuery("From " +
		classe.getSimpleName() + " alias", classe).getResultList();
	}
	public T buscar(int chave) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, chave);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}
	public T buscar(String chave) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, chave);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}
}
