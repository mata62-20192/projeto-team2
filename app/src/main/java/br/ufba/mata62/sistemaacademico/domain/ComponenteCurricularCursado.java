package br.ufba.mata62.sistemaacademico.domain;

public class ComponenteCurricularCursado{
	private Conceito conceito;
	private Double nota;
	private ComponenteCurricular componenteCurricular;
	
	public ComponenteCurricularCursado(ComponenteCurricular componenteCurricular) {
		this.componenteCurricular = componenteCurricular;
		nota = null;
		conceito = null;
	}
	
	public Conceito getConceito() {
		return conceito;
	}

	public void setConceito(Conceito conceito) {
		this.conceito = conceito;
	}
	
	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
        this.nota = nota;
	}

	public ComponenteCurricular getComponenteCurricular() {
		return componenteCurricular;
	}	
}