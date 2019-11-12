package br.ufba.mata62.sistemaacademico.service;

import java.util.ArrayList;
import java.util.Map;

import br.ufba.mata62.sistemaacademico.domain.Aluno;

public interface EscalonamentoStrategy {
    void ordenar(ArrayList<Aluno> alunos);
}
