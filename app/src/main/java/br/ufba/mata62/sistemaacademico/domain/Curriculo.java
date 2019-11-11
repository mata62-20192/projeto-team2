package br.ufba.mata62.sistemaacademico.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Curriculo {
	private List<ComponenteCurricular> componentesCurricularesOptativos;
	private Map<Integer, Periodo> periodos;
	
	public Curriculo() { 
		componentesCurricularesOptativos = new ArrayList<ComponenteCurricular>();
		periodos = new TreeMap<Integer, Periodo>();
	}
	
	public List<ComponenteCurricular> getComponentesCurricularesOptativos() {
		return Collections.unmodifiableList(componentesCurricularesOptativos);
	}

	public Map<Integer, Periodo> getPeriodos() {
		return Collections.unmodifiableMap(periodos);
	}
	
	public List<ComponenteCurricular> getComponentesCurricularesObrigatorios(int s) {
		return periodos.get(s).getComponentesCurricularesObrigatorios(); 
	}
	
	public void adicionarComponenteOptativo(Disciplina disciplina) {
		ComponenteCurricular c = new ComponenteCurricular(disciplina, Natureza.OPTATIVA);
		componentesCurricularesOptativos.add(c);
	}
	
	
	public void adicionarComponenteObrigatorio(Disciplina disciplina, int semestre) {
		ComponenteCurricular c = new ComponenteCurricular(disciplina, Natureza.OBRIGATORIA);
		
		if(!periodos.containsKey(semestre)) {
			Periodo periodo = new Periodo(semestre);
			periodos.put(semestre, periodo);
		}
		
		periodos.get(semestre).insereComponenteCurricular(c);
	}
	
	public void imprimir() {
		System.out.println("Disciplinas Obrigatorias:");
		for(Periodo periodo : periodos.values()) {
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
