package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;

public class ComponenteCurricular {
	Disciplina disciplina;
	ArrayList<Disciplina> preRequisitos;
	
	public ComponenteCurricular(Disciplina disciplina) {
		this.disciplina = disciplina;
		preRequisitos = new ArrayList<Disciplina>();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public ArrayList<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(ArrayList<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	
	public void inserePreRequisito(Disciplina disciplina){
		preRequisitos.add(disciplina); 
	}
}
