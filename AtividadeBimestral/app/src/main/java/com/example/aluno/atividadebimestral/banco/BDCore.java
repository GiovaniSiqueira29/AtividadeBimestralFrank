package com.example.aluno.atividadebimestral.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BDCore extends SQLiteOpenHelper{
    private final static String NOME_BANCO="focoEndemias";
    private final static Integer VERSAO_BANCO=1;

    public BDCore(Context context)  {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table focoEndemias(id integer primary key " +
                "autoincrement, " +
                "numeroAmostra varchar(200)," +
                "deposito varchar(100))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table focoEndemias");
        onCreate(db);
    }
}
