package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="agenda")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDAGENDA")
	private int id;
	
	@Column(name="DATA")
	private LocalDate data;
	
	@Column(name="HORA")
	private LocalTime hora;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "agenda_paciente",
		joinColumns = @JoinColumn(name = "IDAGENDA"), inverseJoinColumns = @JoinColumn(name = "IDPACIENTE"))
	private Set<Paciente> pacientes = new HashSet<>();
	
	public void addPaciente(Paciente paciente) {
        pacientes.add(paciente);
        paciente.getAgendas().add(this);
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Set<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
}
