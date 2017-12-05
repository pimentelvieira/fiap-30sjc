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
	public void adicionar(T entity) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}
	public List<T> listar() {
		em = JPAUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName() + " alias", classe).getResultList();
	}
	public void atualizar(T entity) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}
	public void remover(T entity) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
		em.close();
	}
	public T buscar(int id) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		T entity = em.find(classe, id);
		em.getTransaction().commit();
		em.close();
		return entity;
	}
}
