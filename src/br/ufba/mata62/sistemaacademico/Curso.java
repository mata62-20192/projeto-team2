package br.ufba.mata62.sistemaacademico;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Curso {
	private String nome;
	private Set<Aluno> alunos;
	
	public Curso(String nome) {
		this.nome = nome;
		alunos = new HashSet<Aluno>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Aluno> getAlunos(){
		return Collections.unmodifiableSet(alunos);
	}
	
	public void insereAluno(Aluno aluno) {
		alunos.add(aluno);
	}
}
