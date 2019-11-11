package br.ufba.mata62.sistemaacademico.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import br.ufba.mata62.sistemaacademico.R;
import br.ufba.mata62.sistemaacademico.domain.*;

public class ListarAlunos extends AppCompatActivity {
    private FloatingActionButton fab;

    private ListView listView;
    private AlunoAdapter alunoAdapter;
    private ArrayList<Aluno> alunos;
    private Curso curso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        listView = (ListView) findViewById(R.id.listView);

        int codigoCurso = MainActivity.codigoCurso;

        curso = Universidade.getCursos().get(codigoCurso);

        alunos = new ArrayList<>(curso.getAlunos().values());

        alunoAdapter = new AlunoAdapter(this, alunos);

        listView.setAdapter(alunoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int i, long l) {
                Aluno aluno = (Aluno) listView.getItemAtPosition(i);
                //TODO
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListarAlunos.this, CadastrarAluno.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        alunos = new ArrayList<>(curso.getAlunos().values());

        Aluno aluno1 = new Aluno("Cabeça1", 123456, "2018.1", "123", curso);
        Aluno aluno2 = new Aluno("Cabeça2", 123456, "2018.1", "123", curso);
        Aluno aluno3 = new Aluno("Cabeça3", 123456, "2018.1", "123", curso);
        Aluno aluno4 = new Aluno("Cabeça4", 123456, "2018.1", "123", curso);
        Aluno aluno5 = new Aluno("Cabeça5", 123456, "2018.1", "123", curso);
        Aluno aluno6 = new Aluno("Cabeça6", 123456, "2018.1", "123", curso);

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        alunos.add(aluno4);
        alunos.add(aluno5);
        alunos.add(aluno6);

        alunoAdapter = new AlunoAdapter(this, alunos);

        listView.setAdapter(alunoAdapter);

        //alunoAdapter.notifyDataSetChanged();
    }
}
