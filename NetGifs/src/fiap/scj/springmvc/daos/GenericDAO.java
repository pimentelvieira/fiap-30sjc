package fiap.scj.springmvc.daos;

import java.util.List;

import javax.persistence.EntityManager;

import fiap.scj.springmvc.util.JPAUtil;

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
	public void remover(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
		}
	public void atualizar(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}
	public List<T> listar() {
		em = JPAUtil.getEntityManager();
		return em.createQuery("From " +
		classe.getSimpleName() + " alias", classe).getResultList();
	}
	public T buscar(int id) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe,id);
		em.getTransaction().commit();
		em.close();
		return entidade;
	} 
}
