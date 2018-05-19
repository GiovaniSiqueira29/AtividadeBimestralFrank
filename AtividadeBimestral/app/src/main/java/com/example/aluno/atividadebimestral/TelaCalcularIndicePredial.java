package com.example.aluno.atividadebimestral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCalcularIndicePredial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_calcular_indice_predial);
    }
    public void calcularInfestacao(View view){
        EditText editTextValor1 = (EditText) findViewById(R.id.editValor1);
        EditText editTextValor2 = (EditText) findViewById(R.id.editValor2);


        Double valor1 = Double.parseDouble(editTextValor1.getText().toString());
        Double valor2 = Double.parseDouble(editTextValor2.getText().toString());

        Double resultadoIndice =0.;

        resultadoIndice = valor1 / valor2;

        if(resultadoIndice < 1.){
            Toast.makeText(this, "O seu índice de infestação é: "+resultadoIndice*100+"%", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "ALERTA! O seu índice de infestação é: "+resultadoIndice*100+"%", Toast.LENGTH_LONG).show();
        }
    }
}
