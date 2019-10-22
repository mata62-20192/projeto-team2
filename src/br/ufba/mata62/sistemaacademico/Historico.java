package br.ufba.mata62.sistemaacademico;

import java.math.BigDecimal;
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
	
	private void imprimirTXT() {
		
	}
	
	private void imprimirHTML() {
		
	}
	
	private int calcularCargaHorariaOptativas() {
		int retorno = 0;
		for (PeriodoCursado periodoCursado : periodosCursados) {
			for(ComponenteCurricularCursado componenteCurricularCursado : periodoCursado.getComponentesCurricularesCursados()) {
				if(componenteCurricularCursado.getComponenteCurricular().getNatureza()==Natureza.OPTATIVA) {
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
		for (PeriodoCursado periodoCursado : periodosCursados) {
			for(ComponenteCurricularCursado componenteCurricularCursado : periodoCursado.getComponentesCurricularesCursados()) {
				disciplinas++;
				notas+=componenteCurricularCursado.getNota();
			}
		}
		return notas/disciplinas;
	}
}
