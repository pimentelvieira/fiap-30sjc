package br.com.fiap.app;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MaterialMedicamento;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("----> Início Processamento <----");
		GenericDAO<Agenda> agendaDAO = new GenericDAO<>(Agenda.class);
		GenericDAO<Paciente> pacienteDAO = new PacienteDAO();
		
		Paciente paciente1 = new Paciente();
		paciente1.setCpf("52656478945");
		paciente1.setDataNasc(LocalDate.of(1991, 11, 20));
		paciente1.setNome("José");
		paciente1.setTelefone("56235641");
		
		Paciente paciente2 = new Paciente();
		paciente2.setCpf("11125469845");
		paciente2.setDataNasc(LocalDate.of(1990, 3, 12));
		paciente2.setNome("Lucas");
		paciente2.setTelefone("11125465");
		
		Procedimento procedimento1 = new Procedimento();
		procedimento1.setDescricao("Limpeza");
		procedimento1.setPreco(200);
		procedimento1.setPaciente(paciente1);
		paciente1.getProcedimentos().add(procedimento1);
		
		Procedimento procedimento2 = new Procedimento();
		procedimento2.setDescricao("Canal");
		procedimento2.setPreco(400);
		procedimento2.setPaciente(paciente1);
		paciente1.getProcedimentos().add(procedimento2);
		
		MaterialMedicamento matmed1 = new MaterialMedicamento();
		matmed1.setDescricao("Anestesia");
		matmed1.setFabricante("Alvorada Anestesias");
		matmed1.setPreco(100);
		matmed1.setPaciente(paciente1);
		paciente1.getMateriaisMedicamentos().add(matmed1);
		
		MaterialMedicamento matmed2 = new MaterialMedicamento();
		matmed2.setDescricao("Fluor");
		matmed2.setFabricante("Fluor Mais");
		matmed2.setPreco(50);
		matmed2.setPaciente(paciente1);
		paciente1.getMateriaisMedicamentos().add(matmed2);
		
		Procedimento procedimento3 = new Procedimento();
		procedimento3.setDescricao("Limpeza");
		procedimento3.setPreco(200);
		procedimento3.setPaciente(paciente2);
		paciente2.getProcedimentos().add(procedimento3);
		
		Procedimento procedimento4 = new Procedimento();
		procedimento4.setDescricao("Extração");
		procedimento4.setPreco(400);
		procedimento4.setPaciente(paciente2);
		paciente2.getProcedimentos().add(procedimento4);
		
		MaterialMedicamento matmed3 = new MaterialMedicamento();
		matmed3.setDescricao("Anestesia");
		matmed3.setFabricante("Alvorada Anestesias");
		matmed3.setPreco(100);
		matmed3.setPaciente(paciente2);
		paciente2.getMateriaisMedicamentos().add(matmed3);
		
		Agenda agenda = new Agenda();
		agenda.setData(LocalDate.now());
		agenda.setDescricao("Agenda Fim de Ano");
		agenda.setHora(LocalTime.now());
		agenda.addPaciente(paciente1);
		agenda.addPaciente(paciente2);
		agendaDAO.adicionar(agenda);
		System.out.println("----> Dados inseridos com sucesso! <----");
		
		System.out.println("----> Busca paciente \"52656478945\" <----");
		Paciente pacienteConsultado = pacienteDAO.buscar("52656478945");
		System.out.println("Nome: " + pacienteConsultado.getNome());
		System.out.println("----> Procedimentos <----");
		pacienteConsultado.getProcedimentos().forEach(p -> System.out.println(p.getDescricao()));
		System.out.println("----> Materiais \\ Medicamentos <----");
		pacienteConsultado.getMateriaisMedicamentos().forEach(mm -> System.out.println(mm.getDescricao()));
	}
}
