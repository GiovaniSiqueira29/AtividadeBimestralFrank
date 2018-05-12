package com.example.aluno.atividadebimestral;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterFocoEndemia extends BaseAdapter {
    List<FocoEndemia> focoEndemias;
    Context contexto;

    public AdapterFocoEndemia(Context context, List<FocoEndemia> focoEndemias){
        this.contexto = context;
        this.focoEndemias = focoEndemias;
    }

    @Override
    public int getCount() {
        return focoEndemias.size();
    }

    @Override
    public Object getItem(int position) {
        return focoEndemias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return focoEndemias.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linha_lista_foco_endemias, parent, false);
        TextView textViewNumeroAmostra = (TextView) viewLinha.findViewById(R.id.textNumeroAmostra);
        TextView textViewDeposito = (TextView) viewLinha.findViewById(R.id.textDeposito);


        FocoEndemia focoEndemia = (FocoEndemia) getItem(position);

        textViewNumeroAmostra.setText(focoEndemia.getNumeroAmostra());
        textViewDeposito.setText(focoEndemia.getDeposito());

        return viewLinha;
    }
}
