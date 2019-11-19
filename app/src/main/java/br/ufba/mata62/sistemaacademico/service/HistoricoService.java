package br.ufba.mata62.sistemaacademico.service;

import br.ufba.mata62.sistemaacademico.domain.*;

public class HistoricoService {

    public static StringBuilder imprimir(ImpressorHistoricoTemplate impressaoHistorico, Historico historico) {
        return impressaoHistorico.imprimir(historico);
    }

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

}
