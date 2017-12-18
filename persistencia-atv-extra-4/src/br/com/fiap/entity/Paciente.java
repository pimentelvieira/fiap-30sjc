package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DATANASC")
	private LocalDate dataNasc;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<Procedimento> procedimentos = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<MaterialMedicamento> materiaisMedicamentos = new HashSet<>();
	
	@ManyToMany(mappedBy = "pacientes")
	private Set<Agenda> agendas = new HashSet<>();
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}
	public Set<MaterialMedicamento> getMateriaisMedicamentos() {
		return materiaisMedicamentos;
	}
	public void setMateriaisMedicamentos(Set<MaterialMedicamento> materiaisMedicamentos) {
		this.materiaisMedicamentos = materiaisMedicamentos;
	}
	public Set<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(Set<Agenda> agendas) {
		this.agendas = agendas;
	}
}
