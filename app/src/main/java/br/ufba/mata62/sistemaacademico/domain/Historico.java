package br.ufba.mata62.sistemaacademico.domain;

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

	public void insereComponenteCurricularCursado(int s, ComponenteCurricularCursado c) {
		periodosCursados.get(s - 1).insereComponenteCurricularCursado(c);
	}
	
	private int calcularCargaHorariaOptativas() {
		int retorno = 0;
		for (PeriodoCursado periodoCursado : periodosCursados) {
			for (ComponenteCurricularCursado componenteCurricularCursado : periodoCursado
					.getComponentesCurricularesCursados()) {
				if (componenteCurricularCursado.getComponenteCurricular().getNatureza() == Natureza.OPTATIVA) {
					retorno += componenteCurricularCursado.getComponenteCurricular().getDisciplina().getCargaHoraria();
				}
			}
		}
		return retorno;
	}

	private int calcularCargaHorariaObrigatorias() {
		int retorno = 0;
		for (PeriodoCursado periodoCursado : periodosCursados) {
			for (ComponenteCurricularCursado componenteCurricularCursado : periodoCursado
					.getComponentesCurricularesCursados()) {
				if (componenteCurricularCursado.getComponenteCurricular().getNatureza() == Natureza.OBRIGATORIA) {
					retorno += componenteCurricularCursado.getComponenteCurricular().getDisciplina().getCargaHoraria();
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
			for (ComponenteCurricularCursado componenteCurricularCursado : periodoCursado
					.getComponentesCurricularesCursados()) {
				if (componenteCurricularCursado.getNota() != null) {
					notas += componenteCurricularCursado.getNota();
					disciplinas++;

					notaNula = false;
				}
			}
		}

		if (notaNula) {
			return null;
		} else {
			return notas / disciplinas;
		}
	}

	public void imprimirTXT() {

		System.out.println("Periodo    Codigo   Componentes Curriculares               CH    NT   Nota    RES      ");

		for (PeriodoCursado periodoCursado : periodosCursados) {
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
		System.out.println("Carga horaria obrigatoria: " + calcularCargaHorariaObrigatorias());
		System.out.println("Carga horaria optativas: " + calcularCargaHorariaOptativas());
		System.out.println("CR: " + calcularCoeficienteRendimento());
		System.out.println("");

	}

	public void imprimirHTML() {
		System.out.println("<table>");
		System.out.println("<tr>");
		System.out.println(
				"<th>Periodo</th>  <th> Codigo </th> <th>  Componentes Curriculares            </th> <th> CH  </th> <th> NT </th> <th> Nota </th> <th> RES      </th>");
		System.out.println("</tr>");

		for (PeriodoCursado periodoCursado : periodosCursados) {
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
		System.out.println("<tr><td>Carga horaria obrigatoria: " + calcularCargaHorariaObrigatorias() + "</td></tr>");
		System.out.println("<tr><td>Carga horaria optativas: " + calcularCargaHorariaOptativas() + "</td></tr>");
		System.out.println("<tr><td>CR: " + calcularCoeficienteRendimento() + "</td></tr>");
		System.out.println("</table>");

	}
}
