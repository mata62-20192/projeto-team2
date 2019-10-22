package br.ufba.mata62.sistemaacademico;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Curso {
	private String nome;
	private Curriculo curriculo;
	private Set<Aluno> alunos;
	
	public Curso(String nome, Curriculo curriculo) {
		this.nome = nome;
		this.curriculo = curriculo;
		alunos = new HashSet<Aluno>();
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Curriculo getCurriculo() {
		Curriculo c = curriculo;
		return c;
	}
	
	public Set<Aluno> getAlunos(){
		return Collections.unmodifiableSet(alunos);
	}
	
	public void insereAluno(Aluno aluno) {
		alunos.add(aluno);
	}
}
