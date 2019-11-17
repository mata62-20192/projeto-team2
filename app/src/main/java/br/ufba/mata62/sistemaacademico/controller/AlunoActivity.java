package br.ufba.mata62.sistemaacademico.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import br.ufba.mata62.sistemaacademico.R;

public class AlunoActivity extends AppCompatActivity {
    private TextView lblNome;
    private TextView lblMatricula;
    private TextView lblSemestre;
    private Spinner historicoMenuSpinner;

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
		
		historicoMenuSpinner = (Spinner) findViewById(R.id.historicoMenuSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.historicoArray, R.layout.spinner_custom_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        historicoMenuSpinner.setAdapter(adapter);

        historicoMenuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView parent, View view, int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
            }
            public void onNothingSelected(AdapterView parent){
                // Another interface callback
            }
        });

    }
}
