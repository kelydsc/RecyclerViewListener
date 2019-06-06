package br.com.digitalhouse.digital.recyclerviewlistener.contatos.adapters;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digital.recyclerviewlistener.R;
import br.com.digitalhouse.digital.recyclerviewlistener.contatos.RecyclerViewClickListener;
import br.com.digitalhouse.digital.recyclerviewlistener.contatos.model.Contato;

public class RecyclerViewContatosAdapter extends RecyclerView.Adapter<RecyclerViewContatosAdapter.ViewHolder> {

    private List<Contato> contatos;
    private RecyclerViewClickListener listener;

    public RecyclerViewContatosAdapter(List<Contato> contatos, RecyclerViewClickListener listener) {
        this.contatos = contatos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View itemview = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.contato_recyclerview_item, viewGroup,false);
        //true fixa o layout e false muda dinamicamnete

        ViewHolder viewHolder = new ViewHolder(itemview);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        //valor não pode mudar
        final Contato contato = contatos.get(position);
        viewHolder.setaContatoNaTela(contato);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(contato);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Atributos dos elementos
        private ImageView imageViewFoto;
        private TextView textViewNome;
        private TextView textViewTelefone;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Inicializamos as views
            imageViewFoto = itemView.findViewById(R.id.imageViewFoto);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewTelefone = itemView.findViewById(R.id.textViewTelefone);
        }

        //Atribui o as views os valores da variável contato
        public void setaContatoNaTela(Contato contato){
            imageViewFoto.setImageDrawable(ContextCompat.getDrawable(imageViewFoto.getContext(),contato.getFoto()));
            textViewNome.setText(contato.getNome());
            textViewTelefone.setText(contato.getNumero());
        }
    }
}
