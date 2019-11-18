package br.ufba.mata62.sistemaacademico.controller;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

import br.ufba.mata62.sistemaacademico.R;
import br.ufba.mata62.sistemaacademico.domain.*;
import br.ufba.mata62.sistemaacademico.repository.*;
import br.ufba.mata62.sistemaacademico.service.UniversidadeService;

public class MainActivity extends AppCompatActivity {
    final static int codigoCurso = 112140;
    static Curso curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Universidade.setNome("Universidade Federal da Bahia");
        Universidade.setSigla("UFBA");

        AssetManager assetManager = getResources().getAssets();

        LeitorDadosAndroid leitorDados = new LeitorDadosAndroid("dados.txt");
        leitorDados.lerDados(assetManager);

        curso = Universidade.getCursos().get(codigoCurso);

        Aluno aluno1 = new Aluno("Leonardo de Andrade Santana", 1, "2018.1", "123", curso);
        Aluno aluno2 = new Aluno("Pablo Henrique Rego dos Santos Cabral", 2, "2020.2", "123", curso);
        Aluno aluno3 = new Aluno("Tales Iago Batista", 3, "2019.1", "123", curso);
        Aluno aluno4 = new Aluno("Rafael Ribeiro Lopes Embiruçu", 4, "2019.1", "123", curso);
        Aluno aluno5 = new Aluno("Marcos Lordelo Marques", 5, "2019.2", "123", curso);
        Aluno aluno6 = new Aluno("Christian Alves Urbano", 6, "2020.1", "123", curso);
        Aluno aluno7 = new Aluno("Andréa da Silva de Oliveira", 7, "2020.1", "123", curso);
        
        Universidade.insereAluno(1, aluno1);
        Universidade.insereAluno(2, aluno2);
        Universidade.insereAluno(3, aluno3);
        Universidade.insereAluno(4, aluno4);
        Universidade.insereAluno(5, aluno5);
        Universidade.insereAluno(6, aluno6);
        Universidade.insereAluno(7, aluno7);

        for(Aluno aluno : new ArrayList<>(curso.getAlunos().values())){
            PeriodoCursado pc = new PeriodoCursado(aluno.getSemestreInicio());
            aluno.getHistorico().inserePeriodoCursado(pc);

            for(ComponenteCurricular cc : aluno.getComponentesCurricularesObrigatorios(1)) {
                ComponenteCurricularCursado ccc = new ComponenteCurricularCursado(cc);

                Random random = new Random();
                ccc.setNota(random.nextInt(101) / 10.0);

                aluno.insereComponenteCurricularCursado(1, ccc);
            }
        }

        startActivity(new Intent(this, ListarAlunosActivity.class));
        finish();
    }
}
