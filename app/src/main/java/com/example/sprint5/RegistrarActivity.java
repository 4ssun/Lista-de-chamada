package com.example.sprint5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity  implements View.OnClickListener {

    Button bttnRegistrar;
    EditText senhaRegistrar, emailRegistrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        emailRegistrar = (EditText) findViewById(R.id.emailRegistrar);
        senhaRegistrar = (EditText) findViewById(R.id.senhaRegistrar);
        bttnRegistrar = (Button) findViewById(R.id.bttnRegistrar);
        bttnRegistrar.setOnClickListener(this);
    }

    public void onClick(View v) {
        String EmailCad = emailRegistrar.getText().toString();
        String SenhaCad = senhaRegistrar.getText().toString();
        DBManage bd = new DBManage(getBaseContext());
        String result;

        if (!SenhaCad.isEmpty()) {
            result = bd.CriaUsuario(EmailCad, SenhaCad);
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        } else {
            String msg = "Crie uma senha válida!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }

    }
}