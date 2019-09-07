package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;

public class Universidade {
	private String nome;
	private String sigla;
	private ArrayList<Curso> cursos;
	private ArrayList<Disciplina> disciplinas;

	public Universidade(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		cursos = new ArrayList<Curso>();
		disciplinas = new ArrayList<Disciplina>();
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

	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void insereCurso(Curso curso){
		cursos.add(curso);
	}
	
	public void insereDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
}