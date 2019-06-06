package br.com.digitalhouse.digital.recyclerviewlistener.contatos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digital.recyclerviewlistener.R;
import br.com.digitalhouse.digital.recyclerviewlistener.contatos.model.Contato;

public class DetalheContatoActivity extends AppCompatActivity {

    private ImageView imageViewContato;
    private TextView textViewNome;
    private TextView textViewTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_contato);

        textViewNome = findViewById(R.id.textViewNome);
        textViewTelefone = findViewById(R.id.textViewTelefone);
        imageViewContato = findViewById(R.id.imageViewFoto);

        //Valido se vmeio alguma coisa na intent
        if (getIntent() != null && getIntent().getExtras() != null) {
            Contato contato = getIntent().getParcelableExtra("CONTATO");

            if (contato != null) {
                // Posso usar o contato para mostrar os dados na tela
                imageViewContato.setImageResource(contato.getFoto());
                textViewNome.setText(contato.getNome());
                textViewTelefone.setText(contato.getNumero());
            }
        }
    }
}
