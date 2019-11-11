package br.ufba.mata62.sistemaacademico.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Curso {
	private String nome;
	private int codigo;
	private Curriculo curriculo;
	private Map<Long, Aluno> alunos;
	
	public Curso(String nome, int codigo, Curriculo curriculo) {
		this.nome = nome;
		this.codigo = codigo;
		this.curriculo = curriculo;
		alunos = new Hashtable<Long, Aluno>();
		
	}
	
	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public Curriculo getCurriculo() {
		Curriculo c = curriculo;
		return c;
	}
	
	public Map<Long, Aluno> getAlunos(){
		return Collections.unmodifiableMap(alunos);
	}
	
	public void insereAluno(long matricula, Aluno aluno) {
		alunos.put(matricula, aluno);
	}
	
	public List<ComponenteCurricular> getComponentesCurricularesObrigatorios(int s){
		return curriculo.getComponentesCurricularesObrigatorios(s);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Curso other = (Curso) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}
