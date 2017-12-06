package br.com.fiap.app;

import javax.swing.JOptionPane;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Escola;
import br.com.fiap.entity.Turma;

public class Main {

	public static void main(String[] args) {
		
		String nomeEscola = JOptionPane.showInputDialog("Digite o nome da escola:");
		Escola escola = new Escola();
		escola.setNome(nomeEscola);

		Turma turma1 = new Turma();
		String nomeTurma1 = JOptionPane.showInputDialog("Digite o nome da primeira turma:");
		turma1.setNome(nomeTurma1);
		int mesesDuracaoTurma1 = Integer.parseInt(JOptionPane.showInputDialog("Digite os meses de duração da primeira turma:"));
		turma1.setMesesDuracao(mesesDuracaoTurma1);
		turma1.setEscola(escola);
		
		Turma turma2 = new Turma();
		String nomeTurma2 = JOptionPane.showInputDialog("Digite o nome da segunda turma:");
		turma2.setNome(nomeTurma2);
		int mesesDuracaoTurma2 = Integer.parseInt(JOptionPane.showInputDialog("Digite os meses de duração da segunda turma:"));
		turma2.setMesesDuracao(mesesDuracaoTurma2);
		turma2.setEscola(escola);
		
		escola.getTurmas().add(turma1);
		escola.getTurmas().add(turma2);
		
		Aluno aluno1 = new Aluno();
		String nomeAluno1 = JOptionPane.showInputDialog("Digite o nome do aluno da primeira turma:");
		aluno1.setNome(nomeAluno1);
		int idadeAluno1 = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno da primeira turma:"));
		aluno1.setIdade(idadeAluno1);
		String rgAluno1 = JOptionPane.showInputDialog("Digite o rg do aluno da primeira turma:");
		aluno1.setRg(rgAluno1);
		String cpfAluno1 = JOptionPane.showInputDialog("Digite o cpf do aluno da primeira turma:");
		aluno1.setCpf(cpfAluno1);
		aluno1.setTurma(turma1);
		
		Aluno aluno2 = new Aluno();
		String nomeAluno2 = JOptionPane.showInputDialog("Digite o nome do aluno da segunda turma:");
		aluno2.setNome(nomeAluno2);
		int idadeAluno2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno da segunda turma:"));
		aluno2.setIdade(idadeAluno2);
		String rgAluno2 = JOptionPane.showInputDialog("Digite o rg do aluno da segunda turma:");
		aluno2.setRg(rgAluno2);
		String cpfAluno2 = JOptionPane.showInputDialog("Digite o cpf do aluno da segunda turma:");
		aluno2.setCpf(cpfAluno2);
		aluno2.setTurma(turma2);
		
		turma1.getAlunos().add(aluno1);
		turma2.getAlunos().add(aluno2);
		
		GenericDAO<Escola> escolaDAO = new GenericDAO<>(Escola.class);
		escolaDAO.adicionar(escola);
		
		JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
	}
}
