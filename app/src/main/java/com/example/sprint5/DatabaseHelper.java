package com.example.sprint5;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "my_app.db";
    private static final int DATABASE_VERSION = 1;

    // Define constructor
    public DatabaseHelper(Context context) {
        super(context, NOME_BANCO, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS cadastrados (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "email TEXT NOT NULL," +
                "senha TEXT NOT NULL," +
                "UNIQUE(email)," +
                "UNIQUE(_id));";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
