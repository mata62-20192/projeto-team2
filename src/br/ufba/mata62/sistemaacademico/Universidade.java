package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Universidade {
	private String nome;
	private String sigla;
	private List<Curso> cursos;
	private Set<Disciplina> disciplinas;
	private Set<Aluno> alunos;

	public Universidade(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		cursos = new ArrayList<Curso>();
		disciplinas = new HashSet<Disciplina>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Curso> getCursos() {
		return Collections.unmodifiableList(cursos);
	}

	public Set<Disciplina> getDisciplinas() {
		return Collections.unmodifiableSet(disciplinas);
	}
	
	public void insereCurso(Curso curso){
		cursos.add(curso);
	}
	
	public void insereDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void insereAluno(Aluno aluno) {
		alunos.add(aluno);
	}
}