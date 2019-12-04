package br.ufba.mata62.sistemaacademico.service;

import br.ufba.mata62.sistemaacademico.domain.ComponenteCurricularCursado;
import br.ufba.mata62.sistemaacademico.domain.Conceito;

public class ComponenteCurricularCursadoService {
	public static void setNota(ComponenteCurricularCursado ccc, Double nota) {
		if (ccc.getConceito() != Conceito.DISPENSA || ccc.getConceito() != Conceito.TRANCAMENTO) {
			ccc.setNota(nota);

			if (nota >= 5.0) {
				ccc.setConceito(Conceito.APROVADO);
			} else {
				ccc.setConceito(Conceito.REPROVADO_POR_NOTA);
			}
		}
	}
}
