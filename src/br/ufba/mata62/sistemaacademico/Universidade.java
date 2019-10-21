package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		alunos = new HashSet<Aluno>();
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
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public void insereCurso(Curso c){
		cursos.add(c);
	}
	
	public void insereDisciplina(Disciplina d) {
		disciplinas.add(d);
	}

	public void insereAluno(Aluno a) {
		alunos.add(a);
	}
}