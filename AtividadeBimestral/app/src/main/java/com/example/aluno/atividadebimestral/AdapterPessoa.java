package com.example.aluno.atividadebimestral;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterPessoa extends BaseAdapter{
    List<Pessoa> pessoa;
    Context context;

    public AdapterPessoa(Context context, List<Pessoa> pessoa){
        this.context = context;
        this.pessoa = pessoa;
    }
    @Override
    public int getCount() {
        return pessoa.size();
    }

    @Override
    public Object getItem(int position) {
        return pessoa.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pessoa.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha = LayoutInflater.from(context).inflate(R.layout.linha_lista_pessoa, parent, false);
        TextView textViewNomePessoa = (TextView) viewLinha.findViewById(R.id.textViewNomePessoa);
        TextView textViewIdadePessoa = (TextView) viewLinha.findViewById(R.id.textViewIdadePessoa);
        TextView textViewQtdeDepositos = (TextView) viewLinha.findViewById(R.id.textViewQtdeDepositos);
        TextView textViewMulta = (TextView) viewLinha.findViewById(R.id.textViewMulta);

        Pessoa pessoa = (Pessoa) getItem(position);

        textViewNomePessoa.setText(pessoa.getNome());
        textViewIdadePessoa.setText(pessoa.getIdade());
        textViewQtdeDepositos.setText(pessoa.getQtdeDepositoEncontrado());
        textViewMulta.setText(""+ pessoa.getMulta());

        return viewLinha;
    }
}
