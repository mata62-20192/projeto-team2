package br.ufba.mata62.sistemaacademico.domain;


import br.ufba.mata62.sistemaacademico.service.HistoricoService;

public class ImpressorHistoricoHtml extends ImpressorHistoricoTemplate {

	@Override
	public StringBuilder formatar(Historico historico) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th>Periodo</th>  <th> Código </th> <th>  Componentes Curriculares            </th> <th> CH  </th> <th> NT </th> <th> Nota </th> <th> RES      </th>");
		sb.append("</tr>");

		for (PeriodoCursado periodoCursado : historico.getPeriodosCursados()) {
			sb.append("<tr>");
			sb.append(String.format("<td> %-2s </td>\n", periodoCursado.getPeriodo()));
			sb.append("</tr>");
			for (ComponenteCurricularCursado ccc : periodoCursado.getComponentesCurricularesCursados()) {
				sb.append("<tr>");
				sb.append("<td>        </td>");
				sb.append(String.format(" <td> %s </td>", ccc.getComponenteCurricular().getDisciplina().getCodigo()));
				sb.append(String.format(" <td> %-36s </td>", ccc.getComponenteCurricular().getDisciplina().getNome()));
				sb.append(String.format(" <td> %-3s </td>", ccc.getComponenteCurricular().getDisciplina().getCargaHoraria()));
				sb.append(String.format(" <td> %s </td>", ccc.getComponenteCurricular().getNatureza().getSigla()));
				sb.append(String.format(" <td> %-4s </td>", ccc.getNota()));
				sb.append(String.format(" <td> %-5s </td>", ccc.getConceito()));
				sb.append("</tr>");
				sb.append("");

			}

		}

		sb.append("<tr><td>Total geral</td></tr>");
		sb.append("<tr><td>Carga horária obrigatória: " + HistoricoService.calcularCargaHorariaObrigatorias(historico) + "</td></tr>");
		sb.append("<tr><td>Carga horária optativas: " + HistoricoService.calcularCargaHorariaOptativas(historico) + "</td></tr>");
		sb.append("<tr><td>CR: " + HistoricoService.calcularCoeficienteRendimento(historico) + "</td></tr>");
		sb.append("</table>");

		return sb;
	}
}
