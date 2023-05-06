package com.example.sprint5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManage {

    private SQLiteDatabase db;
    private CreateDB banco;

    public DBManage(Context context) {
        banco = new CreateDB(context);
    }

    public String CriaUsuario(String email, String senha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("email", email);
        valores.put("senha", senha);

        resultado = db.insert("cadastrados", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao cadastrar informações";
        else
            return "Usuário criado com sucesso";
    }
    public Cursor LoginData(String Email, String Senha) {
        Cursor cursor;
        String[] campos = { "email", "senha" };
        String where = "email = '" + Email + "' and senha = '" + Senha + "'";
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
