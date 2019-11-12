package br.ufba.mata62.sistemaacademico.controller;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.ufba.mata62.sistemaacademico.R;
import br.ufba.mata62.sistemaacademico.domain.*;
import br.ufba.mata62.sistemaacademico.service.*;

public class CadastrarAlunoActivity extends AppCompatActivity {
    private EditText edtNome;
    private EditText edtSemestre;
    private EditText edtMatricula;
    private Curso curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_aluno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtSemestre = (EditText) findViewById(R.id.edtSemestre);
        edtMatricula = (EditText) findViewById(R.id.edtMatricula);

        int codigoCurso = MainActivity.codigoCurso;

        curso = Universidade.getCursos().get(codigoCurso);

    }

    private boolean isNomeVazio(String nome){

        if(nome.isEmpty()){
            edtNome.setError("O campo não pode estar vazio");
            return false;
        }else{
            edtNome.setError(null);
            return true;
        }
    }

    private boolean isSemestreVazio(String semestre){

        if (semestre.isEmpty()) {
            edtSemestre.setError("O campo não pode estar vazio");
            return false;
        }else{
            edtNome.setError(null);
            return true;
        }
    }

    private boolean isMatriculaVazia(String matricula){

        if(matricula.isEmpty()){
            edtMatricula.setError("O campo não pode estar vazio");
            return false;
        }else{
            edtMatricula.setError(null);
            return true;
        }
    }

    private boolean isCamposValidos(String nome, String semestre, String matricula){
        if(!isNomeVazio(nome) | !isSemestreVazio(semestre) | !isMatriculaVazia(matricula)){
            return false;
        }

        return true;
    }

    private void cadastrarAluno(){
        String nome = edtNome.getText().toString().trim();
        String semestre = edtSemestre.getText().toString().trim();
        String matricula = edtMatricula.getText().toString().trim();

        if(!isCamposValidos(nome, semestre, matricula)){
            return;
        }

        Long matriculaValida = Long.parseLong(matricula);

        Aluno aluno = new Aluno(nome, matriculaValida, semestre, "123", curso);

        try{
            UniversidadeService.insereAluno(matriculaValida, aluno);
            PeriodoCursado pc = new PeriodoCursado(semestre);
            aluno.getHistorico().inserePeriodoCursado(pc);

            for(ComponenteCurricular cc : aluno.getComponentesCurricularesObrigatorios(1)) {
                ComponenteCurricularCursado ccc = new ComponenteCurricularCursado(cc);
                aluno.insereComponenteCurricularCursado(1, ccc);
            }

            Toast.makeText(this, "Aluno cadastrado.", Toast.LENGTH_SHORT).show();
            finish();
        }catch(Exception e){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Aviso");
            dialog.setMessage(e.getMessage());
            dialog.setNeutralButton("OK", null);
            dialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cadastrar_aluno, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_save:
                cadastrarAluno();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
