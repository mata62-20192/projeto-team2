package br.ufba.mata62.sistemaacademico;

public class ComponenteCurricularCursado{

	private ComponenteCurricular componenteCurricular;
	private Double nota;
	private Conceito conceito;
	
	public ComponenteCurricularCursado(ComponenteCurricular componenteCurricular, Double nota, Conceito conceito) {
		this.setComponenteCurricular(componenteCurricular);
		this.nota = nota;
		this.conceito = conceito;
	}
	
	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Conceito getConceito() {
		return conceito;
	}

	public void setConceito(Conceito conceito) {
		this.conceito = conceito;
	}

	public ComponenteCurricular getComponenteCurricular() {
		return componenteCurricular;
	}

	public void setComponenteCurricular(ComponenteCurricular componenteCurricular) {
		this.componenteCurricular = componenteCurricular;
	}	

}
