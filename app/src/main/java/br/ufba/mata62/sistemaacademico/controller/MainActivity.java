package br.ufba.mata62.sistemaacademico.controller;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.ufba.mata62.sistemaacademico.R;
import br.ufba.mata62.sistemaacademico.domain.*;
import br.ufba.mata62.sistemaacademico.repository.*;

public class MainActivity extends AppCompatActivity {
    final static int codigoCurso = 112140;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Universidade.setNome("Universidade Federal da Bahia");
        Universidade.setSigla("UFBA");

        AssetManager assetManager = getResources().getAssets();

        LeitorDados leitorDados = new LeitorDados("dados.txt");
        leitorDados.lerDados(assetManager);

        startActivity(new Intent(this, ListarAlunosActivity.class));
        finish();
    }
}
