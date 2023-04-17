package com.example.sprint5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btAcessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btAcessar = (Button) findViewById(R.id.btAcessar);
        btAcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btAcessar) {
            Intent intencao = new Intent(this, Main.class);
            startActivity(intencao);
        }
    }
    // Inside your login activity
// Collect login credentials
    String email = "example@example.com";
    String senha = "mypassword";

    // Query "usuarios" table for email and password
    DatabaseHelper dbHelper = new DatabaseHelper(this);
    SQLiteDatabase db = dbHelper.getReadableDatabase();
    String selection = "email = ? AND senha = ?";
    String[] selectionArgs = {email, senha};
    Cursor cursor = db.query(
            "usuarios",
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
    );

}
