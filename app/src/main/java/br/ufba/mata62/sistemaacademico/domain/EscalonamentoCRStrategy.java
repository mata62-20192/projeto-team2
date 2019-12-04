package br.ufba.mata62.sistemaacademico.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import br.ufba.mata62.sistemaacademico.service.HistoricoService;

public class EscalonamentoCRStrategy implements EscalonamentoStrategy {

	@Override
	public void ordenar(ArrayList<Aluno> alunos) {

		Collections.sort(alunos, new Comparator<Aluno>() {
			@Override
			public int compare(Aluno aluno1, Aluno aluno2) {
				Double coeficiente1 = HistoricoService.calcularCoeficienteRendimento(aluno1.getHistorico());
				Double coeficiente2 = HistoricoService.calcularCoeficienteRendimento(aluno2.getHistorico());

				return compararCoeficiente(coeficiente1, coeficiente2, aluno1, aluno2);
			}
		});
	}

	private int compararCoeficiente(Double coeficiente1, Double coeficiente2, Aluno aluno1, Aluno aluno2) {
		if (coeficiente1 == null && coeficiente2 == null) {
			return compararSemestre(aluno1, aluno2);
		} else if (coeficiente1 == null) {
			return 1;
		} else if (coeficiente2 == null) {
			return -1;
		} else {
			if (coeficiente1 > coeficiente2) {
				return -1;
			} else if (coeficiente1 < coeficiente2) {
				return 1;
			} else {
				return compararSemestre(aluno1, aluno2);
			}
		}
	}

	private int compararSemestre(Aluno aluno1, Aluno aluno2) {
		String semestreInicio1 = aluno1.getSemestreInicio();
		String semestreInicio2 = aluno2.getSemestreInicio();

		int compare = semestreInicio1.compareTo(semestreInicio2);

		if (compare < 0) {
			return -1;
		} else if (compare > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
