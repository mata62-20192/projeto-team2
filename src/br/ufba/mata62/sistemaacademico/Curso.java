package br.ufba.mata62.sistemaacademico;

import java.util.Set;

public class Curso {
	
	private String nome;
	
	private Set<Aluno> Alunos;
	
	public Curso(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Aluno> getAlunos() {
		return Alunos;
	}

	public void insereAluno(Aluno aluno) {
		Alunos.add(aluno);
	}	
}
