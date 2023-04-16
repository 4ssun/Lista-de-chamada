package com.example.sprint5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RegistrarActivity extends AppCompatActivity implements View.OnClickListener {
    Button bttnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        bttnRegistrar = (Button) findViewById(R.id.bttnRegistrar);
        bttnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bttnRegistrar) {
            Intent intencao = new Intent(this, LoginActivity.class);
            startActivity(intencao);
        }
    }
}
