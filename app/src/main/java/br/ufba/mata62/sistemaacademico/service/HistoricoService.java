package br.ufba.mata62.sistemaacademico.service;

import br.ufba.mata62.sistemaacademico.domain.*;

public class HistoricoService {
    public static int calcularCargaHorariaOptativas(Historico historico) {
        int retorno = 0;

        for (PeriodoCursado periodoCursado : historico.getPeriodosCursados()) {
            for (ComponenteCurricularCursado componenteCurricularCursado : periodoCursado
                    .getComponentesCurricularesCursados()) {
                if (componenteCurricularCursado.getComponenteCurricular().getNatureza() == Natureza.OPTATIVA) {
                    retorno += componenteCurricularCursado.getComponenteCurricular().getDisciplina().getCargaHoraria();
                }
            }
        }
        return retorno;
    }

    public static int calcularCargaHorariaObrigatorias(Historico historico) {
        int retorno = 0;

        for (PeriodoCursado periodoCursado : historico.getPeriodosCursados()) {
            for (ComponenteCurricularCursado componenteCurricularCursado : periodoCursado
                    .getComponentesCurricularesCursados()) {
                if (componenteCurricularCursado.getComponenteCurricular().getNatureza() == Natureza.OBRIGATORIA) {
                    retorno += componenteCurricularCursado.getComponenteCurricular().getDisciplina().getCargaHoraria();
                }
            }
        }
        return retorno;
    }

    public static Double calcularCoeficienteRendimento(Historico historico) {
        int disciplinas = 0;
        double notas = 0;
        boolean notaNula = true;

        for (PeriodoCursado periodoCursado : historico.getPeriodosCursados()) {
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

    public static void imprimirTXT(Historico historico) {

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
        System.out.println("Carga horária obrigatória: " + calcularCargaHorariaObrigatorias(historico));
        System.out.println("Carga horária optativas: " + calcularCargaHorariaOptativas(historico));
        System.out.println("CR: " + calcularCoeficienteRendimento(historico));
        System.out.println("");

    }

    public static void imprimirHTML(Historico historico) {
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
        System.out.println("<tr><td>Carga horária obrigatória: " + calcularCargaHorariaObrigatorias(historico) + "</td></tr>");
        System.out.println("<tr><td>Carga horária optativas: " + calcularCargaHorariaOptativas(historico) + "</td></tr>");
        System.out.println("<tr><td>CR: " + calcularCoeficienteRendimento(historico) + "</td></tr>");
        System.out.println("</table>");

    }
}
