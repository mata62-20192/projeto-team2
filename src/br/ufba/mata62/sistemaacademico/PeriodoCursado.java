package br.ufba.mata62.sistemaacademico;

import java.util.List;

public class PeriodoCursado {

	private String periodo;
	
	private List<ComponenteCurricularCursado> componentesCurricularesCursados;

	public List<ComponenteCurricularCursado> getComponentesCurricularesCursados() {
		return componentesCurricularesCursados;
	}

	public void setComponentesCurricularesCursados(List<ComponenteCurricularCursado> componentesCurricularesCursados) {
		this.componentesCurricularesCursados = componentesCurricularesCursados;
	}
	
	public void insereComponentesCurricularesCursados(ComponenteCurricularCursado c) {
		this.componentesCurricularesCursados.add(c);
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}
