package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Periodo {
	private int numero;
	private List<ComponenteCurricular> componentesCurricularesObrigatorios;
	
	public Periodo(int numero) {
		this.numero = numero;
		componentesCurricularesObrigatorios = new ArrayList<ComponenteCurricular>();
	}
		
	public void inserePeriodo(ComponenteCurricular componenteCurricular) {
		componentesCurricularesObrigatorios.add(componenteCurricular);
	}

	public List<ComponenteCurricular> getComponentesCurricularesObrigatorios() {
		return Collections.unmodifiableList(componentesCurricularesObrigatorios);
	}

	public int getNumero() {
		return numero;
	}

}
