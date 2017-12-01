package br.com.fiap.helper;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import br.com.fiap.entity.Cliente;
import br.com.fiap.util.HibernateUtil;

public class ClienteHelper {

	private Session session;
	
	public ClienteHelper() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	public Session getSession() {
		return session;
	}
	public String salvar(Cliente cliente) {
		try {
			abreTransaction();
			getSession().save(cliente);
			commitaTransaction();
			return cliente.getNome() + " salvo com sucesso.";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	public Cliente buscarPorId(int id) {
		abreTransaction();;
		TypedQuery<Cliente> query = getSession().createQuery("select c from Cliente c where c.id = :id", Cliente.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	public List<Cliente> listar() {
		abreTransaction();
		TypedQuery<Cliente> query = getSession().createQuery("select c from Cliente c", Cliente.class);
		return query.getResultList();
	}
	public void abreTransaction() {
		if (!getSession().getTransaction().isActive()) {
			getSession().beginTransaction();
		}
	}
	public void commitaTransaction() {
		getSession().getTransaction().commit();
	}
}
