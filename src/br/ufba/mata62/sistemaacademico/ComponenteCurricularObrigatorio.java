package br.ufba.mata62.sistemaacademico;

public class ComponenteCurricularObrigatorio extends ComponenteCurricular {
	private int semestre;
	
	public ComponenteCurricularObrigatorio(Disciplina disciplina, 
			int semestre) {
		super(disciplina);
		this.semestre = semestre;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
}
