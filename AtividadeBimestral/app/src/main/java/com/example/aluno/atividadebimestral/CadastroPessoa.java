package com.example.aluno.atividadebimestral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class CadastroPessoa extends AppCompatActivity {

    ListView listView;
    Pessoa pessoa = new Pessoa();

    EditText editTextNomePessoa;
    EditText editTextIdadePessoa;
    EditText editTextQtdeDepositos;
    EditText editTextMulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        listView = findViewById(R.id.listaPessoa);
        listView.setOnItemClickListener();
        listView.setOnItemLongClickListener();

        editTextNomePessoa = (EditText) findViewById(R.id.editTextNomePessoa);
        editTextIdadePessoa = (EditText) findViewById(R.id.editTextIdadePessoa);
        editTextQtdeDepositos = (EditText) findViewById(R.id.editTextQtdeDepositos);
        editTextMulta = (EditText) findViewById(R.id.editTextMulta);

        //https://stackoverflow.com/questions/33031570/android-sugar-orm-no-such-table-exception
        //SugarContext.init(getApplicationContext());
        //SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        //schemaGenerator.createDatabase(new SugarDb(this).getDB());


        List<Pessoa> pessoa = Pessoa.listAll(Pessoa.class);
    }

}
