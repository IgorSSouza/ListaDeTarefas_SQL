package com.example.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 2;
    public static String NOME_DB = "DB_TAREFAS";
    public static  String TABELA_TAREFAS = "tarefas";

    public DbHelper(@Nullable Context context ) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table " + TABELA_TAREFAS +
                    "(id integer primary key autoincrement," +
                    "nome text not null);";


        try {

            db.execSQL( sql );
            Log.i("INFO", "Sucesso ao criar a tabela");
        }catch(Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "drop table " + TABELA_TAREFAS+ " ;";


        try {

            db.execSQL( sql );
            onCreate(db);
            Log.i("INFO", "Sucesso ao Atualizar a tabela");
        }catch(Exception e){
            Log.i("INFO DB", "Erro ao Atualizar a tabela" + e.getMessage());
        }

    }
}
