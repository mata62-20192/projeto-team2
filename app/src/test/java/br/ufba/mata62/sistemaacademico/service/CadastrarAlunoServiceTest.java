package br.ufba.mata62.sistemaacademico.service;

import org.junit.jupiter.api.Test;

import br.ufba.mata62.sistemaacademico.domain.Aluno;
import br.ufba.mata62.sistemaacademico.domain.Universidade;
import br.ufba.mata62.sistemaacademico.repository.LeitorDados;

class CadastrarAlunoServiceTest {

	@Test
	public void testMatricularDisciplinas() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Aluno aluno = new Aluno("Pablo Henrique Rego dos Santos Cabral", 218115563, "2018.1", "123",
				Universidade.getCursos().get(112140));
		Universidade.insereAluno(218115563, aluno);

		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(218115563L), "2018.1");

	}

}
