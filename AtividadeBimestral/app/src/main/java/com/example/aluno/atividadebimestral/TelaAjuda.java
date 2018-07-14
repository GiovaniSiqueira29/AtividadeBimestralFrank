package com.example.aluno.atividadebimestral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaAjuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ajuda);
    }

    public void buscarImagem(View view){
        BuscarImagem buscarImagem = new BuscarImagem(this);
        buscarImagem.execute("http://mariaimaculada.br/wp-content/uploads/dengue_cuidados.jpg");
    }
}
