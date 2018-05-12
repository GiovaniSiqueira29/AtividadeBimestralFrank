package com.example.aluno.atividadebimestral.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.aluno.atividadebimestral.FocoEndemia;

import java.util.ArrayList;
import java.util.List;


public class DAOFocoEndemia {

    SQLiteDatabase database;

    public DAOFocoEndemia(Context context){
        database = new BDCore(context).getWritableDatabase();
    }

    public void inserir(FocoEndemia focoEndemia){
        Log.i("DAOLancamentos",focoEndemia.getNumeroAmostra());
        ContentValues values = new ContentValues();
        values.put("numeroAmostra",focoEndemia.getNumeroAmostra());
        values.put("deposito", focoEndemia.getDeposito());
        database.insert("focoEndemia", null, values);
    }
    public void excluir(Integer id){
        database.delete("focoEndemia","id=?",
                new String[]{String.valueOf(id)});

        //database.delete("lancamentos","id="+id,null);
    }
    public void alterar(FocoEndemia focoEndemia){
        ContentValues values = new ContentValues();
        values.put("numeroAmostra",focoEndemia.getNumeroAmostra());
        values.put("deposito", focoEndemia.getDeposito());
        database.update("focoEndemia",values,
                "id="+focoEndemia.getId(),null);
    }
    public List<FocoEndemia> consultar(){
        List<FocoEndemia> focoEndemias = new ArrayList<>();
        String[] colunas = {"id", "numeroAmostra", "deposito"};
        Cursor cursor = database.query("focoEndemias", colunas,
                null,null,null,null,
                null);
        cursor.moveToFirst();
        for(int x=0; x<cursor.getCount(); x++){
            FocoEndemia focoEndemia = new FocoEndemia();
            focoEndemia.setId(cursor.getInt(0));
            focoEndemia.setNumeroAmostra(cursor.getString(1));
            focoEndemia.setDeposito(cursor.getString(2));
            focoEndemia.add(focoEndemia);
            cursor.moveToNext();
        }
        return focoEndemias;
    }

    public FocoEndemia buscarPorId(Integer id){
        FocoEndemia focoEndemia = new FocoEndemia();
        String[] colunas = {"id", "numeroAmostra", "deposito"};
        Cursor cursor = database.query("focoEndemia", colunas,
                "id="+id,null,null,null,
                null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            focoEndemia.setId(cursor.getInt(0));
            focoEndemia.setNumeroAmostra(cursor.getString(1));
            focoEndemia.setDeposito(cursor.getString(2));
        }
        return focoEndemia;
    }

}
