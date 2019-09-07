package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;

public class Curso {
	private String nome;
	private ArrayList<ComponenteCurricularObrigatorio> componentesObrigatorios;
	private ArrayList<ComponenteCurricularOptativo> componentesOptativos;
	
	public Curso(String nome) {
		this.nome = nome;
		componentesObrigatorios = new ArrayList<ComponenteCurricularObrigatorio>();
		componentesOptativos = new ArrayList<ComponenteCurricularOptativo>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<ComponenteCurricularObrigatorio> getComponentesObrigatorios() {
		return componentesObrigatorios;
	}

	public void setComponentesObrigatorios(ArrayList<ComponenteCurricularObrigatorio> componentesObrigatorios) {
		this.componentesObrigatorios = componentesObrigatorios;
	}

	public ArrayList<ComponenteCurricularOptativo> getComponentesOptativos() {
		return componentesOptativos;
	}

	public void setComponentesOptativos(ArrayList<ComponenteCurricularOptativo> componentesOptativos) {
		this.componentesOptativos = componentesOptativos;
	}
	
	public void insereComponenteObrigatorio(ComponenteCurricularObrigatorio componenteObrigatorio) {
		componentesObrigatorios.add(componenteObrigatorio);
	}
	
	public void insereComponenteOptativo(ComponenteCurricularOptativo componenteOptativo) {
		componentesOptativos.add(componenteOptativo);
	}
}
