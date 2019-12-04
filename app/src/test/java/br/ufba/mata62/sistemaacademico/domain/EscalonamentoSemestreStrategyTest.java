package br.ufba.mata62.sistemaacademico.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.ufba.mata62.sistemaacademico.repository.LeitorDados;
import br.ufba.mata62.sistemaacademico.service.CadastrarAlunoService;

class EscalonamentoSemestreStrategyTest {

	EscalonamentoSemestreStrategy semestre = new EscalonamentoSemestreStrategy();

	@Test
	void testOrdenar() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Curso curso = Universidade.getCursos().get(112140);

		Aluno aluno1 = new Aluno("José Vítor Coutinho", 1, "2018.1", "123", curso);
		Aluno aluno2 = new Aluno("Pablo Henrique Rego dos Santos Cabral", 2, "2020.2", "123", curso);
		Aluno aluno3 = new Aluno("Lisandra Calmon São Bernardo", 3, "2019.1", "123", curso);
		Aluno aluno4 = new Aluno("Larissa Mattos de Almeida Hora", 4, "2019.1", "123", curso);
		Aluno aluno5 = new Aluno("Luís Fernando Guerra", 5, "2019.2", "123", curso);
		Aluno aluno6 = new Aluno("João Pedro Santana", 6, "2020.1", "123", curso);

		Universidade.insereAluno(1, aluno1);
		Universidade.insereAluno(2, aluno2);
		Universidade.insereAluno(3, aluno3);
		Universidade.insereAluno(4, aluno4);
		Universidade.insereAluno(5, aluno5);
		Universidade.insereAluno(6, aluno6);

		semestre.ordenar(new ArrayList<>(Universidade.getAlunos().values()));
	}
	
	@Test
	void testCoeficienteNull() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Curso curso = Universidade.getCursos().get(112140);

		Aluno aluno1 = new Aluno("José Vítor Coutinho", 1, "2018.1", "123", curso);
		Aluno aluno2 = new Aluno("Pablo Henrique Rego dos Santos Cabral", 2, "2020.2", "123", curso);

		Universidade.insereAluno(1, aluno1);
		Universidade.insereAluno(2, aluno2);

		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(1L), "2018.1");
		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(2L), "2018.1");

		
		Universidade.getAlunos().get(2L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setNota(5.0);

		semestre.ordenar(new ArrayList<>(Universidade.getAlunos().values()));

	}
	
	@Test
	void testCoeficiente2Null() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Curso curso = Universidade.getCursos().get(112140);

		Aluno aluno1 = new Aluno("José Vítor Coutinho", 1, "2018.1", "123", curso);
		Aluno aluno2 = new Aluno("Pablo Henrique Rego dos Santos Cabral", 2, "2020.2", "123", curso);

		Universidade.insereAluno(1, aluno1);
		Universidade.insereAluno(2, aluno2);

		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(1L), "2018.1");
		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(2L), "2018.1");

		
		Universidade.getAlunos().get(1L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setNota(5.0);

		semestre.ordenar(new ArrayList<>(Universidade.getAlunos().values()));

	}
	
	@Test
	void testCoeficienteMaior() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Curso curso = Universidade.getCursos().get(112140);

		Aluno aluno1 = new Aluno("José Vítor Coutinho", 1, "2018.1", "123", curso);
		Aluno aluno2 = new Aluno("Pablo Henrique Rego dos Santos Cabral", 2, "2020.2", "123", curso);

		Universidade.insereAluno(1, aluno1);
		Universidade.insereAluno(2, aluno2);

		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(1L), "2018.1");
		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(2L), "2018.1");

		
		Universidade.getAlunos().get(1L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setNota(5.0);
		Universidade.getAlunos().get(2L).getHistorico().getPeriodosCursados().get(0)
		.getComponentesCurricularesCursados().get(0).setNota(10.0);

		semestre.ordenar(new ArrayList<>(Universidade.getAlunos().values()));

	}
	
	@Test
	void testCoeficienteMenor() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Curso curso = Universidade.getCursos().get(112140);

		Aluno aluno1 = new Aluno("José Vítor Coutinho", 1, "2018.1", "123", curso);
		Aluno aluno2 = new Aluno("Pablo Henrique Rego dos Santos Cabral", 2, "2020.2", "123", curso);

		Universidade.insereAluno(1, aluno1);
		Universidade.insereAluno(2, aluno2);

		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(1L), "2018.1");
		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(2L), "2018.1");

		
		Universidade.getAlunos().get(1L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setNota(10.0);
		Universidade.getAlunos().get(2L).getHistorico().getPeriodosCursados().get(0)
		.getComponentesCurricularesCursados().get(0).setNota(5.0);

		semestre.ordenar(new ArrayList<>(Universidade.getAlunos().values()));

	}
	
	@Test
	void testCoeficienteIgual() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Curso curso = Universidade.getCursos().get(112140);

		Aluno aluno1 = new Aluno("José Vítor Coutinho", 1, "2018.1", "123", curso);
		Aluno aluno2 = new Aluno("Pablo Henrique Rego dos Santos Cabral", 2, "2020.2", "123", curso);

		Universidade.insereAluno(1, aluno1);
		Universidade.insereAluno(2, aluno2);

		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(1L), "2018.1");
		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(2L), "2018.1");

		
		Universidade.getAlunos().get(1L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setNota(5.0);
		Universidade.getAlunos().get(2L).getHistorico().getPeriodosCursados().get(0)
		.getComponentesCurricularesCursados().get(0).setNota(5.0);

		semestre.ordenar(new ArrayList<>(Universidade.getAlunos().values()));

	}

}
