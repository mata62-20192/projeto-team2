package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Curso {
	private String nome;
	private ArrayList<ComponenteCurricularObrigatorio> componentesObrigatorios;
	private ArrayList<ComponenteCurricularOptativo> componentesOptativos;
	private Set<Aluno> alunos;
	
	public Curso(String nome) {
		this.nome = nome;
		componentesObrigatorios = new ArrayList<ComponenteCurricularObrigatorio>();
		componentesOptativos = new ArrayList<ComponenteCurricularOptativo>();
		alunos = new HashSet<Aluno>();
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

	public void insereComponenteObrigatorio(ComponenteCurricularObrigatorio componenteObrigatorio) {
		componentesObrigatorios.add(componenteObrigatorio);
	}
	
	public ArrayList<ComponenteCurricularOptativo> getComponentesOptativos() {
		return componentesOptativos;
	}

	public void setComponentesOptativos(ArrayList<ComponenteCurricularOptativo> componentesOptativos) {
		this.componentesOptativos = componentesOptativos;
	}
	
	public void insereComponenteOptativo(ComponenteCurricularOptativo componenteOptativo) {
		componentesOptativos.add(componenteOptativo);
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void insereAlunos(Aluno aluno) {
		alunos.add(aluno);
	}
}
