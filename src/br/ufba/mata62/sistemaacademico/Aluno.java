package br.ufba.mata62.sistemaacademico;

public class Aluno {
	private String nome;
	private long matricula;
	private String senha;
	private Historico historico;
	private Curso curso;
	
	public Aluno(String nome, long matricula, String senha, Curso curso) {
		this.nome = nome;
		this.matricula = matricula;
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
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Historico getHistorico() {
		return historico;
	}
	
	public Curso getCurso() {
		return curso;
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