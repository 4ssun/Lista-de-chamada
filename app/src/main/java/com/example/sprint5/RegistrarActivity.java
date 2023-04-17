package com.example.sprint5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        bttnRegistrar.setOnClickListener(this);
    }

    public void onClick(View v) {
        String EmailCad = emailRegistrar.getText().toString();
        String SenhaCad = senhaRegistrar.getText().toString();

    }
}