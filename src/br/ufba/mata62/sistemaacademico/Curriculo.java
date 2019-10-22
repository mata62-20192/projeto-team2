package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Curriculo {
	private List<ComponenteCurricular> componentesCurricularesOptativos;
	private Set<Periodo> periodos;
	
	public Curriculo() { 
		componentesCurricularesOptativos = new ArrayList<ComponenteCurricular>();
		periodos = new HashSet<Periodo>();
	}
	
	public List<ComponenteCurricular> getComponentesCurricularesOptativos() {
		return Collections.unmodifiableList(componentesCurricularesOptativos);
	}

	public Set<Periodo> getPeriodos() {
		return Collections.unmodifiableSet(periodos);
	}
	
	/*TODO: cargaHorariaOptativa, cargaHorariaObrigatoria, imprimir */
	
	public void adicionarComponenteOptativo(Disciplina disciplina) {
		ComponenteCurricular c = new ComponenteCurricular(disciplina, Natureza.OPTATIVA);
		componentesCurricularesOptativos.add(c);
	}
	
	public void adicionarComponenteObrigatorio(Disciplina disciplina, int semestre) {
		Periodo periodo = new Periodo(semestre);
		periodos.add(periodo);
		
		ComponenteCurricular c = new ComponenteCurricular(disciplina, Natureza.OBRIGATORIA);
		
		for(Periodo p : periodos) {
			if(p.getNumero() == semestre) {
				p.insereComponenteCurricular(c);
			}
		}
	}

	public void imprimir() {
		
	}
}
