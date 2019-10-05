package br.ufba.mata62.sistemaacademico;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ComponenteCurricular {
	protected Disciplina disciplina;
	protected Set<Disciplina> preRequisitos;
	
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
		return Collections.unmodifiableSet(preRequisitos);
	}

	public void inserePreRequisito(Disciplina disciplina){
		preRequisitos.add(disciplina); 
	}
}