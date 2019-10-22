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
	
	public void imprimir() {
		System.out.println("Disciplinas Obrigatórias");
		for(Periodo periodo : periodos) {
			System.out.println("Semestre: " + periodo.getNumero());
			for(ComponenteCurricular componente : periodo.getComponentesCurricularesObrigatorios()) {
				System.out.println("	Código: " + componente.getDisciplina().getCodigo());
				System.out.println("	Disciplina: " + componente.getDisciplina().getNome());
				System.out.println("	Carga Horária: " + componente.getDisciplina().getCargaHoraria());
			}
		}
		System.out.println("Disciplinas Optativas");
		for(ComponenteCurricular componente : componentesCurricularesOptativos) {
			System.out.println("	Código: " + componente.getDisciplina().getCodigo());
			System.out.println("	Disciplina: " + componente.getDisciplina().getNome());
			System.out.println("	Carga Horária: " + componente.getDisciplina().getCargaHoraria());
		}
	} 
	
	public void adicionarComponenteOptativo(Disciplina disciplina) {
		ComponenteCurricular c = new ComponenteCurricular(disciplina, Natureza.OPTATIVA);
		componentesCurricularesOptativos.add(c);
	}
	
	public void adicionarComponenteObrigatorio(Disciplina disciplina, int semestre) {
		ComponenteCurricular c = new ComponenteCurricular(disciplina, Natureza.OBRIGATORIA);
		periodos.get(semestre).inserePeriodo(c);
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
