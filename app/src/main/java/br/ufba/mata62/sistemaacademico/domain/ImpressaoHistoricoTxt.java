package br.ufba.mata62.sistemaacademico.domain;

import br.ufba.mata62.sistemaacademico.service.HistoricoService;

public class ImpressaoHistoricoTxt implements ImpressaoHistorico{	
	
	
	public void render(Historico historico) {
		 System.out.println("Periodo    Código   Componentes Curriculares               CH    NT   Nota    RES      ");

	        for (PeriodoCursado periodoCursado : historico.getPeriodosCursados()) {
	            System.out.printf("%s\n", periodoCursado.getPeriodo());
	            for (ComponenteCurricularCursado ccc : periodoCursado.getComponentesCurricularesCursados()) {
	                System.out.print("         ");
	                System.out.printf("  %s ", ccc.getComponenteCurricular().getDisciplina().getCodigo());
	                System.out.printf("  %-36s ", ccc.getComponenteCurricular().getDisciplina().getNome());
	                System.out.printf("  %-3s ", ccc.getComponenteCurricular().getDisciplina().getCargaHoraria());
	                System.out.printf("  %s ", ccc.getComponenteCurricular().getNatureza().getSigla());
	                System.out.printf("  %-4s ", ccc.getNota());
	                System.out.printf("  %-5s ", ccc.getConceito());
	                System.out.println("");

	            }

	        }
	        System.out.println("");
	        System.out.println("Total geral");
	        System.out.println("Carga horária obrigatória: " + HistoricoService.calcularCargaHorariaObrigatorias(historico));
	        System.out.println("Carga horária optativas: " + HistoricoService.calcularCargaHorariaOptativas(historico));
	        System.out.println("CR: " + HistoricoService.calcularCoeficienteRendimento(historico));
	        System.out.println("");
		
	}
	
	

}
