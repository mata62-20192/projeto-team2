package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Universidade {
	private String nome;
	private String sigla;
	private List<Curso> cursos;
	private Map<String, Disciplina> disciplinas;
	private Map<Long, Aluno> alunos;

	public Universidade(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		cursos = new ArrayList<Curso>();
		disciplinas = new Hashtable<String, Disciplina>();
		alunos = new Hashtable<Long, Aluno>();
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
	
	public Map<String, Disciplina> getDisciplinas() {
		return Collections.unmodifiableMap(disciplinas);
	}

	public Map<Long, Aluno> getAlunos() {
		return Collections.unmodifiableMap(alunos);
	}

	public void insereCurso(Curso c){
		cursos.add(c);
	}
	
	public void insereDisciplina(String c, Disciplina d) {
		disciplinas.put(c, d);
	}

	public void insereAluno(long m, Aluno a) {
		alunos.put(m, a);
	}
}