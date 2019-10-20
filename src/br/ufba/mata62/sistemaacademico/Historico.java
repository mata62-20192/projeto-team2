package br.ufba.mata62.sistemaacademico;

public class Historico {
	
	private Aluno aluno;
	private PeriodoCursado periodo;
	public Historico(Aluno aluno) {
		super();
		this.aluno = aluno;
	}
	
	private void imprimirTXT() {
		
	}
	private void imprimirHTML() {
		
	}
	private Integer calcularCargaHorariaOptativa() {
		
	}
	private Integer calcularCargaHorariaObrigatoria() {
		
	}
	private Double calcularCoeficienteRendimento() {
		
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public PeriodoCursado getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoCursado periodo) {
		this.periodo = periodo;
	}
}
