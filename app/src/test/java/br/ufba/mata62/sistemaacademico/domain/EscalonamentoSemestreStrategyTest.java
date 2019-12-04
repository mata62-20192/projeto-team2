package br.ufba.mata62.sistemaacademico.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.ufba.mata62.sistemaacademico.repository.LeitorDados;

class EscalonamentoSemestreStrategyTest {

	EscalonamentoSemestreStrategy semestre = new EscalonamentoSemestreStrategy();

	@Before
	void setUp() {
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

	}

	@Test
	void testOrdenar() {

		semestre.ordenar(new ArrayList<Aluno>(Universidade.getAlunos().values()));
	}

}
