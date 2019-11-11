package br.ufba.mata62.sistemaacademico.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.security.auth.Subject;

public class Universidade {
	private static String nome;
	private static String sigla;
	private static Map<Integer, Curso> cursos = new Hashtable<>();
	private static Map<String, Disciplina> disciplinas = new Hashtable<>();
	private static Map<Long, Aluno> alunos = new Hashtable<>();

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Universidade.nome = nome;
	}

	public static String getSigla() {
		return sigla;
	}

	public static void setSigla(String sigla) {
		Universidade.sigla = sigla;
	}

	public static Map<Integer, Curso> getCursos() {
		return Collections.unmodifiableMap(cursos);
	}
	
	public static Map<String, Disciplina> getDisciplinas() {
		return Collections.unmodifiableMap(disciplinas);
	}

	public static Map<Long, Aluno> getAlunos() {
		return Collections.unmodifiableMap(alunos);
	}

	public static void insereCurso(Integer codigoCurso, Curso curso){
		cursos.put(codigoCurso, curso);
	}
	
	public static void insereDisciplina(String c, Disciplina d) {
		disciplinas.put(c, d);
	}

	public static void insereAluno(long m, Aluno a) {

		alunos.put(m, a);

		Curso curso = cursos.get(a.getCurso().getCodigo());
		curso.insereAluno(m, a);
	}
}