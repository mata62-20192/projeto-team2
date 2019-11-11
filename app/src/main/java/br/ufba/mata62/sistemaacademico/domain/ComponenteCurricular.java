package br.ufba.mata62.sistemaacademico.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ComponenteCurricular {
	private Natureza natureza;
	private Disciplina disciplina;
	private Set<Disciplina> preRequisitos;
	
	public ComponenteCurricular(Disciplina disciplina, Natureza natureza) {
		this.disciplina = disciplina;
		this.natureza = natureza;
		preRequisitos = new HashSet<Disciplina>();
	}
	
	public Natureza getNatureza() {
		return natureza;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Set<Disciplina> getPreRequisitos() {
		return Collections.unmodifiableSet(preRequisitos);
	}
	
	public void inserePreRequisitos(Disciplina disciplina) {
		preRequisitos.add(disciplina);
	}
}
