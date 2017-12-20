package br.com.fiap.dao;

import javax.persistence.TypedQuery;

import br.com.fiap.entity.Paciente;
import br.com.fiap.util.JPAUtil;

public class PacienteDAO extends GenericDAO<Paciente> {

	public PacienteDAO() {
		super(Paciente.class);
	}
	public Paciente buscar(String cpf) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		String jpql = "select p from Paciente p join fetch p.procedimentos pr join fetch p.materiaisMedicamentos mm where p.cpf = :cpf";
		TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
		query.setParameter("cpf", cpf);
		Paciente result = query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return result;
	}
}
