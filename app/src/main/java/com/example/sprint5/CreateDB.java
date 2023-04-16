package com.example.sprint5;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDB extends SQLiteOpenHelper {
    private static final String Nome_BD = "banco.db";
    private static final int Version = 2;
    public CreateDB(Context context){ super(context, Nome_BD, null, Version);}

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "CREATE TABLE cadastrados ("
            + "codigo integer primary key autoincrement,"
            + "email text,"
            + "senha text)";
    db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS cadastrados");
    onCreate(db);
    }
}
