package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Historico {
	private List<PeriodoCursado> periodosCursados;
	
	public Historico() {
		periodosCursados = new ArrayList<PeriodoCursado>();
	}

	public List<PeriodoCursado> getPeriodosCursados() {
		return Collections.unmodifiableList(periodosCursados);
	}
	
	public void inserePeriodoCursado(PeriodoCursado p) {
		periodosCursados.add(p);
	}
	
	private void imprimirTXT() {
		
	}
	
	private void imprimirHTML() {
		
	}
	
	private int calcularCargaHorariaOptativas() {
		return 1;
	}
	
	private int calcularCargaHorariaObrigatorias() {
		return 1;
	}
	
	private Double calcularCoeficienteRendimento() {
		//TODO
		return null;
	}
}
