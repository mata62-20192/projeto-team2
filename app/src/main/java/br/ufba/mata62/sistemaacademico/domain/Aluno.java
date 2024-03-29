package br.ufba.mata62.sistemaacademico.domain;

import java.util.List;

public class Aluno {
	private String nome;
	private long matricula;
	private String semestreInicio;
	private String senha;
	private Historico historico;
	private Curso curso;

	public Aluno(String nome, long matricula, String semestreInicio, String senha, Curso curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.semestreInicio = semestreInicio;
		this.senha = senha;
		this.curso = curso;
		historico = new Historico();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getMatricula() {
		return matricula;
	}

	public String getSemestreInicio() {
		return semestreInicio;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Historico getHistorico() {
		return historico;
	}

	public Curso getCurso() {
		Curso c = curso;
		return c;
	}

	public List<ComponenteCurricular> getComponentesCurricularesObrigatorios(int s) {
		return curso.getComponentesCurricularesObrigatorios(s);
	}

	public void insereComponenteCurricularCursado(int s, ComponenteCurricularCursado c) {
		historico.insereComponenteCurricularCursado(s, c);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (matricula ^ (matricula >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
}
