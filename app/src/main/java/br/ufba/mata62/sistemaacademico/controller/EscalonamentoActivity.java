package br.ufba.mata62.sistemaacademico.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import br.ufba.mata62.sistemaacademico.R;
import br.ufba.mata62.sistemaacademico.domain.Aluno;
import br.ufba.mata62.sistemaacademico.domain.Curso;
import br.ufba.mata62.sistemaacademico.domain.EscalonamentoCRStrategy;
import br.ufba.mata62.sistemaacademico.domain.EscalonamentoSemestreStrategy;
import br.ufba.mata62.sistemaacademico.service.EscalonamentoService;

public class EscalonamentoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        private ListView listView;
        private AlunoEscalonamentoAdapter alunoEscalonamentoAdapter;
        private Curso curso;
        private ArrayList<Aluno> alunos;
        private boolean sort = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escalonamento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.escalonamento_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        curso = MainActivity.curso;

        alunos = new ArrayList<>(curso.getAlunos().values());

        EscalonamentoService.setEscalonamentoStrategy(new EscalonamentoCRStrategy());
        EscalonamentoService.ordenar(alunos);

        alunoEscalonamentoAdapter = new AlunoEscalonamentoAdapter(this, alunos);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(alunoEscalonamentoAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.escalonamento_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.escalonamento, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sort) {
            sort = !sort;

            alunos = new ArrayList<>(curso.getAlunos().values());

            if(sort){
                item.setTitle(R.string.action_sort_semestre);

                EscalonamentoService.setEscalonamentoStrategy(new EscalonamentoCRStrategy());
                EscalonamentoService.ordenar(alunos);
            }else{
                item.setTitle(R.string.action_sort_cr);

                EscalonamentoService.setEscalonamentoStrategy(new EscalonamentoSemestreStrategy());
                EscalonamentoService.ordenar(alunos);
            }

            alunoEscalonamentoAdapter.clear();
            alunoEscalonamentoAdapter.addAll(alunos);

            alunoEscalonamentoAdapter.notifyDataSetChanged();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_listar_alunos) {
            startActivity(new Intent(this, ListarAlunosActivity.class));
            finish();
        } else if (id == R.id.nav_curriculo) {
            startActivity(new Intent(this, CurriculoActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.escalonamento_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
