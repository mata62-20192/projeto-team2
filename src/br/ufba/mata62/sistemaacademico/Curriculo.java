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
	
	public void adicionarComponenteOptativo(Disciplina disciplina) {
		ComponenteCurricular c = new ComponenteCurricular(disciplina, Natureza.OPTATIVA);
		componentesCurricularesOptativos.add(c);
	}
	
	
	public void adicionarComponenteObrigatorio(Disciplina disciplina, int semestre) {
		Periodo periodo = new Periodo(semestre);
		
		if(!periodos.contains(periodo)) {
			periodos.add(periodo);
		}else{
			ComponenteCurricular c = new ComponenteCurricular(disciplina, Natureza.OBRIGATORIA);
			
			for(Periodo p : periodos) {
				if(p.equals(periodo)) {
					p.insereComponenteCurricular(c);
				}
			}
		}
	}
	
	public void imprimir() {
		System.out.println("Disciplinas Obrigatorias:");
		for(Periodo periodo : periodos) {
			System.out.println("Semestre " + periodo.getNumero());
			for(ComponenteCurricular componente : periodo.getComponentesCurricularesObrigatorios()) {
				System.out.println("	Disciplina: " + componente.getDisciplina().getNome());
				System.out.println("	Codigo: " + componente.getDisciplina().getCodigo());
				System.out.println("	Carga Horaria: " + componente.getDisciplina().getCargaHoraria());
			}
		}
		
		System.out.println("Disciplinas Optativas:");
		for(ComponenteCurricular componente : componentesCurricularesOptativos) {
			System.out.println("	Disciplina: " + componente.getDisciplina().getNome());
			System.out.println("	Codigo: " + componente.getDisciplina().getCodigo());
			System.out.println("	Carga Horaria: " + componente.getDisciplina().getCargaHoraria());
		}
	} 
}
