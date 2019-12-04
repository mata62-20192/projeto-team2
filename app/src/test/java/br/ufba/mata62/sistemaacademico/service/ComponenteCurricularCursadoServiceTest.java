package br.ufba.mata62.sistemaacademico.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufba.mata62.sistemaacademico.domain.Aluno;
import br.ufba.mata62.sistemaacademico.domain.Conceito;
import br.ufba.mata62.sistemaacademico.domain.Universidade;
import br.ufba.mata62.sistemaacademico.repository.LeitorDados;

class ComponenteCurricularCursadoServiceTest {

	ComponenteCurricularCursadoService componente = new ComponenteCurricularCursadoService();

	@BeforeEach
	void setUp() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Aluno aluno = new Aluno("Pablo Henrique Rego dos Santos Cabral", 218115563, "2018.1", "123",
				Universidade.getCursos().get(112140));
		Universidade.insereAluno(218115563, aluno);
		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(218115563L), "2018.1");

	}

	@Test
	void testSetNota() {
		Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setConceito(Conceito.APROVADO);
		componente.setNota(Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0), 5.0);
	}

	@Test
	void testReprovadoPorNota() {

		Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setConceito(Conceito.REPROVADO_POR_NOTA);

		componente.setNota(Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0), 4.0);

	}

	@Test
	void testDispensa() {

		Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setConceito(Conceito.DISPENSA);

		componente.setNota(Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0), 0.0);

	}

	@Test
	void testTrancamento() {

		Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setConceito(Conceito.TRANCAMENTO);

		componente.setNota(Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0), 0.0);

	}

}
