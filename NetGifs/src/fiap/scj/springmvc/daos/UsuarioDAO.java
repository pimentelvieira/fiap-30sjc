package fiap.scj.springmvc.daos;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import fiap.scj.springmvc.beans.Usuario;
import fiap.scj.springmvc.util.JPAUtil;

public class UsuarioDAO extends GenericDAO<Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}
	public Usuario buscar(String login, String senha) {
		try {
			em = JPAUtil.getEntityManager();
			String jpql = "select u from Usuario u where u.login = :login and u.senha = :senha";
			TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
