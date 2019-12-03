package br.ufba.mata62.sistemaacademico.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufba.mata62.sistemaacademico.domain.Aluno;
import br.ufba.mata62.sistemaacademico.domain.Natureza;
import br.ufba.mata62.sistemaacademico.domain.Universidade;
import br.ufba.mata62.sistemaacademico.repository.LeitorDados;

class HistoricoServiceTest {

	@BeforeEach
	void setUp() {
		LeitorDados dados = new LeitorDados("dados.txt");
		dados.lerDados();
		Aluno aluno = new Aluno("Pablo Henrique Rego dos Santos Cabral", 218115563, "2018.1", "123",
				Universidade.getCursos().get(112140));
		Universidade.insereAluno(218115563, aluno);
		CadastrarAlunoService.matricularDisciplinas(Universidade.getAlunos().get(218115563L), "2018.1");
		Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).getComponenteCurricular().setNatureza(Natureza.OPTATIVA);

		Universidade.getAlunos().get(218115563L).getHistorico().getPeriodosCursados().get(0)
				.getComponentesCurricularesCursados().get(0).setNota(5.0);

	}

	@Test
	void testCalcularCargaHorariaOptativas() {

		HistoricoService.calcularCargaHorariaOptativas(Universidade.getAlunos().get(218115563L).getHistorico());

	}

	@Test
	void testCalcularCargaHorariaObrigatorias() {

		HistoricoService.calcularCargaHorariaObrigatorias(Universidade.getAlunos().get(218115563L).getHistorico());
	}

	@Test
	void testCalcularCoeficienteRendimento() {

		HistoricoService.calcularCoeficienteRendimento(Universidade.getAlunos().get(218115563L).getHistorico());
	}

}
