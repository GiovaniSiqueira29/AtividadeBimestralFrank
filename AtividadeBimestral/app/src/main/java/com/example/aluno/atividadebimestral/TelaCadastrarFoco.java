package com.example.aluno.atividadebimestral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.aluno.atividadebimestral.banco.DAOFocoEndemia;

public class TelaCadastrarFoco extends AppCompatActivity {

    FocoEndemia focoEndemia = new FocoEndemia();
    EditText editTextNumeroAmostra;
    EditText editTextDeposito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_foco);
        editTextNumeroAmostra = (EditText) findViewById(R.id.editNumeroAmostra);
        editTextDeposito = (EditText) findViewById(R.id.editDeposito);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null && bundle.containsKey("id")){
            Integer id = bundle.getInt("id");
            Log.i("Tela",""+id);
            focoEndemia = new DAOFocoEndemia(this).buscarPorId(id);
            editTextNumeroAmostra.setText(focoEndemia.getNumeroAmostra());
            editTextDeposito.setText(focoEndemia.getDeposito());
        }
    }

    public void inserir(View view){
        focoEndemia.setNumeroAmostra(editTextNumeroAmostra.getText().toString());
        focoEndemia.setDeposito(editTextDeposito.getText().toString());
        if(focoEndemia.getId()==null) {
            new DAOFocoEndemia(this).inserir(focoEndemia);
        }else{
            new DAOFocoEndemia(this).alterar(focoEndemia);
        }

        //Solução ruim
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
        finish();
    }
}