package com.example.aluno.atividadebimestral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaCalcularIndicesEpidemologicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calcular_indices_epidemologicos);
    }
    public void chamarTelaCalcularIndicePredial(View view){
        Intent intent = new Intent(this, TelaCalcularIndicePredial.class);
        startActivity(intent);
    }
    public void chamarTelaCadastroPessoa(View view){
        Intent intent = new Intent(this, CadastroPessoa.class);
        startActivity(intent);
    }
}
