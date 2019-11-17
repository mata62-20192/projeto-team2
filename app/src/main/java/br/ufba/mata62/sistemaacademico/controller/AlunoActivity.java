package br.ufba.mata62.sistemaacademico.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import java.util.Locale;

import br.ufba.mata62.sistemaacademico.R;

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

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            String nomeAluno = extras.getString("nome");
            long matriculaAluno = extras.getLong("matricula");
            String semestreAluno = extras.getString("semestre");

            String nome = "Nome: " + nomeAluno;
            String matricula = "Matrícula: " + String.format(Locale.ENGLISH, "%d", matriculaAluno);
            String semestre = "Semestre de Ingresso: " + semestreAluno;

            lblNome.setText(nome);
            lblMatricula.setText(matricula);
            lblSemestre.setText(semestre);
        }
    }
}
