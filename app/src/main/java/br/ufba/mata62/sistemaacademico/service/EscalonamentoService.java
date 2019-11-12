package br.ufba.mata62.sistemaacademico.service;

import java.util.ArrayList;

import br.ufba.mata62.sistemaacademico.domain.Aluno;

public class EscalonamentoService {
    private static EscalonamentoStrategy strategy;

    public static void setEscalonamentoStrategy(EscalonamentoStrategy strategy){
        EscalonamentoService.strategy = strategy;
    }

    public static void ordenar(ArrayList<Aluno> alunos){
        strategy.ordenar(alunos);
    }
}
