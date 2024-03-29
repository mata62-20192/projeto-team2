package br.ufba.mata62.sistemaacademico.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import br.ufba.mata62.sistemaacademico.R;
import br.ufba.mata62.sistemaacademico.domain.Curriculo;
import br.ufba.mata62.sistemaacademico.domain.Curso;
import br.ufba.mata62.sistemaacademico.service.ImpressorCurriculoService;

public class CurriculoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Curso curso;
    private Curriculo curriculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.curriculo_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

        curso = MainActivity.curso;

        curriculo = curso.getCurriculo();

        webView.loadDataWithBaseURL(null, ImpressorCurriculoService.imprimir(curriculo).toString(), "text/HTML", "UTF-8", null);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.curriculo_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_listar_alunos) {
            startActivity(new Intent(this, ListarAlunosActivity.class));
        } else if (id == R.id.nav_escalonamento) {
            startActivity(new Intent(this, EscalonamentoActivity.class));
        }

        finish();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.curriculo_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
