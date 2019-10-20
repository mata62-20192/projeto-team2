package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeriodoCursado {
	private String periodo;
	private List<ComponenteCurricularCursado> componentesCurricularesCursados;
	
	public PeriodoCursado(String periodo){
		this.periodo = periodo;
		componentesCurricularesCursados = new ArrayList<ComponenteCurricularCursado>();
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public List<ComponenteCurricularCursado> getComponentesCurricularesCursados() {
		return Collections.unmodifiableList(componentesCurricularesCursados);
	}
	
	public void insereComponenteCurricularCursado(ComponenteCurricularCursado c) {
		componentesCurricularesCursados.add(c);
	}
}