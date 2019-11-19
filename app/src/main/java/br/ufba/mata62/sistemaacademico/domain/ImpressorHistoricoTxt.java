package br.ufba.mata62.sistemaacademico.domain;

import java.util.Locale;

import br.ufba.mata62.sistemaacademico.service.HistoricoService;

public class ImpressorHistoricoTxt extends ImpressorHistoricoTemplate {

	@Override
	public StringBuilder formatar(Historico historico) {
		StringBuilder sb = new StringBuilder("");
		//sb.append("Periodo    Código   Componentes Curriculares               CH    NT   Nota    RES     <br> ");
		for (PeriodoCursado periodoCursado : historico.getPeriodosCursados()) {
			sb.append(String.format("%s<br>", periodoCursado.getPeriodo()));
			sb.append("<br>");
			for (ComponenteCurricularCursado ccc : periodoCursado.getComponentesCurricularesCursados()) {
				sb.append("         ");
				sb.append(String.format("  %s ", ccc.getComponenteCurricular().getDisciplina().getCodigo()));
				sb.append("<br>");
				sb.append(String.format("  %-36s ", ccc.getComponenteCurricular().getDisciplina().getNome()));
				sb.append("<br>");
				sb.append(String.format("  %-3s ", ccc.getComponenteCurricular().getDisciplina().getCargaHoraria()));
				sb.append("<br>");
				sb.append(String.format("  %s ", ccc.getComponenteCurricular().getNatureza().getSigla()));
				sb.append("<br>");
				sb.append(String.format("  %-4s ", ccc.getNota()));
				sb.append("<br>");
				sb.append(String.format("  %-5s ", ccc.getConceito()));
				sb.append("<br>");
				sb.append("<br>");

			}

		}

		sb.append("<br>");
		sb.append("Total geral");
		sb.append("<br>");
		sb.append("Carga horária obrigatória: " + HistoricoService.calcularCargaHorariaObrigatorias(historico));
		sb.append("<br>");
		sb.append("Carga horária optativas: " + HistoricoService.calcularCargaHorariaOptativas(historico));
		sb.append("<br>");
		sb.append(String.format(Locale.ENGLISH, "CR: %.2f", HistoricoService.calcularCoeficienteRendimento(historico)));
		sb.append("<br>");

		return  sb;
	}
}
