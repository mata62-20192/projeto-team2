package br.ufba.mata62.sistemaacademico.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

import br.ufba.mata62.sistemaacademico.R;
import br.ufba.mata62.sistemaacademico.domain.Aluno;

public class AlunoActivity extends AppCompatActivity {
    private TextView lblNome;
    private TextView lblMatricula;
    private TextView lblSemestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lblNome = (TextView) findViewById(R.id.lblNome);
        lblMatricula = (TextView) findViewById(R.id.lblMatricula);
        lblSemestre = (TextView) findViewById(R.id.lblSemestre);

        Intent intent = getIntent();
        Aluno aluno = intent.getParcelableExtra("aluno");

        String nome = "Nome: " + aluno.getNome();
        String matricula = "Matrícula: " + String.format(Locale.ENGLISH, "%d", aluno.getMatricula());
        String semestre = "Semestre de Ingresso: " + aluno.getSemestreInicio();

        lblNome.setText(nome);
        lblMatricula.setText(matricula);
        lblSemestre.setText(semestre);
    }
}
