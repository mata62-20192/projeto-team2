package br.ufba.mata62.sistemaacademico.domain;

import br.ufba.mata62.sistemaacademico.service.HistoricoService;

public class ImpressorHistoricoTxt extends ImpressorHistoricoTemplate {

	@Override
	public StringBuilder render(Historico historico) {
		StringBuilder sb = new StringBuilder("Periodo    Código   Componentes Curriculares               CH    NT   Nota    RES      ");

		for (PeriodoCursado periodoCursado : historico.getPeriodosCursados()) {
			sb.append(String.format("%s\n", periodoCursado.getPeriodo()));
			for (ComponenteCurricularCursado ccc : periodoCursado.getComponentesCurricularesCursados()) {
				sb.append("         ");
				sb.append(String.format("  %s ", ccc.getComponenteCurricular().getDisciplina().getCodigo()));
				sb.append(String.format("  %-36s ", ccc.getComponenteCurricular().getDisciplina().getNome()));
				sb.append(String.format("  %-3s ", ccc.getComponenteCurricular().getDisciplina().getCargaHoraria()));
				sb.append(String.format("  %s ", ccc.getComponenteCurricular().getNatureza().getSigla()));
				sb.append(String.format("  %-4s ", ccc.getNota()));
				sb.append(String.format("  %-5s ", ccc.getConceito()));
				sb.append("\n");

			}

		}

		sb.append("\n");
		sb.append("Total geral");
		sb.append("Carga horária obrigatória: " + HistoricoService.calcularCargaHorariaObrigatorias(historico));
		sb.append("Carga horária optativas: " + HistoricoService.calcularCargaHorariaOptativas(historico));
		sb.append("CR: " + HistoricoService.calcularCoeficienteRendimento(historico));
		sb.append("\n");

		return  sb;
	}
}
