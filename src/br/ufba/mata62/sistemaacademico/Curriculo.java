package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curriculo {
	private int numeroSemestres;
	private List<ComponenteCurricular> componentesCurricularesOptativos;
	private List<Periodo> periodos;
	
	public Curriculo(int numeroSemestres) { 
		this.numeroSemestres = numeroSemestres;
		componentesCurricularesOptativos = new ArrayList<ComponenteCurricular>();
		
		for(int i=1; i<=numeroSemestres; i++) {
			periodos = new ArrayList<Periodo>(i);		
		}
	}

	/*TODO: cargaHorariaOptativa, cargaHorariaObrigatoria, imprimir */
	
	public void adicionarComponenteOptativo(Disciplina disciplina) {
		componentesCurricularesOptativos.add(new ComponenteCurricular(disciplina));
	}
	
	public void adicionarComponenteObrigatorio(Disciplina disciplina, int semestre) {
		ComponenteCurricular componenteCurricular = new ComponenteCurricular(disciplina);
		periodos.get(semestre).inserePeriodo(componenteCurricular);
	}

	public int getNumeroSemestres() {
		return numeroSemestres;
	}
	
	public List<ComponenteCurricular> getComponentesCurricularesOptativos() {
		return Collections.unmodifiableList(componentesCurricularesOptativos);
	}

	public List<Periodo> getPeriodos() {
		return Collections.unmodifiableList(periodos);
	}
	
}
