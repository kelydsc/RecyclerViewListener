package br.com.digitalhouse.digital.recyclerviewlistener.contatos.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digital.recyclerviewlistener.R;
import br.com.digitalhouse.digital.recyclerviewlistener.contatos.RecyclerViewClickListener;
import br.com.digitalhouse.digital.recyclerviewlistener.contatos.adapters.RecyclerViewContatosAdapter;
import br.com.digitalhouse.digital.recyclerviewlistener.contatos.model.Contato;

public class ContatoActivity extends AppCompatActivity implements RecyclerViewClickListener {

    //Atributos
    private RecyclerView recyclerView;
    private RecyclerViewContatosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inicializamos as views
        recyclerView = findViewById(R.id.recyclerViewContatos);

        //por padrão nasce na vertical
        // Adiciona o layout manager ao recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adiciona o adapter ao recyclerview
        adapter = new RecyclerViewContatosAdapter(getContatos(),this);

        recyclerView.setAdapter(adapter);


    }

    // REtorna lista de contatos para recycleriew
    private List<Contato> getContatos() {

        List<Contato> contatos = new ArrayList<>();

        contatos.add(new Contato("Tairo","11-9111-1111",R.drawable.tairo));
        contatos.add(new Contato("Jessica","11-9111-1111",R.drawable.jessica));
        contatos.add(new Contato("Victor","11-9111-1111",R.drawable.victor));
        contatos.add(new Contato("Guilherme","11-9111-1111",R.drawable.guilherme));
        contatos.add(new Contato("Fabio","11-9111-1111",R.drawable.fabio));

        return  contatos;
    }

    // Método para escutar evento de click em recyclerview
    @Override
    public void onClick(Contato contato) {

        //Snackbar.make(recyclerView,contato.getNome(), Snackbar.LENGTH_SHORT).show();

        Intent intent = new Intent(this,DetalheContatoActivity.class);
        intent.putExtra("CONTATO",contato);//passando todos os dados do Array para outra Actitivty

        //teste para enviar o resultado do Array
        startActivityForResult(intent, 1);
        //
        startActivity(intent);
    }
}
