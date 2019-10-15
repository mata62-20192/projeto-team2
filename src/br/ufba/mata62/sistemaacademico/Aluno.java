package br.ufba.mata62.sistemaacademico;

public class Aluno {

	private String nome;
	
	private Long numeroMatricula;
	
	private String senha;
	
	private Universidade universidade;
	
	private Curso curso;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getNumeroMatricula() {
		return numeroMatricula;
	}
	public void setNumeroMatricula(Long numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Universidade getUniversidade() {
		return universidade;
	}
	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroMatricula == null) ? 0 : numeroMatricula.hashCode());
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
		if (numeroMatricula == null) {
			if (other.numeroMatricula != null)
				return false;
		} else if (!numeroMatricula.equals(other.numeroMatricula))
			return false;
		return true;
	}
	
}
