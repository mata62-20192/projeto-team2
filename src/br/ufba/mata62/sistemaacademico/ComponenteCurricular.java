package br.ufba.mata62.sistemaacademico;

import java.util.HashSet;
import java.util.Set;

public class ComponenteCurricular {
	
	Disciplina disciplina;
	Set<Disciplina> preRequisitos;
	
	public ComponenteCurricular(Disciplina disciplina) {
		this.disciplina = disciplina;
		preRequisitos = new HashSet<Disciplina>();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Set<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(Set<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	
	public void inserePreRequisitos(Disciplina d) {
		this.preRequisitos.add(d);
	}
	
	
}
