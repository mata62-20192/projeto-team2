package br.ufba.mata62.sistemaacademico;

public class Curso {
	private String nome;
	private Curriculo curriculo;
	
	public Curso(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
