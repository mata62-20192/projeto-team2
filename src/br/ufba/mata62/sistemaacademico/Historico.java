package br.ufba.mata62.sistemaacademico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Historico {
	private List<PeriodoCursado> periodosCursados;
	
	public Historico() {
		periodosCursados = new ArrayList<PeriodoCursado>();
	}

	public List<PeriodoCursado> getPeriodosCursados() {
		return Collections.unmodifiableList(periodosCursados);
	}
	
	public void inserePeriodoCursado(PeriodoCursado p) {
		periodosCursados.add(p);
	}
	
	private int calcularCargaHorariaOptativas() {
		int retorno = 0;
		for (PeriodoCursado periodoCursado : periodosCursados) {
			for(ComponenteCurricularCursado componenteCurricularCursado : periodoCursado.getComponentesCurricularesCursados()) {
				if(componenteCurricularCursado.getComponenteCurricular().getNatureza() == Natureza.OPTATIVA) {
					retorno+=componenteCurricularCursado.getComponenteCurricular().getDisciplina().getCargaHoraria();
				}
			}
		}
		return retorno;
	}
	
	private int calcularCargaHorariaObrigatorias() {
		int retorno = 0;
		for (PeriodoCursado periodoCursado : periodosCursados) {
			for(ComponenteCurricularCursado componenteCurricularCursado : periodoCursado.getComponentesCurricularesCursados()) {
				if(componenteCurricularCursado.getComponenteCurricular().getNatureza()==Natureza.OBRIGATORIA) {
					retorno+=componenteCurricularCursado.getComponenteCurricular().getDisciplina().getCargaHoraria();
				}
			}
		}
		return retorno;
	}
	
	private Double calcularCoeficienteRendimento() {
		int disciplinas = 0;
		double notas = 0;
		boolean notaNula = true;
		
		for (PeriodoCursado periodoCursado : periodosCursados) {
			for(ComponenteCurricularCursado componenteCurricularCursado : periodoCursado.getComponentesCurricularesCursados()) {
				if(componenteCurricularCursado.getNota() != null) {
					notas+=componenteCurricularCursado.getNota();
					disciplinas++;
					
					notaNula = false;					
				}
			}
		}
		
		if(notaNula) {
			return null;
		}else {
			return notas/disciplinas;
		}
	}
	
	public void imprimirTXT() {
		for(PeriodoCursado periodoCursado : periodosCursados) {
			System.out.println("Periodo: " + periodoCursado.getPeriodo());
			for(ComponenteCurricularCursado ccc : periodoCursado.getComponentesCurricularesCursados()) {
				System.out.println("    Nome: " + ccc.getComponenteCurricular().getDisciplina().getNome());
				System.out.println("    Codigo: " + ccc.getComponenteCurricular().getDisciplina().getCodigo());
				System.out.println("    Carga Horaria: " + ccc.getComponenteCurricular().getDisciplina().getCargaHoraria());
				System.out.println("    Natureza: " + ccc.getComponenteCurricular().getNatureza());
				System.out.println("    Nota: " + ccc.getNota());
				System.out.println("    Conceito: " + ccc.getConceito());
			}
		}
		
		System.out.println("    Carga Horaria Total das Disciplinas Obrigatorias: " + calcularCargaHorariaObrigatorias());
		System.out.println("    Carga Horaria Total das Disciplinas Optativas: " + calcularCargaHorariaOptativas());
		System.out.println("    Coeficiente de Rendimento: " + calcularCoeficienteRendimento());
	}
	
	public void imprimirHTML() {
		
	}
}
