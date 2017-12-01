package br.com.fiap.helper;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import br.com.fiap.entity.Pedido;
import br.com.fiap.util.HibernateUtil;

public class PedidoHelper {

	private Session session;
	
	public PedidoHelper() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	public Session getSession() {
		return session;
	}
	public String salvar(Pedido pedido) {
		try {
			abreTransaction();
			getSession().save(pedido);
			commitaTransaction();
			return pedido.getDescricao() + " salvo com sucesso.";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	public Pedido buscarPorId(int id) {
		abreTransaction();
		TypedQuery<Pedido> query = getSession().createQuery("select p from Pedido p where p.id = :id", Pedido.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	public List<Pedido> listar() {
		abreTransaction();
		TypedQuery<Pedido> query = getSession().createQuery("select p from Pedido p", Pedido.class);
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
