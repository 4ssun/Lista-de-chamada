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
        String createTableQuery = "CREATE TABLE IF NOT EXISTS cadastrados (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Email TEXT NOT NULL," +
                "Senha TEXT NOT NULL," +
                "UNIQUE(Email)," +
                "UNIQUE(_id));";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS cadastrados");
    onCreate(db);
    }
}
