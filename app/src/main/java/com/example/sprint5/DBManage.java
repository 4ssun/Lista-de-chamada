package com.example.sprint5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import com.example.sprint5.DatabaseHelper;

public class DBManage {

    private SQLiteDatabase db;
    private DatabaseHelper banco;

    public DBManage(Context context) {
        banco = new DatabaseHelper(context);
    }



    public String insereDadosCadastrados(String email, String senha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("email", email);
        valores.put("senha", senha);

        resultado = db.insert("cadastrados", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro os dados, tente novamente!";
        else
            return "Dados do Usuário cadastrado com sucesso!";
    }



    public Cursor carregaDadosLogin(String email, String senha) {
        Cursor cursor;
        String[] campos = { "codigo", "nome", "email", "senha" };
        String where = "email = '" + email + "' and senha = '" + senha + "'";
        db = banco.getReadableDatabase();
        cursor = db.query("cadastrados", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }


}