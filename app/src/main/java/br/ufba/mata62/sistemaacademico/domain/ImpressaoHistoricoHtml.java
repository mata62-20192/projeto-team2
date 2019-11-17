package br.ufba.mata62.sistemaacademico.domain;

import br.ufba.mata62.sistemaacademico.service.HistoricoService;

public class ImpressaoHistoricoHtml implements ImpressaoHistorico {	
	
	HistoricoService historicoService;

	public void render(Historico historico) {
		System.out.println("<table>");
		System.out.println("<tr>");
		System.out.println(
				"<th>Periodo</th>  <th> Código </th> <th>  Componentes Curriculares            </th> <th> CH  </th> <th> NT </th> <th> Nota </th> <th> RES      </th>");
		System.out.println("</tr>");

		for (PeriodoCursado periodoCursado : historico.getPeriodosCursados()) {
			System.out.println("<tr>");
			System.out.printf("<td> %-2s </td>\n", periodoCursado.getPeriodo());
			System.out.println("</tr>");
			for (ComponenteCurricularCursado ccc : periodoCursado.getComponentesCurricularesCursados()) {
				System.out.println("<tr>");
				System.out.print("<td>        </td>");
				System.out.printf(" <td> %s </td>", ccc.getComponenteCurricular().getDisciplina().getCodigo());
				System.out.printf(" <td> %-36s </td>", ccc.getComponenteCurricular().getDisciplina().getNome());
				System.out.printf(" <td> %-3s </td>", ccc.getComponenteCurricular().getDisciplina().getCargaHoraria());
				System.out.printf(" <td> %s </td>", ccc.getComponenteCurricular().getNatureza().getSigla());
				System.out.printf(" <td> %-4s </td>", ccc.getNota());
				System.out.printf(" <td> %-5s </td>", ccc.getConceito());
				System.out.println("</tr>");
				System.out.println("");

			}

		}

		System.out.println("<tr><td>Total geral</td></tr>");
		System.out.println(
				"<tr><td>Carga horária obrigatória: " + HistoricoService.calcularCargaHorariaObrigatorias(historico) + "</td></tr>");
		System.out.println(
				"<tr><td>Carga horária optativas: " + HistoricoService.calcularCargaHorariaOptativas(historico) + "</td></tr>");
		System.out.println("<tr><td>CR: " + historicoService.calcularCoeficienteRendimento(Double.parseDouble(historico)) + "</td></tr>");
		System.out.println("</table>");

	}

}
