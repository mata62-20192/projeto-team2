package br.ufba.mata62.sistemaacademico.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Historico {
	private List<PeriodoCursado> periodosCursados;

	public Historico() {
		periodosCursados = new ArrayList<>();
	}

	public List<PeriodoCursado> getPeriodosCursados() {
		return Collections.unmodifiableList(periodosCursados);
	}

	public void inserePeriodoCursado(PeriodoCursado p) {
		periodosCursados.add(p);
	}

	public void insereComponenteCurricularCursado(int s, ComponenteCurricularCursado c) {
		periodosCursados.get(s - 1).insereComponenteCurricularCursado(c);
	}

}
