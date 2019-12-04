package br.ufba.mata62.sistemaacademico.service;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import br.ufba.mata62.sistemaacademico.domain.Aluno;
import br.ufba.mata62.sistemaacademico.domain.Universidade;
import br.ufba.mata62.sistemaacademico.repository.LeitorDados;

class UniversidadeServiceTest {
	
	UniversidadeService universidadeService = new UniversidadeService();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	void testInsereAluno() throws Exception {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Aluno aluno = new Aluno("Miguel", 123456, "2018.1", "123", Universidade.getCursos().get(112140));

		universidadeService.insereAluno(123456, aluno);
	}

	@Test
	void deveRetornarExceptionQuandoAlunoJaEstaCadastrado() {
		try {
			thrown.expect(Exception.class);
			thrown.expectMessage("Aluno já cadastrado.");
			LeitorDados dados = new LeitorDados("dados.txt");
			dados.lerDados();
			Aluno aluno = new Aluno("Pablo Henrique Rego dos Santos Cabral", 218115563, "2018.1", "123",
					Universidade.getCursos().get(112140));
			Universidade.insereAluno(218115563L, aluno);

			universidadeService.insereAluno(218115563, Universidade.getAlunos().get(218115563L));
		} catch (Exception e) {

		}

	}

}
