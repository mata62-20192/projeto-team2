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
		
	public void insereComponenteCurricular(ComponenteCurricular componenteCurricular) {
		componentesCurricularesObrigatorios.add(componenteCurricular);
	}

	public List<ComponenteCurricular> getComponentesCurricularesObrigatorios() {
		return Collections.unmodifiableList(componentesCurricularesObrigatorios);
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
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
		Periodo other = (Periodo) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
}
