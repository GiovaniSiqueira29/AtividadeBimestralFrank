package com.example.aluno.atividadebimestral;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aluno.atividadebimestral.banco.DAOFocoEndemia;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listaFocoEndemia);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<FocoEndemia> listaLancamentos = new DAOFocoEndemia(this).consultar();
        AdapterFocoEndemia adapterFocoEndemia = new AdapterFocoEndemia(this, listaLancamentos);
        listView.setAdapter(adapterFocoEndemia);
    }

    public void chamarTelaCadastrar(View view){
        Intent intent = new Intent(this, TelaCadastrarFoco.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, TelaCadastrarFoco.class);
        intent.putExtra("id",Integer.parseInt(String.valueOf(id)));
        startActivity(intent);
    }
    private void atualizarLista(){
        List<FocoEndemia> listaFocoEndemias = new DAOFocoEndemia(this).consultar();
        AdapterFocoEndemia adapterFocoEndemia = new AdapterFocoEndemia(this, listaFocoEndemias);
        listView.setAdapter(adapterFocoEndemia);
    }
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        final DAOFocoEndemia daoFocoEndemia = new DAOFocoEndemia(this);
        final long idExcluir = id;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja Excluir o Registro??")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        daoFocoEndemia.excluir(Integer.parseInt(String.valueOf(idExcluir)));
                        atualizarLista();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        builder.show();

        return true;
    }
}
