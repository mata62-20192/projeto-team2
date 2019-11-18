package br.ufba.mata62.sistemaacademico.service;

import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import br.ufba.mata62.sistemaacademico.domain.Aluno;
import br.ufba.mata62.sistemaacademico.domain.ComponenteCurricular;
import br.ufba.mata62.sistemaacademico.domain.ComponenteCurricularCursado;
import br.ufba.mata62.sistemaacademico.domain.PeriodoCursado;

public class CadastrarAlunoService {
    public static void matricularDisciplinas(Aluno aluno, String semestre){
        PeriodoCursado pc = new PeriodoCursado(semestre);
        aluno.getHistorico().inserePeriodoCursado(pc);

        for(ComponenteCurricular cc : aluno.getComponentesCurricularesObrigatorios(1)) {
            ComponenteCurricularCursado ccc = new ComponenteCurricularCursado(cc);
            aluno.insereComponenteCurricularCursado(1, ccc);
        }
    }
}
