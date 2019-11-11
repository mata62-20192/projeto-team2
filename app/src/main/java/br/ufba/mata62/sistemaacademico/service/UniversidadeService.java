package br.ufba.mata62.sistemaacademico.service;

import br.ufba.mata62.sistemaacademico.domain.*;

public class UniversidadeService {

    public static void insereAluno(long m, Aluno aluno) throws Exception{
        if(Universidade.getAlunos().containsKey(m)) {
            throw new Exception("Aluno já cadastrado.");
        }else {
            Universidade.insereAluno(m, aluno);
        }
    }
}
